package ru.argustelecom.model;

import javax.persistence.*;

@Entity
@Table(name="Link")
public class Link extends BaseEntity{

    /**
     * Уникальный идентификатор связи в сети
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private Integer link_id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Начальная точка
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "point1_id")
    private Point point1;

    /**
     * Конечная точка
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "point2_id")
    private Point point2;

    public Link(Integer link_id, Integer version, Point point1, Point point2) {
        this.link_id = link_id;
        this.version = version;
        this.point1 = point1;
        this.point2 = point2;
    }

    public Link() {
    }

    public Integer getLink_id() {
        return link_id;
    }

    public void setLink_id(Integer link_id) {
        this.link_id = link_id;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "Link{" +
                "link_id=" + link_id +
                ", point1=" + point1.toString() +
                ", point2=" + point2.toString() +
                '}';
    }
}
