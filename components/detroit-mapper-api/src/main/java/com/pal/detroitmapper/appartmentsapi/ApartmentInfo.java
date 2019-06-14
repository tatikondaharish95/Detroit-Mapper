package com.pal.detroitmapper.appartmentsapi;


import java.util.Objects;

public class ApartmentInfo {


    private int id;
    private String name;
    private String street_address;
    private long price;
    private String city;
    private String state;
    private long pincode;
    private String phone;
    private String email;
    private boolean bhk_1;
    private boolean bhk_2;
    private boolean bhk_3;

    public ApartmentInfo() {
    }

    public ApartmentInfo(String name, String street_address, long price, String city, String state, long pincode, String phone, String email, boolean bhk_1, boolean bhk_2, boolean bhk_3) {
        this.name = name;
        this.street_address = street_address;
        this.price = price;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.email = email;
        this.bhk_1 = bhk_1;
        this.bhk_2 = bhk_2;
        this.bhk_3 = bhk_3;

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
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

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBhk_1() {
        return bhk_1;
    }

    public void setBhk_1(boolean bhk_1) {
        this.bhk_1 = bhk_1;
    }

    public boolean isBhk_2() {
        return bhk_2;
    }

    public void setBhk_2(boolean bhk_2) {
        this.bhk_2 = bhk_2;
    }

    public boolean isBhk_3() {
        return bhk_3;
    }

    public void setBhk_3(boolean bhk_3) {
        this.bhk_3 = bhk_3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentInfo that = (ApartmentInfo) o;
        return id == that.id &&
                price == that.price &&
                pincode == that.pincode &&
                bhk_1 == that.bhk_1 &&
                bhk_2 == that.bhk_2 &&
                bhk_3 == that.bhk_3 &&
                name.equals(that.name) &&
                street_address.equals(that.street_address) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                phone.equals(that.phone) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street_address, price, city, state, pincode, phone, email, bhk_1, bhk_2, bhk_3);
    }
}
