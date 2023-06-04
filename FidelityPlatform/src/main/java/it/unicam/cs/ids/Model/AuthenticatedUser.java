package it.unicam.cs.ids.Model;


import java.util.Date;

public interface AuthenticatedUser{

    //metodi comuni agli utenti autenticati


    Date getLastLogin();   // Restituisce la data dell'ultimo accesso

    void logout();
}
