package it.unicam.cs.IDS.FidelityProgram;


import java.util.Objects;

/**
 * Simple class to store an address
 *
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public class Address {
    private String street;
    private int number;
    private String zipCode;
    private String city;
    private String province;
    private String country;

    public Address(String street, int number, String zipCode, String city, String country, String province) {
        this.street=Objects.requireNonNull(street);
        this.city =Objects.requireNonNull(city);
        this.country=Objects.requireNonNull(country);
        this.province= Objects.requireNonNull(province);
        this.number=Objects.requireNonNull(number);
        this.zipCode = Objects.requireNonNull(zipCode);

    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
