package com.pal.detroitmapper.apartmentsapi;

import java.util.Objects;

public class ApartmentInfo {

    private Long id;
    private String name;
    private String street_address;
    private long price;
    private String city;
    private String state;
    private String pincode;
    private String phone;
    private String email;
    private boolean bhk_1;
    private boolean bhk_2;
    private boolean bhk_3;

    public ApartmentInfo() {
    }

    public ApartmentInfo(String name, Long price, String street_address, String city, String state,
                         String pincode, String phone, String email, Boolean bhk_1,
                         Boolean bhk_2, Boolean bhk_3) {
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

    public ApartmentInfo(String name, String street_address, long price, String city, String state, String pincode, String phone, String email, boolean bhk_1, boolean bhk_2, boolean bhk_3) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(o instanceof ApartmentInfo)) return false;
        ApartmentInfo that = (ApartmentInfo) o;
        return getId() == that.getId() &&
                getPrice() == that.getPrice() &&
                getPincode() == that.getPincode() &&
                isBhk_1() == that.isBhk_1() &&
                isBhk_2() == that.isBhk_2() &&
                isBhk_3() == that.isBhk_3() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStreet_address(), that.getStreet_address()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet_address(), getPrice(), getCity(), getState(), getPincode(), getPhone(), getEmail(), isBhk_1(), isBhk_2(), isBhk_3());
    }

    @Override
    public String toString() {
        return "ApartmentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street_address='" + street_address + '\'' +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bhk_1=" + bhk_1 +
                ", bhk_2=" + bhk_2 +
                ", bhk_3=" + bhk_3 +
                '}';
    }
}
