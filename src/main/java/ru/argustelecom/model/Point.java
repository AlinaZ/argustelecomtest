package ru.argustelecom.model;


import javax.persistence.*;

@Entity
@Table(name="Point")
public class Point extends BaseEntity{

    /**
     * Уникальный идентификатор точки в сети
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer point_id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Уникальный идентификатор точки в пределах коннектора
     */
    @Column(name = "point_cu_id")
    private Integer point_cu_id;

    /**
     * Коннектор, в котором находится точка
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cu_id")
    private Connector connector;

    public Point(Integer point_id, Integer version, Integer point_cu_id, Connector connector) {
        this.point_id = point_id;
        this.version = version;
        this.point_cu_id = point_cu_id;
        this.connector = connector;
    }

    public Point() {
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
                ", connector=" + connector.toString() +
                '}';
    }
}
