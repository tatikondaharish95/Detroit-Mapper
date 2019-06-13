package com.pal.detroitmapper.restaurants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RestaurantRepository {
    private final Logger logger =LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager manager;

    public Restaurant find(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Transactional
    public void addRestro(Restaurant restaurant) {
        logger.debug("Creating restaurant with name: {}", restaurant.getName());

        manager.persist(restaurant);
    }

    @Transactional
    public void updateRestro(Restaurant restaurant) {
        manager.merge(restaurant);
    }

    @Transactional
    public void deleteRestro(Restaurant restaurant) {
        manager.remove(restaurant);
    }

    @Transactional
    public void deleteRestroId(Long id) {
        Restaurant restaurant = manager.find(Restaurant.class, id);
        deleteRestro(restaurant);
    }

    public List<Restaurant> findAll() {
        CriteriaQuery<Restaurant> cq = manager.getCriteriaBuilder().createQuery(Restaurant.class);
        cq.select(cq.from(Restaurant.class));
        return manager.createQuery(cq).getResultList();
    }
}
