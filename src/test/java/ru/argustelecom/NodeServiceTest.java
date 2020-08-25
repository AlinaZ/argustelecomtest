package ru.argustelecom;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.argustelecom.dao.NodeDao;
import ru.argustelecom.dao.PointDao;
import ru.argustelecom.model.Connector;
import ru.argustelecom.model.Node;
import ru.argustelecom.model.Point;
import ru.argustelecom.service.NodesService;
import ru.argustelecom.view.NodeView;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NodeServiceTest {
    @Mock
    private NodeDao nodeDaoMock;

    @Mock
    private PointDao pointDaoMock;

    @InjectMocks
    private NodesService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNodes() {
        List<Node> nodes = new ArrayList<>();
        Node node1 = new Node();
        node1.setNode_id(1);
        node1.setVersion(0);
        node1.setName("node1");
        node1.setRegion("Russia");
        node1.setStreet("Lenina");
        node1.setHouse("18");
        Point point1 = new Point();
        point1.setPoint_id(1);
        point1.setPoint_cu_id(1);
        Set<Point> points = new HashSet<>();
        points.add(point1);
        Connector cn1 = new Connector(1, 0, "connector1", 1, node1, points);
        Set<Connector> connectors = new HashSet<>();
        connectors.add(cn1);
        node1.setConnectors(connectors);
        nodes.add(node1);

        when(nodeDaoMock.all()).thenReturn(nodes);
        when(pointDaoMock.isPointFree(point1)).thenReturn(true);
        List<NodeView> nodesInfo = new ArrayList<NodeView>();
        NodeView nodeView1 = new NodeView();
        nodeView1.setNode_id(1);
        nodeView1.setName("node1");
        nodeView1.setRegion("Russia");
        nodeView1.setStreet("Lenina");
        nodeView1.setHouse("18");
        nodeView1.setConnectorsNumber(1);
        nodeView1.setPointsNumber(1);
        nodeView1.setFreePointsNumber(1);
        nodesInfo.add(nodeView1);
        List<NodeView> resultNodesInfo = service.getNodes();
        for (NodeView resultNodeInfo:resultNodesInfo) {
            assertEquals(resultNodeInfo.getNode_id(),node1.getNode_id());
            assertEquals(resultNodeInfo.getName(),node1.getName());
            assertEquals(resultNodeInfo.getRegion(),node1.getRegion());
            assertEquals(resultNodeInfo.getStreet(),node1.getStreet());
            assertEquals(resultNodeInfo.getHouse(),node1.getHouse());
            assertEquals(resultNodeInfo.getConnectorsNumber(),node1.getConnectors().size());
            assertEquals(resultNodeInfo.getPointsNumber(),1);
            assertEquals(resultNodeInfo.getFreePointsNumber(),1);
        }

    }

}
