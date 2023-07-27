package it.unicam.cs.ids;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;

public class test {
    public static void main(String[] args) throws Exception {
        // Path to the service account key JSON file for your Firebase project
        String serviceAccountPath = "path/to/serviceAccountKey.json";

        // Connect to the Firebase Local Emulator Suite
        String host = "localhost";
        int port = 9000;

        // Set up the FirebaseOptions with the Local Emulator connection parameters
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(serviceAccountPath)))
                .setDatabaseUrl("https://your-project-id.firebaseio.com")
                .setDatabaseUrl("http://" + host + ":" + port)
                .build();

        // Initialize the FirebaseApp with the FirebaseOptions
        FirebaseApp.initializeApp(options);

        // Now you can use the Firebase Admin SDK to interact with the Local Emulator
        // For example, you can access the Firestore or Authentication services
        // using FirebaseApp.getInstance().getFirestore() or FirebaseApp.getInstance().getAuth()
    }
}
