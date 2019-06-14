package com.pal.detroitmapper.restaurants;

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
public class RestaurantRepository {
    private final Logger logger =LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    public Restaurant find(Long id) {
        return entityManager.find(Restaurant.class, id);
    }

    @Transactional
    public void addRestro(Restaurant restaurant) {
        logger.debug("Creating restaurant with name: {}", restaurant.getName());

        entityManager.persist(restaurant);
    }

    @Transactional
    public void updateRestro(Restaurant restaurant) {
        entityManager.merge(restaurant);
    }

    @Transactional
    public void deleteRestro(Restaurant restaurant) {
        entityManager.remove(restaurant);
    }

    @Transactional
    public void deleteRestroId(Long id) {
        Restaurant restaurant = entityManager.find(Restaurant.class, id);
        deleteRestro(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        CriteriaQuery<Restaurant> cq = entityManager.getCriteriaBuilder().createQuery(Restaurant.class);
        cq.select(cq.from(Restaurant.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Restaurant> findAll(int firstResult, int maxResults) {
        CriteriaQuery<Restaurant> cq = entityManager.getCriteriaBuilder().createQuery(Restaurant.class);
        cq.select(cq.from(Restaurant.class));
        TypedQuery<Restaurant> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public int countAll() {
        CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder().createQuery(Long.class);
        Root<Restaurant> rt = cq.from(Restaurant.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        TypedQuery<Long> q = entityManager.createQuery(cq);
        return (q.getSingleResult()).intValue();
    }

    public int count(String field, String searchTerm) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<Restaurant> root = cq.from(Restaurant.class);
        EntityType<Restaurant> type = entityManager.getMetamodel().entity(Restaurant.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.select(qb.count(root));
        cq.where(condition);

        return entityManager.createQuery(cq).getSingleResult().intValue();
    }

    public List<Restaurant> findRange(String field, String searchTerm, int firstResult, int maxResults) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurant> cq = qb.createQuery(Restaurant.class);
        Root<Restaurant> root = cq.from(Restaurant.class);
        EntityType<Restaurant> type = entityManager.getMetamodel().entity(Restaurant.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.where(condition);
        TypedQuery<Restaurant> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }
}
