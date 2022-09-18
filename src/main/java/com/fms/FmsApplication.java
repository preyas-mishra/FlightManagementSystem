package com.fms;

import com.fms.dtos.User;
import com.fms.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

@SpringBootApplication
public class FmsApplication {

	@Autowired
	private UserServiceImpl userService;

	public static void main(String[] args)
	{
		SpringApplication.run(FmsApplication.class, args);
	}

	@Bean
	public CommandLineRunner create()
	{
		// Created Constant Variable as value of constant hasbeen used multiple times.

		final String ADMIN = "admin";  // Compliant

		/*
			* Phone Numbers of admins are typecasted into big integers bacause they are declared as big integers as per the requirement.
		 */

		BigInteger phone1=BigInteger.valueOf(8446913203L);
		BigInteger phone2=BigInteger.valueOf(6303299720L);
		BigInteger phone3=BigInteger.valueOf(9146666018L);
		BigInteger phone4=BigInteger.valueOf(9146095340L);
		BigInteger phone5=BigInteger.valueOf(9666845642L);
		BigInteger phone6=BigInteger.valueOf(7755918779L);
		BigInteger phone7=BigInteger.valueOf(7036351827L);

		/*
			* Admins are created here itself as the application can only create customers who use this application.
		 */

		return args -> {
			var user1 = new User("Deepak",phone1,"deepak@gmail.com","Deepak@203",ADMIN);
			var user2 = new User("Girish",phone2,"girish@gmail.com","Girish@720",ADMIN);
			var user3 = new User("Preyas",phone3,"preyas@gmail.com","Preyas@327",ADMIN);
			var user4 = new User("Rutuja",phone4,"rutuja@gmail.com","Rutuja@340",ADMIN);
			var user5 = new User("Sneha",phone5,"sneha@gmail.com","Sneha@779",ADMIN);
			var user6 = new User("Tejaswi",phone6,"tejaswi@gmail.com","Tejaswi@642",ADMIN);
			var user7 = new User("UmaMahesh",phone7,"gorsaumamahesh@gmail.com","Mahesh@327",ADMIN);

			userService.addUser(user1);
			userService.addUser(user2);
			userService.addUser(user3);
			userService.addUser(user4);
			userService.addUser(user5);
			userService.addUser(user6);
			userService.addUser(user7);
		};

	}
}
