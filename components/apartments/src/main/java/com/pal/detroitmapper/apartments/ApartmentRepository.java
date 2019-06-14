package com.pal.detroitmapper.apartments;

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
    public void addApartment(Apartment apartmentInfo) {
        this.entityManager.persist(apartmentInfo);
    }

    public Apartment find(long id) {
        return this.entityManager.find(Apartment.class,id);
    }

    public List<Apartment> find(String name) {
        Query q = this.entityManager.createNativeQuery("SELECT * FROM apartments WHERE apartment.name = :name");
        q.setParameter("name",name);
        List<Apartment> apartments = q.getResultList();
        return apartments;
    }


    public List<Apartment> getApartments() {
        Query q = this.entityManager.createNativeQuery("SELECT * FROM apartments");
        List<Apartment> list = q.getResultList();
        return list;
    }


    @Transactional
    public void deleteApartment(Apartment apartment) {
        entityManager.remove(apartment);
    }

    @Transactional
    public void updateApartment(Apartment apartment) {
        entityManager.merge(apartment);
    }

}
