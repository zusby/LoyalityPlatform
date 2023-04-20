package it.unicam.cs.IDS.FidelityProgram;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.util.List;
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


    private static final String PATH = "app/src/main/resources/Comuni.json";

    private static final Gson gson = new Gson();
    private static final JsonArray jsonArray;

    static {
        // Load JSON file as a resource
        try {
            jsonArray = gson.fromJson(new FileReader(PATH), JsonArray.class);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }






    public Address(String street, int number, String zipCode, String city, String country, String province) throws FileNotFoundException {
        Objects.requireNonNull(street);
        Objects.requireNonNull(city);
        Objects.requireNonNull(country);
        Objects.requireNonNull(province);

        if (street.length() < 50) {
            this.street = street;
        }
        if (number < 1000) {
            this.number = number;

        }


        // Leggi il file JSON dei comuni e crea una mappa con il nome del comune come chiave e l'oggetto Comune come valore
        Map<String, Comune> comuniMap = new HashMap<>();
        Gson gson = new Gson();
        InputStream inputStream = getClass().getResourceAsStream("/Comuni.json");
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonArray comuniArray = gson.fromJson(new FileReader(PATH), JsonArray.class);

        List<JsonObject> comuniList = gson.fromJson(comuniArray, new TypeToken<List<JsonObject>>() {}.getType());

        int n = 0;

        for (JsonObject comuneObject : comuniList) {
            String nomeComune = comuneObject.get("nome").getAsString();

            String provincia = comuneObject.get("provincia").getAsJsonObject().get("nome").getAsString();



            if(comuneObject.get("cap") instanceof JsonArray){
                JsonArray arr = comuneObject.get("cap").getAsJsonArray();
                String cap = arr.get(0).getAsString();
                Comune comune = new Comune(provincia, cap);
                comuniMap.put(nomeComune, comune);
            }
            else{
                String cap =comuneObject.get("cap").getAsString();
                Comune comune = new Comune(provincia, cap);
                comuniMap.put(nomeComune, comune);
            }


        }


        // Verifica che il CAP sia corretto per la provincia e il comune specificati
        Comune comune = comuniMap.get(city);
        if (comune != null && comune.getProvince().equals(province) && comune.getZipcode().equals(String.valueOf(zipCode))) {
            this.zipCode = zipCode;
            this.city = city;
            this.province = province;
        } else {
            System.out.println("Wrong credencial");
        }
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
