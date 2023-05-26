package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.PrizeAwards;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String id;
    private Address shopAddress;
    private String vatNumber;
    private String name;
    private String shopTelephoneNumber;
    private List<String> shopOwners;
    private List<FidelityProgram> fidelityPrograms = new ArrayList<>();
    private PrizeAwards prizes;

    public PrizeAwards getPrizes() {
        return prizes;
    }

    public void setPrizes(PrizeAwards prizes) {
        this.prizes = prizes;
    }

    public Shop(String id, Address shopAddress, String vatNumber, String name, String shopTelephoneNumber, List<String> shopOwnerIDs) {
        this.id = id;
        this.shopAddress = shopAddress;
        this.vatNumber = vatNumber;
        this.name = name;
        this.shopTelephoneNumber = shopTelephoneNumber;
        this.shopOwners = shopOwnerIDs;
    }

    public Shop() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<String> getShopOwners() {
        return this.shopOwners;
    }

    public void setShopOwners(List<String> owners) {
        this.shopOwners = owners;
    }


    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public List<FidelityProgram> getFidelityPrograms() {
        return fidelityPrograms;
    }

    public void setFidelityPrograms(List<FidelityProgram> fidelityPrograms) {
        this.fidelityPrograms = fidelityPrograms;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopTelephoneNumber() {
        return shopTelephoneNumber;
    }

    public void setShopTelephoneNumber(String shopTelephoneNumber) {
        this.shopTelephoneNumber = shopTelephoneNumber;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "fidelityPrograms=" + fidelityPrograms +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shopAddress=" + shopAddress +
                ", shopOwners=" + shopOwners +
                ", shopTelephoneNumber='" + shopTelephoneNumber + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                '}';
    }

}
