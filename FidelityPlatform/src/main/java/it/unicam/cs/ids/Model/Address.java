package it.unicam.cs.ids.Model;

import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Simple class to store an address
 *
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public class Address {

    private String street, zipCode, city, province;

    /**
     * avoid using, used to populate an address when parsing from an API call
     */
    public Address() {

    }

    public Address(String street, String zipCode, String city, String province) {
        this.street = Objects.requireNonNull(street);
        this.city = Objects.requireNonNull(city);
        this.province = Objects.requireNonNull(province);
        this.zipCode = Objects.requireNonNull(zipCode);
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

