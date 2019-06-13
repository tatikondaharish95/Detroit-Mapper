package com.pal.detroitmapper.restaurantsapi;

import java.util.Objects;

public class RestaurantInfo {

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

    public RestaurantInfo(){

    }
    public RestaurantInfo(String name, String street_address, String city, String state, String pincode, String phone, String email, String cuisine, String price_range) {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getPrice_range() {
        return price_range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantInfo that = (RestaurantInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(street_address, that.street_address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(pincode, that.pincode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cuisine, that.cuisine) &&
                Objects.equals(price_range, that.price_range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street_address, city, state, pincode, phone, email, cuisine, price_range);
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street_address='" + street_address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", price_range='" + price_range + '\'' +
                '}';
    }
}
