package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
class EndToEndTests {
	@Autowired
	private CheckoutService checkoutService;

	@Test
	void providedTestCasesFromDocument() {
		checkoutService.checkOutAndPrint("JAKR", 5, 101,
			LocalDate.of(2015, 9, 3));

		checkoutService.checkOutAndPrint("LADW", 3, 10,
			LocalDate.of(2020, 7, 2));

		checkoutService.checkOutAndPrint("CHNS", 5, 25,
			LocalDate.of(2015, 7, 2));

		checkoutService.checkOutAndPrint("JAKD", 5, 0,
			LocalDate.of(2015, 9, 3));

		checkoutService.checkOutAndPrint("JAKR", 9, 0,
			LocalDate.of(2015, 7, 2));

		checkoutService.checkOutAndPrint("JAKR", 4, 50,
			LocalDate.of(2020, 7, 2));
		System.out.println(" ");
	}
}
