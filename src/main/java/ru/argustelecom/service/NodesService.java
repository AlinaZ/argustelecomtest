package ru.argustelecom.service;

import ru.argustelecom.dao.NodeDao;
import ru.argustelecom.dao.PointDao;
import ru.argustelecom.model.Connector;
import ru.argustelecom.model.Node;
import ru.argustelecom.model.Point;
import ru.argustelecom.view.NodeView;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class NodesService {

    @EJB
    private NodeDao nodeDao;

    @EJB
    private PointDao pointDao;

    public List<NodeView> getNodes() {
        List<NodeView> nodesInfo = new ArrayList<NodeView>();
        List<Node> nodes = nodeDao.all();
        for (Node node : nodes) {
            NodeView nodeView = new NodeView();
            nodeView.setNode_id(node.getNode_id());
            nodeView.setName(node.getName());
            nodeView.setRegion(node.getRegion());
            nodeView.setStreet(node.getStreet());
            nodeView.setHouse(node.getHouse());
            nodeView.setConnectorsNumber(node.getConnectors().size());
            Integer allPointsNum = 0;
            Integer freePointsNum = 0;
            for (Connector c : node.getConnectors()) {
                allPointsNum += c.getCapacity();
                for (Point p : c.getPoints()) {
                    if (pointDao.isPointFree(p) == true) {
                        freePointsNum++;
                    }
                }
            }
            nodeView.setPointsNumber(allPointsNum);
            nodeView.setFreePointsNumber(freePointsNum);
            nodesInfo.add(nodeView);
        }
        return nodesInfo;
    }
}
