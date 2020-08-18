package ru.argustelecom.dao;

import ru.argustelecom.model.Connector;
import ru.argustelecom.model.Point;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PointDao {

    @PersistenceContext
    private EntityManager em;

    public List<Point> loadAll() {
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        return query.getResultList();
    }

    public boolean isPointFree(Point point) {
        Query query = em.createQuery("select count(*) from Link l where l.point1.point_id=" + point.getPoint_id() +
                " or l.point2.point_id=" + point.getPoint_id());
        Integer linkedPoint = (Integer) query.getSingleResult();
        if (linkedPoint > 0) {
            return true;
        } else {
            return false;
        }
    }

}
