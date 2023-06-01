package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Model.*;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String id;
    private String vatNumber;
    private String name;
    private List<String> shopOwners;
    private List<FidelityProgram> fidelityPrograms = new ArrayList<>();
    private PrizeAwards prizes;
    private FidelitySpace space;
    private Catalogue catalogue;

    public Shop(String id, Address shopAddress, String vatNumber, String name, String shopTelephoneNumber, List<String> shopOwnerIDs) {
        this.id = id;
        this.vatNumber = vatNumber;
        this.name = name;
        this.shopOwners = shopOwnerIDs;
        this.space= new FidelitySpace();
        space.setShopAddress( shopAddress);
        space.setShopTelephoneNumber(shopTelephoneNumber);
    }

    public Shop() {
    }


    public PrizeAwards getPrizes() {
        return prizes;
    }

    public void setPrizes(PrizeAwards prizes) {
        this.prizes = prizes;
    }

    public FidelitySpace getSpace() {
        return space;
    }

    public void setSpace(FidelitySpace space) {
        this.space = space;
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
    public Catalogue getCatalogue() {
        return catalogue;
    }
    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }
    @Override
    public String toString() {
        return "Shop{" +
                "fidelityPrograms=" + fidelityPrograms +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shopOwners=" + shopOwners +
                ", vatNumber='" + vatNumber + '\'' +
                '}';
    }

}
