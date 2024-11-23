package com.example.PreServe;

import com.example.PreServe.distance.DistanceCal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreServeApplication.class, args);

		String api1 = DistanceCal.getApiByAddress();
		System.out.println("=============getApiByAddress=============");
		System.out.println(api1);
		String api2 = DistanceCal.serachByCustomerLoc();
		System.out.println("=============serachByCustomerLoc=============");
		System.out.println(api2);
	}

}
