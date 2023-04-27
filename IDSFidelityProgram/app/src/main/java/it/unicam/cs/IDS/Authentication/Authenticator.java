package it.unicam.cs.IDS.Authentication;

import it.unicam.cs.IDS.FidelityProgram.Customer;

public interface Authenticator {

    void register(Customer client);

}
