package ru.argustelecom.service;

import ru.argustelecom.dao.LinkDao;
import ru.argustelecom.dao.NodeDao;
import ru.argustelecom.dao.PointDao;
import ru.argustelecom.model.Link;
import ru.argustelecom.view.LinkView;
import ru.argustelecom.view.NodeLinksView;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

public class NodeLinksService {
    @EJB
    private NodeDao nodeDao;

    @EJB
    private PointDao pointDao;

    @EJB
    private LinkDao linkDao;

    public NodeLinksView getNodeLinks(Long id) {
        NodeLinksView nodeLinksView = new NodeLinksView();
        List<Link> links = linkDao.all();

        List<LinkView> nodeLinks = new ArrayList<>();

        for (Link link : links) {
            LinkView linkView = new LinkView();
            if (link.getPoint1().getConnector().getNode().getNode_id().equals(id)) {
                linkView.setLink_id(link.getLink_id());
                linkView.setConnector1_id(link.getPoint1().getConnector().getCu_id());
                linkView.setPoint1_cu_id(link.getPoint1().getPoint_cu_id());
                linkView.setConnector2_id(link.getPoint2().getConnector().getCu_id());
                linkView.setPoint2_cu_id(link.getPoint2().getPoint_cu_id());
                nodeLinks.add(linkView);
            }
        }

        nodeLinksView.setNode_id(id);
        nodeLinksView.setNodeLinks(nodeLinks);


        return nodeLinksView;
    }

}
