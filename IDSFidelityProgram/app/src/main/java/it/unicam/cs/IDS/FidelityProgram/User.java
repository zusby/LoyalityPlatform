
package it.unicam.cs.IDS.FidelityProgram;

import java.util.Date;
import java.util.List;

/*
 * The User Interface represents a phisical person's profile with its attributes
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public interface User {


    /**
     * The function returns a String representing a person's first name
     *
     * @return A string value representing the name.
     */
    String getName();
    /**
     * The function returns a String representing a person's surname.
     *
     * @return A string representing the surname of a person.
     */
    String getSurname();

    /**
     * The function returns a Date object representing a person's birth date.
     *
     * @return A `Date` object representing the birth date of someone or something.
     */
    Date getBirthDate();

    /**
     * The function "getTelephoneNumber" returns an integer value.
     *
     * @return An integer value representing a telephone number is being returned.
     */
    int getTelephoneNumber();

    /**
     * This function returns a string representing an email address.
     *
     * @return A string representing an email address.
     */
    String getEmail();

    /**
     * The function returns the user's Address.
     *
     * @return An object of type `Address` is being returned.
     */
    Address getAddress();

    /**
     * This function returns a list of purchase history.
     *
     * @return A list of Purchase objects representing the purchase history.
     */
    List<Purchase> getPurchaseHistory();

    /**
     * The function "getID()" returns an integer value.
     *
     * @return an integer value, which is the ID.
     */
    int getID();





}
