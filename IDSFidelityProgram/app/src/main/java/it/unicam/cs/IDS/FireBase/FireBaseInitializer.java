package it.unicam.cs.IDS.FireBase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FireBaseInitializer {
    public static void initialize() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://<your-database-name>.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
