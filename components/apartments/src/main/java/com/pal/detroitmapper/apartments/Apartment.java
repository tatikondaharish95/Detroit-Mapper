package com.pal.detroitmapper.apartments;

import java.util.Objects;

public class Apartment {
    private String name;
    private Float price;
    private String streetAdress;
    private String city;
    private String state;
    private int pincode;
    private int phone;
    private String email;
    private boolean oneBhk;
    private boolean twoBhk;

    private boolean threeBhk;
    private boolean fourBhk;

    public Apartment() {

    }
    public Apartment(String name, Float price, String streetAdress, String city, String state, int pincode,
                     int phone, String email, boolean oneBhk, boolean twoBhk, boolean threeBhk, boolean fourBhk) {

        this.name = name;
        this.price = price;
        this.streetAdress = streetAdress;
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

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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
        Apartment apartment = (Apartment) o;
        return pincode == apartment.pincode &&
                phone == apartment.phone &&
                oneBhk == apartment.oneBhk &&
                twoBhk == apartment.twoBhk &&
                threeBhk == apartment.threeBhk &&
                fourBhk == apartment.fourBhk &&
                Objects.equals(name, apartment.name) &&
                Objects.equals(price, apartment.price) &&
                Objects.equals(streetAdress, apartment.streetAdress) &&
                Objects.equals(city, apartment.city) &&
                Objects.equals(state, apartment.state) &&
                Objects.equals(email, apartment.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, streetAdress, city, state, pincode, phone, email, oneBhk, twoBhk, threeBhk, fourBhk);
    }

}
