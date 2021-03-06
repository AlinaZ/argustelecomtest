package ru.argustelecom.dao;

import ru.argustelecom.model.Connector;
import ru.argustelecom.model.Point;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateful
public class PointDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * Метод проверяет, участвует ли точка в каких-либо связях
     * @param point
     * @return
     */

    public boolean isPointFree(Point point) {
        Query query = em.createQuery("select count(*) from Link l where l.point1.point_id=" + point.getPoint_id() +
                " or l.point2.point_id=" + point.getPoint_id());
        Long linkedPoint = (Long) query.getSingleResult();
        if (linkedPoint > 0) {
            return false;
        } else {
            return true;
        }
    }

}
