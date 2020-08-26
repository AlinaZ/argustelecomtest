package ru.argustelecom.view;

public class LinkView {

    private Integer link_id;

    private Integer connector1_id;

    public LinkView(Integer link_id, Integer connector1_id, Integer connector2_id, Integer point1_cu_id, Integer point2_cu_id) {
        this.link_id = link_id;
        this.connector1_id = connector1_id;
        this.connector2_id = connector2_id;
        this.point1_cu_id = point1_cu_id;
        this.point2_cu_id = point2_cu_id;
    }

    private Integer connector2_id;

    public Integer getLink_id() {
        return link_id;
    }

    public void setLink_id(Integer link_id) {
        this.link_id = link_id;
    }

    public Integer getConnector1_id() {
        return connector1_id;
    }

    public void setConnector1_id(Integer connector1_id) {
        this.connector1_id = connector1_id;
    }

    public Integer getConnector2_id() {
        return connector2_id;
    }

    public void setConnector2_id(Integer connector2_id) {
        this.connector2_id = connector2_id;
    }

    public Integer getPoint1_cu_id() {
        return point1_cu_id;
    }

    public void setPoint1_cu_id(Integer point1_cu_id) {
        this.point1_cu_id = point1_cu_id;
    }

    public Integer getPoint2_cu_id() {
        return point2_cu_id;
    }

    public void setPoint2_cu_id(Integer point2_cu_id) {
        this.point2_cu_id = point2_cu_id;
    }

    private Integer point1_cu_id;

    private Integer point2_cu_id;

    public LinkView() {
    }


}
