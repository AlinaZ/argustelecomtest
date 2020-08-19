package ru.argustelecom.dao;

import ru.argustelecom.model.Node;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateful
public class NodeDao {

    @PersistenceContext
    private EntityManager em;

    public List<Node> all() {
        TypedQuery<Node> query = em.createQuery("SELECT n FROM Node n", Node.class);
        return query.getResultList();
    }

}
