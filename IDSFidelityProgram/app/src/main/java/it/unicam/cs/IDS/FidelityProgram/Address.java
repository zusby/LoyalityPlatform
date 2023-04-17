package it.unicam.cs.IDS.FidelityProgram;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import 
/**
 * Simple class to store an address
 *
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public class Address {
    private String street;
    private int number;
    private int zipCode;
    private String city;
    private String province;
    private String country;

    private static final String PATH = "/Users/kacperosicki/Desktop/IDSFidelityProgram/LoyalityPlatform/IDSFidelityProgram/app/src/main/resources/Comuni.json";
    private static final JSONParser parser = new JSONParser();
    private static final Gson gson = new Gson();
    private static final JsonObject jsonObject;

    static {
        // Load JSON file as a resource
        try {
            jsonObject = gson.fromJson(new FileReader(PATH), JsonObject.class);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public Address(String street, int number, int zipCode, String city, String country, String province) throws IOException, ParseException {
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
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        JsonArray comuniArray = jsonObject.getAsJsonArray("comuni");

        for (JsonElement comuneElement : comuniArray) {
            JsonObject comuneObject = comuneElement.getAsJsonObject();
            String nomeComune = comuneObject.get("nome").getAsString();
            String provincia = comuneObject.get("provincia").getAsString();
            String cap = comuneObject.get("cap").getAsString();
            Comune comune = new Comune(provincia, cap);
            comuniMap.put(nomeComune, comune);
        }

        // Verifica che il CAP sia corretto per la provincia e il comune specificati
        Comune comune = comuniMap.get(city);
        if (comune != null && comune.getProvince().equals(province) && comune.getZipcode().equals(String.valueOf(zipCode))) {
            this.zipCode = zipCode;
            this.city = city;
            this.province = province;
        }else{
            System.out.println();
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
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
