package ru.argustelecom.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Node")
public class Node extends BaseEntity{

    @Id
    private Integer node_id;

    @Version
    private Integer version;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "region", length = 25)
    private String region;

    @Column(name = "street", length = 25)
    private String street;

    @Column(name = "house", length = 25)
    private String house;

    @OneToMany(mappedBy = "node",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Connector> connectors;

    public Node() {
    }

    public Integer getNode_id() {
        return node_id;
    }

    public void setNode_id(Integer node_id) {
        this.node_id = node_id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Set<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(Set<Connector> connectors) {
        this.connectors = connectors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node_id=" + node_id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}
