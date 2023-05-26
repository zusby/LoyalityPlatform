package it.unicam.cs.ids.Database;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class FireBaseInitializer {
    private FileInputStream serviceAccount;

    public FireBaseInitializer() {

        try {
            this.serviceAccount = new FileInputStream("serviceAccountKey.json");
        } catch (FileNotFoundException e) {
            System.out.println("Could not find FireBase settings");
        }
    }
}
