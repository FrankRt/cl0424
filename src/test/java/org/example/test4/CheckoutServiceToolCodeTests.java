package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.exception.NoSuchToolCodeException;
import org.example.test4.exception.RentalPeriodOutOfRangeException;
import org.example.test4.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
class CheckoutServiceToolCodeTests {
	@Autowired
	private CheckoutService checkoutService;

	@Test
	void testCheckOut_NoSuchToolCodeException_Null() {
		try {
			checkoutService.checkOut(null, 0, 0, null);
		} catch (NoSuchToolCodeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}

	}

	@Test
	void testCheckOut_NoSuchToolCodeException_EmptyString() {
        try {
            checkoutService.checkOut("", 0, 0, null);
        } catch (NoSuchToolCodeException e) {
            assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
    }

	@Test
	void testCheckOut_NoSuchToolCodeException_GarbageString() {
		try {
			checkoutService.checkOut("asfljsfljaslfaflfs;aslfa", 0, 0, null);
		} catch (NoSuchToolCodeException e) {
			assert(e != null);
		} catch (Exception e) {
			fail("Shouldn't be getting this exception, " + e.getMessage());
		}
	}

}
