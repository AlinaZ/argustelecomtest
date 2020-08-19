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

    @EJB
    private NodeLinksService service;

    public NodeLinksView getNodeLinks(Long id) {
        return service.getNodeLinks(id);
    }
}
