package it.unicam.cs.IDS.Authentication;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import it.unicam.cs.IDS.FidelityProgram.Client;

import java.io.FileInputStream;
import java.io.IOException;

public class AuthenticationController implements Auth {
    private FirebaseAuth mAuth;
    private FirebaseOptions fbo;
    private FileInputStream serviceAccount;


    public AuthenticationController() throws FirebaseAuthException, IOException {
        initialize();
        mAuth = FirebaseAuth.getInstance();


    }
    public void initialize() throws IOException {
        this.serviceAccount = new FileInputStream("serviceAccountKey.json");

        fbo = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://IDS-FidelityProgram.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(fbo);


    }

    public void login(String email, String password) throws FirebaseAuthException {

    }

    public void register(Client client){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(client.getEmail())
                .setEmailVerified(false)
                .setPassword(client.getPassowrd())
                .setPhoneNumber(client.getTelephoneNumber())
                .setDisplayName(client.getName()+" "+client.getSurname())
                .setPhotoUrl("https://media.discordapp.net/attachments/228510346715856896/1096835946760114296/image.png")
                .setDisabled(false);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Succesfully created new User "+ userRecord.getUid());
        }
        catch(Exception e){
            System.out.println("Failed to register user");
        }
    }


    @Override
    public void auth(Object client) {


    }

}
