package it.unicam.cs.ids.Database;

import com.google.api.gax.rpc.NotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.ErrorCode;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Customer.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

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
    public static void registerNoPassword(String email, String id){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setUid(id);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Succesfully created new User "+ userRecord.getUid());
        }
        catch(FirebaseAuthException e){
            e.printStackTrace();
        }
    }


    /**
     * This function registers a new user with a given email, password, and unique ID using Firebase Authentication in
     * Java.
     *
     * @param email The email address of the user being registered.
     * @param password The password parameter is a String variable that represents the password that the user wants to set
     * for their account during registration.
     */
    public static void register(String email, String password, String id){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password)
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setUid(id);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Succesfully created new User "+ userRecord.getUid());
        }
        catch(Exception e){
            System.out.println("Failed to register user");
        }
    }


    /**
     * This function generates a password reset link for a user with the given email address, and prints an error message
     * if the user doesn't exist.
     *
     * @param email The email of the user for whom the password reset link needs to be generated.
     */
    public String resetPassword(String email){
        try{
            return mAuth.generatePasswordResetLink(email);
        }catch (FirebaseAuthException e){
            System.out.println("User doesn't exist, error:"+e);
            return "";
        }
    }

}
