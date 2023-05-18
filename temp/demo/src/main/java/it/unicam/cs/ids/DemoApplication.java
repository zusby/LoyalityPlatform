package it.unicam.cs.ids;

import it.unicam.cs.ids.Database.AuthenticationController;
import it.unicam.cs.ids.Database.DBManager;
import org.checkerframework.checker.units.qual.A;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		AuthenticationController s = new AuthenticationController();
		DBManager a = new DBManager();
		SpringApplication.run(DemoApplication.class, args);
	}



}
