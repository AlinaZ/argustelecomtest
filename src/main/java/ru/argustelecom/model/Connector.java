package ru.argustelecom.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Connector")
public class Connector extends BaseEntity{

    /**
     * Уникальный идентификатор коннектора
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cu_id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя коннектора
     */
    @Column(name = "name", length = 25)
    private String name;

    /**
     * Емкость коннектора
     */
    @Column(name = "capacity")
    private Integer capacity;

    /**
     * Узел, в котором находится коннектор
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "node_id")
    private Node node;

    /**
     * Точки, которые входят в коннектор
     */
    @OneToMany(mappedBy = "connector",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Point> points;

    public Connector() {
    }

    public Connector(Integer cu_id, Integer version, String name, Integer capacity, Node node, Set<Point> points) {
        this.cu_id = cu_id;
        this.version = version;
        this.name = name;
        this.capacity = capacity;
        this.node = node;
        this.points = points;
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

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Connector{" +
                "cu_id=" + cu_id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", node=" + node.toString() +
                ", points=" + points.toString() +
                '}';
    }
}
