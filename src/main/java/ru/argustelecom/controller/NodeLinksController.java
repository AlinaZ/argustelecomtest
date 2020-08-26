package ru.argustelecom.controller;

import ru.argustelecom.service.NodeLinksService;
import ru.argustelecom.view.NodeLinksView;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NodeLinksController {

    private Integer node_Id;

    @EJB
    private NodeLinksService service;

    public Integer getNode_Id() {
        return node_Id;
    }

    public void setNode_Id(Integer node_Id) {
        this.node_Id = node_Id;
    }

    public String createNodeLinksPage(Integer node_Id) {
        this.node_Id = node_Id;
        return "nodelinks.xhtml?faces-redirect=true";
    }

      public NodeLinksView getNodeLinks() {
        return service.getNodeLinks(node_Id);
    }
}
