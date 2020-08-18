package ru.argustelecom.view;

import ru.argustelecom.model.Node;


public class ConnectorView {

    private Integer cu_id;

    private String name;

    private Integer capacity;

    private Node node;

    public ConnectorView() {
    }

    public Integer getCu_id() {
        return cu_id;
    }

    public void setCu_id(Integer cu_id) {
        this.cu_id = cu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Connector{" +
                "cu_id=" + cu_id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", node=" + node +
                '}';
    }
}
