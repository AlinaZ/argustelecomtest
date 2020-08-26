package ru.argustelecom;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.argustelecom.controller.NodeLinksController;
import ru.argustelecom.controller.NodesController;
import ru.argustelecom.service.NodeLinksService;
import ru.argustelecom.service.NodesService;
import ru.argustelecom.view.NodeLinksView;
import ru.argustelecom.view.NodeView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NodeLinksControllerTest {
    @Mock
    private NodeLinksService serviceMock;

    @InjectMocks
    private NodeLinksController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNodes() {
        NodeLinksView nodelinks=new NodeLinksView();
        when(serviceMock.getNodeLinks(controller.getNode_Id())).thenReturn(nodelinks);
        assertEquals(controller.getNodeLinks(),nodelinks);
    }
}
