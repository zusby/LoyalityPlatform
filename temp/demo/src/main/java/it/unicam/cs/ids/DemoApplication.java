package it.unicam.cs.ids;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.AuthenticationController;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Model.Purchase;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) throws IOException {
		AuthenticationController s = new AuthenticationController();
		DBManager a = new DBManager();
		Employee employee = new Employee();
		employee.setEmail("fdknasfa@asda.it");
		employee.setID("412841nnk");
		employee.setBirthDate(new GregorianCalendar().getTime());
		SpringApplication.run(DemoApplication.class, args);
	}

}
