package it.unicam.cs.IDS.FidelityProgram;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Client implements User{

    private final String password,name,surname,telephoneNumber,email;
    private final Address address;
    private final GregorianCalendar birthDate;
    private final int ID;

    public Client(String password, String name, String surname, String telephoneNumber, String email, Address address, int id, GregorianCalendar date) {
        this.password = password;
        this.address = address;
        this.birthDate=date;
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        ID = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public GregorianCalendar getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public List<Purchase> getPurchaseHistory() {
        return null;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    public String getPassowrd() {
        return this.password;
    }
}
