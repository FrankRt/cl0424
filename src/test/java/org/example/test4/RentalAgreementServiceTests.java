package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.exception.DiscountPercentOutOfRangeException;
import org.example.test4.service.CheckoutService;
import org.example.test4.service.RentalAgreementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
class RentalAgreementServiceTests {
	@Autowired
	private RentalAgreementService rentalAgreementService;

	@Test
	void testCalculateRentalDays_outside_Jul4() {
		LocalDate localDate = LocalDate.of(2024, 4, 20);

		int numDays = rentalAgreementService.calculateChargeDays(localDate, 10);
		assertEquals(10, numDays);
	}

	@Test
	void testCalculateRentalDays_outside_LaborDay() {
		LocalDate localDate = LocalDate.of(2024, 9, 1);

		int numDays = rentalAgreementService.calculateChargeDays(localDate, 1);
		assertEquals(1, numDays);
	}

	@Test
	void testCalculateRentalDays_onJul4() {
		LocalDate localDate = LocalDate.of(2024, 7, 4);

		int numDays = rentalAgreementService.calculateChargeDays(localDate, 1);
		assertEquals(0, numDays);
	}

	@Test
	void testCalculateRentalDays_onJul3() {
		LocalDate localDate = LocalDate.of(2024, 7, 3);

		int numDays = rentalAgreementService.calculateChargeDays(localDate, 1);
		assertEquals(1, numDays);
	}

	@Test
	void testCalculateRentalDays_includingJul4() {
		LocalDate localDate = LocalDate.of(2024, 7, 3);

		int numDays = rentalAgreementService.calculateChargeDays(localDate, 3);
		assertEquals(2, numDays);
	}

	@Test
	void testCalculateRentalDays_afterJul4() {
		LocalDate localDate = LocalDate.of(2024, 7, 5);

		int numDays = rentalAgreementService.calculateChargeDays(localDate, 13);
		assertEquals(13, numDays);
	}
}
