package ru.argustelecom.dao;

import ru.argustelecom.model.Link;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class LinkDao {

    @PersistenceContext
    private EntityManager em;

    public List<Link> all() {
        TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l", Link.class);
        return query.getResultList();
    }

}
