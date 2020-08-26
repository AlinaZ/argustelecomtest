package ru.argustelecom;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.argustelecom.dao.LinkDao;
import ru.argustelecom.dao.NodeDao;
import ru.argustelecom.dao.PointDao;
import ru.argustelecom.model.Connector;
import ru.argustelecom.model.Link;
import ru.argustelecom.model.Node;
import ru.argustelecom.model.Point;
import ru.argustelecom.service.NodeLinksService;
import ru.argustelecom.service.NodesService;
import ru.argustelecom.view.LinkView;
import ru.argustelecom.view.NodeLinksView;
import ru.argustelecom.view.NodeView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NodeLinksServiceTest {

    @Mock
    private LinkDao linkDaoMock;

    @InjectMocks
    private NodeLinksService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNodeLinks() {

        //Создание тестовых данных, 2 узла, 2 коннектора, 2 точки, 1 связь
        Node node1 = new Node();
        node1.setNode_id(1);
        node1.setVersion(0);
        node1.setName("node1");
        node1.setRegion("Russia");
        node1.setStreet("Lenina");
        node1.setHouse("18");

        Node node2 = new Node();
        node2.setNode_id(2);
        node2.setVersion(0);
        node2.setName("node2");
        node2.setRegion("Russia");
        node2.setStreet("Lenina");
        node2.setHouse("25");

        Point point1 = new Point();
        point1.setPoint_id(1);
        point1.setPoint_cu_id(1);
        Set<Point> points1 = new HashSet<>();
        points1.add(point1);

        Point point2 = new Point();
        point2.setPoint_id(2);
        point2.setPoint_cu_id(1);
        Set<Point> points2 = new HashSet<>();
        points1.add(point2);

        Connector cn1 = new Connector(1, 0, "connector1", 1, node1, points1);
        Set<Connector> connectors1 = new HashSet<>();
        point1.setConnector(cn1);
        connectors1.add(cn1);
        node1.setConnectors(connectors1);

        Connector cn2 = new Connector(2, 0, "connector2", 1, node2, points2);
        Set<Connector> connectors2 = new HashSet<>();
        point2.setConnector(cn2);
        connectors2.add(cn2);
        node2.setConnectors(connectors2);

        Link link1 = new Link(1, 0, point1, point2);
        List<Link> links = new ArrayList<>();
        links.add(link1);

        when(linkDaoMock.all()).thenReturn(links);
        List<LinkView> nodeLinks1 = new ArrayList<>();
        LinkView linkView1 = new LinkView(1, 1, 2, 1, 1);
        nodeLinks1.add(linkView1);

        NodeLinksView nodeLinksView1 = new NodeLinksView();
        nodeLinksView1.setNode_id(1);
        nodeLinksView1.setNodeLinks(nodeLinks1);

        NodeLinksView nodeLinksView2 = new NodeLinksView();
        nodeLinksView2.setNode_id(2);
        nodeLinksView2.setNodeLinks(nodeLinks1);

        //Сравнение результата вызова метода сервиса для узлов 1 и 2 с тестовыми данными
        NodeLinksView result1 = service.getNodeLinks(1);
        assertEquals(result1.getNode_id(), nodeLinksView1.getNode_id());
        for (LinkView resultLinksInfo : result1.getNodeLinks()) {
            assertEquals(resultLinksInfo.getLink_id(), linkView1.getLink_id());
            assertEquals(resultLinksInfo.getConnector1_id(), linkView1.getConnector1_id());
            assertEquals(resultLinksInfo.getPoint1_cu_id(), linkView1.getPoint1_cu_id());
            assertEquals(resultLinksInfo.getConnector2_id(), linkView1.getConnector2_id());
            assertEquals(resultLinksInfo.getPoint2_cu_id(), linkView1.getPoint2_cu_id());
        }

        NodeLinksView result2 = service.getNodeLinks(2);
        assertEquals(result2.getNode_id(), nodeLinksView2.getNode_id());
        for (LinkView resultLinksInfo : result2.getNodeLinks()) {
            assertEquals(resultLinksInfo.getLink_id(), linkView1.getLink_id());
            assertEquals(resultLinksInfo.getConnector1_id(), linkView1.getConnector1_id());
            assertEquals(resultLinksInfo.getPoint1_cu_id(), linkView1.getPoint1_cu_id());
            assertEquals(resultLinksInfo.getConnector2_id(), linkView1.getConnector2_id());
            assertEquals(resultLinksInfo.getPoint2_cu_id(), linkView1.getPoint2_cu_id());
        }

    }
}
