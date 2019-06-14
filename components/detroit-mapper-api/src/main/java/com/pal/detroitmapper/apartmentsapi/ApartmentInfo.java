package com.pal.detroitmapper.apartmentsapi;


import java.util.Objects;

public class ApartmentInfo {

    private Long id;

    private String name;
    private float price;
    private String streetAddress;
    private String city;
    private String state;
    private int pincode;
    private String phone;
    private String email;
    private boolean oneBhk;
    private boolean twoBhk;
    private boolean threeBhk;
    private boolean fourBhk;

    public ApartmentInfo() {

    }
    public ApartmentInfo(String name, Float price, String streetAddress, String city, String state, int pincode,
                     String phone, String email, boolean oneBhk, boolean twoBhk, boolean threeBhk, boolean fourBhk) {

        this.name = name;
        this.price = price;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.email = email;
        this.oneBhk = oneBhk;
        this.twoBhk = twoBhk;
        this.threeBhk = threeBhk;
        this.fourBhk = fourBhk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
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

    public boolean isOneBhk() {
        return oneBhk;
    }

    public void setOneBhk(boolean oneBhk) {
        this.oneBhk = oneBhk;
    }

    public boolean isTwoBhk() {
        return twoBhk;
    }

    public void setTwoBhk(boolean twoBhk) {
        this.twoBhk = twoBhk;
    }

    public boolean isThreeBhk() {
        return threeBhk;
    }

    public void setThreeBhk(boolean threeBhk) {
        this.threeBhk = threeBhk;
    }

    public boolean isFourBhk() {
        return fourBhk;
    }

    public void setFourBhk(boolean fourBhk) {
        this.fourBhk = fourBhk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentInfo apartment = (ApartmentInfo) o;
        return pincode == apartment.pincode &&
                phone.equals(apartment.phone) &&
                oneBhk == apartment.oneBhk &&
                twoBhk == apartment.twoBhk &&
                threeBhk == apartment.threeBhk &&
                fourBhk == apartment.fourBhk &&
                Objects.equals(name, apartment.name) &&
                Objects.equals(price, apartment.price) &&
                Objects.equals(streetAddress, apartment.streetAddress) &&
                Objects.equals(city, apartment.city) &&
                Objects.equals(state, apartment.state) &&
                Objects.equals(email, apartment.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, streetAddress, city, state, pincode, phone, email, oneBhk, twoBhk, threeBhk, fourBhk);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}