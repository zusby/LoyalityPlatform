package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.List;

public interface AuthenticatedUser{

    //metodi comuni agli utenti autenticati


    Date getLastLogin();   // Restituisce la data dell'ultimo accesso

    void logout();
}
