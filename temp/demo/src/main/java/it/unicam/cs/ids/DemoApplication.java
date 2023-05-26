package it.unicam.cs.ids;

import it.unicam.cs.ids.Database.AuthenticationController;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Model.Level;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.GregorianCalendar;
@EnableSwagger2
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) throws IOException {

		AuthenticationController auth = new AuthenticationController();
		SpringApplication.run(DemoApplication.class, args);
	}

	public Docket apis(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo"))
				.build();
	}

}
