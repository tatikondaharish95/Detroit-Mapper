package com.pal.detroitmapper.apartments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ApartmentRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    public Apartment find(Long id) {
        return entityManager.find(Apartment.class, id);
    }

    @Transactional
    public void addApartment(Apartment apartment) {
        logger.debug("Creating apartment with name: {}", apartment.getName());

        entityManager.persist(apartment);
    }

    @Transactional
    public void updateApartment(Apartment apartment) {
        entityManager.merge(apartment);
    }

    @Transactional
    public void deleteApartment(Apartment apartment) {
        entityManager.remove(apartment);
    }

    @Transactional
    public void deleteApartmentId(Long id) {
        Apartment apartment = entityManager.find(Apartment.class, id);
        deleteApartment(apartment);
    }

    public List<Apartment> getApartments() {
        CriteriaQuery<Apartment> cq = entityManager.getCriteriaBuilder().createQuery(Apartment.class);
        cq.select(cq.from(Apartment.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Apartment> findAll(int firstResult, int maxResults) {
        CriteriaQuery<Apartment> cq = entityManager.getCriteriaBuilder().createQuery(Apartment.class);
        cq.select(cq.from(Apartment.class));
        TypedQuery<Apartment> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public int countAll() {
        CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder().createQuery(Long.class);
        Root<Apartment> rt = cq.from(Apartment.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        TypedQuery<Long> q = entityManager.createQuery(cq);
        return (q.getSingleResult()).intValue();
    }

    public int count(String field, String searchTerm) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<Apartment> root = cq.from(Apartment.class);
        EntityType<Apartment> type = entityManager.getMetamodel().entity(Apartment.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.select(qb.count(root));
        cq.where(condition);

        return entityManager.createQuery(cq).getSingleResult().intValue();
    }

    public List<Apartment> findRange(String field, String searchTerm, int firstResult, int maxResults) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Apartment> cq = qb.createQuery(Apartment.class);
        Root<Apartment> root = cq.from(Apartment.class);
        EntityType<Apartment> type = entityManager.getMetamodel().entity(Apartment.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.where(condition);
        TypedQuery<Apartment> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }
}
