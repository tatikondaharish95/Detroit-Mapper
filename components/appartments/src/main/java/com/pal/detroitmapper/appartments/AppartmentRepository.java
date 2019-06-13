package com.pal.detroitmapper.appartments;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AppartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAppartment(Appartment appartmentInfo) {
        this.entityManager.persist(appartmentInfo);
    }

    public Appartment find(long id) {
        return this.entityManager.find(Appartment.class,id);
    }

    public List<Appartment> find(String name) {
        Query q = this.entityManager.createNativeQuery("SELECT * FROM appartments WHERE appartment.name = :name");
        q.setParameter("name",name);
        List<Appartment> appartments = q.getResultList();
        return appartments;
    }


    public List<Appartment> getAppartments() {
        Query q = this.entityManager.createNativeQuery("SELECT * FROM appartments");
        List<Appartment> list = q.getResultList();
        return list;
    }


    @Transactional
    public void deleteAppartment(Appartment appartment) {
        entityManager.remove(appartment);
    }

    @Transactional
    public void updateAppartment(Appartment appartment) {
        entityManager.merge(appartment);
    }

}
