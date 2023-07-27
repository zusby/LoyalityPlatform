package it.unicam.cs.ids.Database;


import it.unicam.cs.ids.ShopOwner.ShopOwner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

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
