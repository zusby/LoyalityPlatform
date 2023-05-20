package it.unicam.cs.ids.Customer;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Customer implements User {

    private String name,surname,telephoneNumber,email;
    private Address address;
    private Timestamp birthDate;
    private String ID;



    public Customer(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id ,Address address) {
        this.address = address;
        this.birthDate= bdt;
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.ID = id;
    }

    public Customer(){

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
    public void setSeconds(long seconds, int nanos){
        this.birthDate= Timestamp.ofTimeSecondsAndNanos(seconds,nanos);
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
        return birthDate.toDate();
    }

    public String getID() {
        return ID.toString();
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
