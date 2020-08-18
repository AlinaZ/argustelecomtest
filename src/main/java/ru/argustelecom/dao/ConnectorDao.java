package ru.argustelecom.dao;

import ru.argustelecom.model.Connector;
import ru.argustelecom.model.Node;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConnectorDao {

    @PersistenceContext
    private EntityManager em;

    public List<Connector> loadAll() {
        TypedQuery<Connector> query = em.createQuery("SELECT cnctr FROM Connector cnctr", Connector.class);
        return query.getResultList();
    }

    public List<Connector> loadOfNode(Long node_id) {
        TypedQuery<Connector> query = em.createQuery("SELECT cnctr FROM Connector cnctr where cnctr.node="+node_id, Connector.class);
        return query.getResultList();
    }



}
