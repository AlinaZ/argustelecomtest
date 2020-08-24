package ru.argustelecom.controller;

import ru.argustelecom.service.NodeLinksService;
import ru.argustelecom.service.NodesService;
import ru.argustelecom.view.NodeLinksView;
import ru.argustelecom.view.NodeView;

import javax.ejb.EJB;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NodeLinksController {

    public Integer getNode_Id() {
        return node_Id;
    }

    public void setNode_Id(Integer node_Id) {
        this.node_Id = node_Id;
    }

    private Integer node_Id;

    @EJB
    private NodeLinksService service;

    public String createNodeLinksPage(Integer node_Id) {
        this.node_Id = node_Id;
        return "nodelinks.xhtml?faces-redirect=true";
    }

    /*public NodeLinksView getNodeLinky() {
        NodeLinksView nlkvw = new NodeLinksView();
        nlkvw.setNode_id(1);
        return nlkvw;
    }*/


    public NodeLinksView getNodeLinks() {
        System.out.println("controller nodelinks has been called");
        return service.getNodeLinks(node_Id);
    }
}
