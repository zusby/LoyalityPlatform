/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.IDS.Model;



import com.google.firebase.auth.FirebaseAuthException;
import it.unicam.cs.IDS.Authentication.AuthenticationController;
import it.unicam.cs.IDS.DataBase.DBManager;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }


    public static void main(String[] args) throws IOException, FirebaseAuthException, ExecutionException, InterruptedException {


        Customer kacper = new Customer("3332222173Ga!","Kacper","Osicki","+393349417779","gaspareosicki@gmail.com",
                new Address("Via giulia piccolomini cicarelli, 92","62032","Camerino","Macerata"),
                UUID.randomUUID(),
                new GregorianCalendar(1999,9,24));

     //   Customer Alex = new Customer("prova123!","Alessandro","Bombagi","+393396986707","alex72545@libero.it",new Address("Baldo degli ubaldi st",42,"63012","Rome","Italy","Rome"),72545,new GregorianCalendar(1999,0,20));

        AuthenticationController s = new AuthenticationController();
        DBManager db = new DBManager();


     //   s.register(kacper);
      //  db.registerCustomer(kacper);
        System.out.println(db.getUser("gaspareosicki@gmail.com"));


      //  db.registerPurchase(new Purchase("gewshiu9ogf", new GregorianCalendar(),(long) 1648,db.getUser("alex72545@libero.it"),"3080ti"));



        s.resetPassword("gaspareosicki@gmail.com");








    }

}
