package it.unicam.cs.IDS.Model;

import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.List;

public interface AuthenticatedUser{

    //metodi comuni agli utenti autenticati

    String getUsername();  // Restituisce il nome utente dell'utente autenticato
    Date getLastLogin();   // Restituisce la data dell'ultimo accesso


    boolean hasPermission(String permission); // Verifica se l'utente ha una determinata autorizzazione
    void logout();
}
