package it.unicam.cs.ids.Customer;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Model.Address;
import org.springframework.context.annotation.Bean;

import java.util.GregorianCalendar;
import java.util.UUID;

public class Customer {

    private final String name,surname,telephoneNumber,email;
    private final Address address;
    private final Timestamp birthDate;
    private UUID ID;
    private String password;


    public Customer(String name, String surname, String telephoneNumber, String email, Address address, UUID id, GregorianCalendar date) {
        this.address = address;
        this.birthDate= Timestamp.of(date.getTime());
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.ID = id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", birthDate=" + birthDate +
                ", ID=" + ID +
                '}';
    }
}
