package it.unicam.cs.ids.Database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
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
    private void initialize() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");
        FirebaseOptions fbo = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://IDS-FidelityProgram.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(fbo);
    }




    public static void registerNoPassword(String email){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setUid(UUID.randomUUID().toString());
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Succesfully created new User "+ userRecord.getUid());
        }
        catch(Exception e){
            System.out.println("Failed to register user");
        }
    }

    /**
     * This function registers a new user by creating a user record with their email, password, phone number, display
     * name, and photo URL using Firebase Authentication.
     *
     * @param User The parameter "client" is an object of the class "Customer" which contains information about a user such
     * as their email, password, telephone number, name, and surname. This method is using the information from the
     * "client" object to create a new user record in Firebase Authentication.
     */

    public static void register(String email, String password){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password)
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setUid(UUID.randomUUID().toString());
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
