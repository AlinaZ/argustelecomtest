package ru.argustelecom.model;

/* point_id    INTEGER COMMENT 'Уникальный идентификатор точки в сети' PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    point_cu_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор точки в пределах коннектора',
    cu_id       INTEGER NOT NULL COMMENT 'Уникальный идентификатор коннектора'*/

import javax.persistence.*;

@Entity
@Table(name="Point")
public class Point extends BaseEntity{

    @Id
    private Integer point_id;

    @Version
    private Integer version;

    @Column(name = "point_cu_id")
    private Integer point_cu_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cu_id")
    private Connector connector;

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
                ", connector=" + connector +
                '}';
    }
}
