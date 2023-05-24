package it.unicam.cs.ids;

import io.swagger.models.auth.In;
import it.unicam.cs.ids.Database.AuthenticationController;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Model.Level;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.GregorianCalendar;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) throws IOException {

		AuthenticationController auth = new AuthenticationController();
		SpringApplication.run(DemoApplication.class, args);
	}

}
