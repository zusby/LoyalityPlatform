package it.unicam.cs.IDS.FidelityProgram;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *Simple class to store an address
 *
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public class Address {
    private String street;
    private int number;
    private int zipCode;
    private String city;
    private String country;
    private String province;

    private final String path = "/Users/kacperosicki/Desktop/IDSFidelityProgram/LoyalityPlatform/IDSFidelityProgram/app/src/main/resources/Comuni.json";

    Gson gson = new Gson();

    // Leggi il file JSON come risorsa del tuo progetto
    InputStream inputStream = getResourceAsStream("resources/Comuni.json");
    InputStreamReader reader = new InputStreamReader(inputStream);

    // Converte il file JSON in un oggetto JsonObject
    JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

    List<String> capList = new ArrayList<>();    JSONParser parser = new JSONParser();
    private final Object comuni = parser.parse(new FileReader(path));
    JSONArray zip =  (JSONArray)comuni;


    public Address(String street, int number, String zipCode, String city, String country, String province) throws IOException, ParseException {
        Objects.requireNonNull(street);
        Objects.requireNonNull(city);
        Objects.requireNonNull(country);
        Objects.requireNonNull(province);
        if(street.length()<50){
            this.street=street;
        }if(number<1000) {
            this.number = number;
        }
        for(Object s : zip){
        }pa
            if(zip.contains(zipCode)){
                System.out.println("ci sono!");


        }if(!city.isBlank() ||  city.length()>3 ){
            this.city=city;
        }if(!country.isBlank() || country.length()>3 ) {
            this.country = country;
        }if (province.length()<3){
            this.province = province;
        }





    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }






}