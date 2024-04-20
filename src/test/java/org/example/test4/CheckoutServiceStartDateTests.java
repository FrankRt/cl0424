package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.exception.RentalPeriodOutOfRangeException;
import org.example.test4.exception.RentalStartDateException;
import org.example.test4.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
class CheckoutServiceStartDateTests {
	@Autowired
	private CheckoutService checkoutService;

	@Test
	void testCheckOut_StartDate_today() {
		try {
			checkoutService.checkOut("CHNS", 1, 0, LocalDate.now());
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_StartDate_tomorrow() {
		try {
			LocalDate ld = LocalDate.now().plusDays(1);

			checkoutService.checkOut("CHNS", 1, 0, ld);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_StartDate_yesterday() {
		try {
			LocalDate ld = LocalDate.now().plusDays(-1);

			checkoutService.checkOut("CHNS", 1, 0, ld);
		} catch (RentalStartDateException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}
}
