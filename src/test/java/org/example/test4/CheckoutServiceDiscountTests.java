package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.exception.DiscountPercentOutOfRangeException;
import org.example.test4.exception.RentalPeriodOutOfRangeException;
import org.example.test4.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
class CheckoutServiceDiscountTests {
	@Autowired
	private CheckoutService checkoutService;

	@Test
	void testCheckOut_DiscountOf_0() {
		try {
			checkoutService.checkOut("CHNS", 10, 0, LocalDate.now());
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_DiscountOf_100() {
		try {
			checkoutService.checkOut("CHNS", 10, 100, LocalDate.now());
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_DiscountOf_negative() {
		try {
			checkoutService.checkOut("CHNS", 10, -1, LocalDate.now());
		} catch (DiscountPercentOutOfRangeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_DiscountOf_greaterThan100() {
		try {
			checkoutService.checkOut("CHNS", 10, 101, LocalDate.now());
		} catch (DiscountPercentOutOfRangeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}
}
