package ru.argustelecom.controller;

import ru.argustelecom.service.NodesService;
import ru.argustelecom.view.NodeView;

import javax.ejb.EJB;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NodesController {

    @EJB
    private NodesService service;

    public List<NodeView> getNodes() {
        return service.getNodes();
    }
}
