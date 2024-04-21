package org.example.test4;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test4.model.RentalAgreement;
import org.example.test4.service.CheckoutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class Test4Application implements CommandLineRunner {
	private CheckoutService checkoutService;

	public static void main(String[] args) {
		SpringApplication.run(Test4Application.class, args);
	}

	@Override
	public void run(String... args) {
		checkoutService.checkOutAndPrint("JAKR", 5, 101,
			LocalDate.of(2015, 9, 3));

		System.out.println(" ");
		checkoutService.checkOutAndPrint("LADW", 3, 10,
			LocalDate.of(2020, 7, 2));

		System.out.println(" ");
		checkoutService.checkOutAndPrint("CHNS", 5, 25,
			LocalDate.of(2015, 7, 2));

		System.out.println(" ");
		checkoutService.checkOutAndPrint("JAKD", 5, 0,
			LocalDate.of(2015, 9, 3));

		System.out.println(" ");
		checkoutService.checkOutAndPrint("JAKR", 9, 0,
			LocalDate.of(2015, 7, 2));

		System.out.println(" ");
		checkoutService.checkOutAndPrint("JAKR", 4, 50,
			LocalDate.of(2020, 7, 2));
	}
}
