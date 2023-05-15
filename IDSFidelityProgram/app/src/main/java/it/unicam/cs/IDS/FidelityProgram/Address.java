package it.unicam.cs.IDS.FidelityProgram;


import java.util.Objects;

/**
 * Simple class to store an address
 *
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public class Address {
    private String street;
    private int streetNumber;
    private String zipCode;
    private String city;
    private String province;
    private String country;



    public Address(String street, int streetNumber, String zipCode, String city, String province, String country) {
        Objects.requireNonNull(street);
        Objects.requireNonNull(city);
        Objects.requireNonNull(province);
        Objects.requireNonNull(country);

        if (street.length() > 50 || street.isEmpty()) {
            throw new IllegalArgumentException("Invalid street length");
        }
        if (streetNumber < 1000 || streetNumber !=0) {
            throw new IllegalArgumentException("Invalid street number");
        }
        if (zipCode == null || zipCode.isEmpty() || !zipCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Invalid zip code");
        }
        if (city.isEmpty() || city.length() > 50) {
            throw new IllegalArgumentException("Invalid city");
        }
        if (province.isEmpty() || province.length() > 50) {
            throw new IllegalArgumentException("Invalid province");
        }
        if (country.isEmpty() || country.length() > 50) {
            throw new IllegalArgumentException("Invalid country");
        }

        this.street = street;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public void setCity(String city) {
        if (city.isEmpty() || city.length() > 50) {
            throw new IllegalArgumentException("Invalid city");
        }
        this.city = city;
    }

    public void setProvince(String province) {
        if (province.isEmpty() || province.length() > 50) {
            throw new IllegalArgumentException("Invalid province");
        }
        this.province = province;
    }

    public void setCountry(String country) {
        if (country.isEmpty() || country.length() > 50) {
            throw new IllegalArgumentException("Invalid country");
        }
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        if (streetNumber < 1) {
            throw new IllegalArgumentException("Invalid street number");
        }
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty() || !zipCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Invalid zip code");
        }
        this.zipCode = zipCode;
    }


    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }
}

