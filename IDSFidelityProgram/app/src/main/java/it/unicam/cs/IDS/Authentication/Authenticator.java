package it.unicam.cs.IDS.Authentication;

import it.unicam.cs.IDS.Model.Customer;

public interface Authenticator {

    void register(Customer client);

}
