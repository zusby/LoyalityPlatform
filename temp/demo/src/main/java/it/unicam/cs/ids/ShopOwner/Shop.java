package it.unicam.cs.ids.ShopOwner;

import it.unicam.cs.ids.Model.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Shop {

    private Address shopAddress;
    private String vatNumber;
    private String name;
    private String shopTelephoneNumber;
    private UUID shopOwnerID;
    private List<UUID> shopOwners;

    public Shop(Address shopAddress, String vatNumber, String name, String shopTelephoneNumber, List<UUID> shopOwnerIDs) {
        this.shopAddress = shopAddress;
        this.vatNumber = vatNumber;
        this.name = name;
        this.shopTelephoneNumber = shopTelephoneNumber;
        shopOwners= shopOwnerIDs;
    }

    public Shop(){
    }

    public List<UUID> getShopOwners(){
        return this.shopOwners;
    }

    public void setShopOwners(List<UUID> owners){
        this.shopOwners = owners;
    }

    public void setShopOwnerID(UUID shopOwnerID) {
        this.shopOwnerID = shopOwnerID;
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


}
