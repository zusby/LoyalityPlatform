
package it.unicam.cs.ids.Model;

import java.util.Date;

/**
 * The User Interface represents a phisical person's profile with its attributes
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */
public interface User {

    //metodi comuni a tutti gli utenti


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
    String getTelephoneNumber();

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
     * The function "getID()" returns an integer value.
     *
     * @return an integer value, which is the ID.
     */
    String getID();





}
