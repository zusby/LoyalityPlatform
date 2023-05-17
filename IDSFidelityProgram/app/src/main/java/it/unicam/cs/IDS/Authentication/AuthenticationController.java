package it.unicam.cs.IDS.Authentication;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import it.unicam.cs.IDS.DataBase.DBManager;
import it.unicam.cs.IDS.Model.Customer;

import java.io.FileInputStream;
import java.io.IOException;

public class AuthenticationController implements Authenticator {

    private FirebaseAuth mAuth;
    private FirebaseOptions fbo;
    private FileInputStream serviceAccount;

    public AuthenticationController() throws IOException {
        initialize();
        mAuth = FirebaseAuth.getInstance();


    }
    private void initialize() throws IOException {
        this.serviceAccount = new FileInputStream("serviceAccountKey.json");
        fbo = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://IDS-FidelityProgram.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(fbo);
    }


    /**
     * This function registers a new user by creating a user record with their email, password, phone number, display
     * name, and photo URL using Firebase Authentication.
     *
     * @param customer The parameter "client" is an object of the class "Customer" which contains information about a user such
     * as their email, password, telephone number, name, and surname. This method is using the information from the
     * "client" object to create a new user record in Firebase Authentication.
     */
    @Override
    public void register(Customer customer){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(customer.getEmail())
                .setEmailVerified(false)
                .setPassword(customer.getPassword())
                .setPhoneNumber(customer.getTelephoneNumber())
                .setDisplayName(customer.getName()+" "+customer.getSurname())
                .setPhotoUrl("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .setDisabled(false)
                .setUid(customer.getID());
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
