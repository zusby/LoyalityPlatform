package it.unicam.cs.ids.Model;

public class FidelitySpace {

    private String description;
    private String shopTelephoneNumber;
    private Address shopAddress;
    private String email;

    public FidelitySpace(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShopTelephoneNumber() {
        return shopTelephoneNumber;
    }

    public void setShopTelephoneNumber(String shopTelephoneNumber) {
        this.shopTelephoneNumber = shopTelephoneNumber;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }
}
