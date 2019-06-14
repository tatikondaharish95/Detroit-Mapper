package com.pal.detroitmapper.appartments;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ApartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAppartment(Apartment apartmentInfo) {
        this.entityManager.persist(apartmentInfo);
    }

    public Apartment find(long id) {
        return this.entityManager.find(Apartment.class,id);
    }

    public List<Apartment> find(String name) {
        Query q = this.entityManager.createNativeQuery("SELECT * FROM apartments WHERE appartment.name = :name");
        q.setParameter("name",name);
        List<Apartment> apartments = q.getResultList();
        return apartments;
    }


    public List<Apartment> getAppartments() {
        Query q = this.entityManager.createNativeQuery("SELECT * FROM appartments");
        List<Apartment> list = q.getResultList();
        return list;
    }


    @Transactional
    public void deleteAppartment(Apartment apartment) {
        entityManager.remove(apartment);
    }

    @Transactional
    public void updateAppartment(Apartment apartment) {
        entityManager.merge(apartment);
    }

}
