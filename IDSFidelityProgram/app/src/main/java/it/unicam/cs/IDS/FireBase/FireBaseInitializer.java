package it.unicam.cs.IDS.FireBase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import it.unicam.cs.IDS.FidelityProgram.Purchase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class FireBaseInitializer {
    private FileInputStream serviceAccount;
    private FirebaseOptions fbo;

    public FireBaseInitializer() {
        try {
            this.serviceAccount = new FileInputStream("serviceAccountKey.json");
        } catch (FileNotFoundException e) {
            System.out.println("Could not find FireBase settings");
        }





        Firestore db = FirestoreClient.getFirestore();
        DocumentReference userRef = db.collection("Clients").document("D2gFc7wtajWqKHtMUHXOCzlfp7h1");
        CollectionReference cities = db.collection("cities");
        List<ApiFuture<WriteResult>> futures = new ArrayList<>();
        futures.add(
                cities
                        .document("SF")
                        .set(
                                new Purchase("D2gFc7wtajWqKHtMUHXOCzlfp7h1",new GregorianCalendar(2023,4,19),140,"D2gFc7wtajWqKHtMUHXOCzlfp7h1")));

        ApiFuture<DocumentSnapshot> purchases = userRef.get();

        try {
            DocumentSnapshot user = purchases.get();

            if (user.exists()) {
                System.out.println("Document data: " + user.getData());
            } else {
                System.out.println("No such document!");
            }
        }catch (Exception e){}




    }


}
