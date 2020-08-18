package ru.argustelecom.view;

import ru.argustelecom.model.Connector;

public class PointView {

    private Integer point_id;

    private Integer point_cu_id;

    private Connector connector;

    public PointView() {
    }

    public Integer getPoint_id() {
        return point_id;
    }

    public void setPoint_id(Integer point_id) {
        this.point_id = point_id;
    }

    public Integer getPoint_cu_id() {
        return point_cu_id;
    }

    public void setPoint_cu_id(Integer point_cu_id) {
        this.point_cu_id = point_cu_id;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    @Override
    public String toString() {
        return "Point{" +
                "point_id=" + point_id +
                ", point_cu_id=" + point_cu_id +
                ", connector=" + connector +
                '}';
    }
}
