package ru.argustelecom.model;
/*cu_id    INTEGER COMMENT 'Уникальный идентификатор коннектора' PRIMARY KEY AUTO_INCREMENT,
    version  INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    name     VARCHAR NOT NULL COMMENT 'Имя коннектора',
    capacity INTEGER NOT NULL COMMENT 'Емкость коннектора',
    node_id  INTEGER NOT NULL COMMENT 'Уникальный идентификатор узла, в котором находится коннектор'*/

import javax.persistence.*;

@Entity
@Table(name="Connector")
public class Connector extends BaseEntity{

    @Id
    private Integer cu_id;

    @Version
    private Integer version;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "node_id")
    private Node node;

    public Connector() {
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
