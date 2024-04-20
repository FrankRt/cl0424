package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.exception.RentalPeriodOutOfRangeException;
import org.example.test4.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
class CheckoutServiceRentalPeriodTests {
	@Autowired
	private CheckoutService checkoutService;

	@Test
	void testCheckOut_PeriodUnder_1() {
		try {
			checkoutService.checkOut("CHNS", 1, 0, LocalDate.now());
		} catch (RentalPeriodOutOfRangeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_PeriodUnder_0() {
		try {
			checkoutService.checkOut("CHNS", 0, 0, null);
		} catch (RentalPeriodOutOfRangeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_PeriodUnder_negative() {
		try {
			checkoutService.checkOut("CHNS", -12345, 0, null);
		} catch (RentalPeriodOutOfRangeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_PeriodOver_30() {
		try {
			checkoutService.checkOut("CHNS", 30, 0, LocalDate.now());
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_PeriodOver_31() {
		try {
			checkoutService.checkOut("CHNS", 31, 0, null);
		} catch (RentalPeriodOutOfRangeException e) {
			assert (e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

	@Test
	void testCheckOut_PeriodOver_100() {
		try {
			checkoutService.checkOut("CHNS", 100, 0, null);
		} catch (RentalPeriodOutOfRangeException e) {
			assert (e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}
}
