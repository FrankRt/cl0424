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
	void testCheckOut_StartDate_null() {
		try {
			checkoutService.checkOut("CHNS", 1, 0, null);
			fail("Should be getting exception.");
		} catch (Exception e) {
			assert(e != null);
		}
	}
}
