package it.unicam.cs.ids.Customer;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.Role;
import it.unicam.cs.ids.Model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Customer implements User {

    private String name, surname, telephoneNumber, email;
    private Address address;
    private Timestamp birthDate;
    private String ID;
    private Role rank;


    public Customer(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id, Address address) {
        this.rank = Role.CUSTOMER;
        this.address = address;
        this.birthDate = bdt;
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.ID = id;
    }

    public Customer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = Timestamp.of(birthDate);
    }

    public void setSeconds(long seconds, int nanos) {
        this.birthDate = Timestamp.ofTimeSecondsAndNanos(seconds, nanos);
    }

    public Role getRank() {
        return rank;
    }

    public void setRank(Role rank) {
        this.rank = rank;
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

    public Date getBirthDate() {
        Date date = this.birthDate.toDate();
        date.setHours(12);
        return date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
