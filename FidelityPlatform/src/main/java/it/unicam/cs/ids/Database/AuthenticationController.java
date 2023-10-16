package it.unicam.cs.ids.Database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.io.FileInputStream;
import java.io.IOException;

public class AuthenticationController {

    private final FirebaseAuth mAuth;


    public AuthenticationController() throws IOException {
        initialize();
        mAuth = FirebaseAuth.getInstance();

    }


    /**
     * This function initializes a Firebase app with a service account key and a database URL.
     */
    private void initialize() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");
        FirebaseOptions fbo = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://IDS-FidelityProgram.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(fbo);
    }


    /**
     * This function creates a new user in Firebase Authentication without a password using their email and a randomly
     * generated UID.
     *
     * @param email The email address of the user being registered.
     */
    public static boolean registerNoPassword(String email, String id){

        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setUid(id);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Succesfully created new User "+ userRecord.getUid());
            return true;
        }
        catch(FirebaseAuthException e){
            e.printStackTrace();
            return false;
        }
    }
    @Deprecated
    public String getUserAuthIDByEmail(String email) throws FirebaseAuthException {
        return mAuth.getUserByEmail(email).getUid();
    }



    /**
     * This function registers a new user with a given email, password, and unique ID using Firebase Authentication in
     * Java.
     *
     * @param email The email address of the user being registered.
     * @param password The password parameter is a String variable that represents the password that the user wants to set
     * for their account during registration.
     * @deprecated use the firebase auth web instead
     */
    @Deprecated
    public static boolean register(String email, String password, String id){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password)
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setUid(id);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Succesfully created new User "+ userRecord.getUid());
            return true;
        }
        catch(Exception e){
            System.out.println("Failed to register user");
            return false;
        }
    }
}
