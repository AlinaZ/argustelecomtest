package ru.argustelecom.view;

import java.util.List;

public class NodeLinksView {

    private Long node_id;

    List<LinkView> nodeLinks;

    public Long getNode_id() {
        return node_id;
    }

    public void setNode_id(Long node_id) {
        this.node_id = node_id;
    }

    public List<LinkView> getNodeLinks() {
        return nodeLinks;
    }

    public void setNodeLinks(List<LinkView> nodeLinks) {
        this.nodeLinks = nodeLinks;
    }
}
