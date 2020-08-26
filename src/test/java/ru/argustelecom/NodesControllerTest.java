package ru.argustelecom;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.argustelecom.controller.NodesController;
import ru.argustelecom.service.NodesService;
import ru.argustelecom.view.NodeView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NodesControllerTest {
    @Mock
    private NodesService serviceMock;

    @InjectMocks
    private NodesController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNodes() {
        List<NodeView> nodes=new ArrayList<NodeView>();
        when(serviceMock.getNodes()).thenReturn(nodes);
        assertEquals(controller.getNodes(), nodes);
    }
}
