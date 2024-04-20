package org.example.test4;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test4.model.RentalAgreement;
import org.example.test4.service.CheckoutService;
import org.example.test4.service.HolidayService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class Test4Application implements CommandLineRunner {
	private HolidayService  holidayService;
	private CheckoutService checkoutService;

	public static void main(String[] args) {
		SpringApplication.run(Test4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		holidayService.populateHolidays();

		try {
			RentalAgreement ra = checkoutService.checkOut("CHNS", 1, 0, LocalDate.now());
		} catch (Exception e) {
			log.error("Error in processing: ");
			log.error("  " + e.getMessage());
		}
	}

	/**
	 * Populating ONLY Independence and Labor days in the HOLIDAYS
	 * table for the current year.
	 *
	 * @Todo Make this more general where we'd input a list of holidays for a year, then populate all. In fact we may
	 * need multiple years (but no more than two) in the HOLIDAYS table for when rentals would extend over and including
	 * New Year's Day. Example: a 10 day rental including Christmas Day and New Year's Day and where those rental days
	 * would be charge free.
	 */
//	private void populateHolidays() {
//		populateIndependenceDay();
//		populateLaborDay();
//	}
//
//	private void populateIndependenceDay() {
//		holidaysRepository.save(new Holiday(1, Utils.getIndepenceDayObserved(Year.now())));
//	}
//
//	private void populateLaborDay() {
//		holidaysRepository.save(new Holiday(2, Utils.getLaborDay(Year.now())));
//	}
}
