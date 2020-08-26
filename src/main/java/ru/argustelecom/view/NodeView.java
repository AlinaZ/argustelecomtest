package ru.argustelecom.view;

public class NodeView {

    private Integer node_id;

    private String name;

    private String region;

    private String street;

    private String house;

    private int connectorsNumber;

    private int pointsNumber;

    private int freePointsNumber;

    public NodeView() {
    }

    public int getFreePointsNumber() {
        return freePointsNumber;
    }

    public void setFreePointsNumber(int freePointsNumber) {
        this.freePointsNumber = freePointsNumber;
    }

    public Integer getNode_id() {
        return node_id;
    }

    public void setNode_id(Integer node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getConnectorsNumber() {
        return connectorsNumber;
    }

    public void setConnectorsNumber(int connectorsNumber) {
        this.connectorsNumber = connectorsNumber;
    }

    public int getPointsNumber() {
        return pointsNumber;
    }

    public void setPointsNumber(int pointsNumber) {
        this.pointsNumber = pointsNumber;
    }

}
