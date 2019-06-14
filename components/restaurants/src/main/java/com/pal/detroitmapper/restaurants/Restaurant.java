package com.pal.detroitmapper.restaurants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String street_address;
    private String city;
    private String state;
    private String pincode;
    private String phone;
    private String email;
    private String cuisine;
    private String price_range;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, String street_address, String city, String state, String pincode, String phone, String email, String cuisine, String price_range) {
        this.id = id;
        this.name = name;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.email = email;
        this.cuisine = cuisine;
        this.price_range = price_range;
    }

    public Restaurant(String name, String street_address, String city, String state, String pincode, String phone, String email, String cuisine, String price_range) {
        this.name = name;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.email = email;
        this.cuisine = cuisine;
        this.price_range = price_range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(street_address, that.street_address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(pincode, that.pincode) &&
                phone.equals(that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cuisine, that.cuisine) &&
                Objects.equals(price_range, that.price_range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street_address, city, state, pincode, phone, email, cuisine, price_range);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }
}
