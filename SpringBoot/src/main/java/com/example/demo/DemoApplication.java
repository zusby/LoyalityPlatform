package com.example.demo;

import it.unicam.cs.ids.Customer.Address;
import it.unicam.cs.ids.Customer.Customer;

import it.unicam.cs.ids.Customer.CustomerController;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerController.class, args);
	}



}
