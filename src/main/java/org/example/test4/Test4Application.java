package org.example.test4;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test4.model.Holidays;
import org.example.test4.repository.HolidaysRepository;
import org.example.test4.repository.ToolTypesRepository;
import org.example.test4.repository.ToolsRepository;
import org.example.test4.utilities.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Year;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class Test4Application implements CommandLineRunner {
	private HolidaysRepository  holidaysRepository;

	public static void main(String[] args) {
		SpringApplication.run(Test4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		populateHolidays();
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
	private void populateHolidays() {
		populateIndependenceDay();
		populateLaborDay();
	}

	private void populateIndependenceDay() {
		holidaysRepository.save(new Holidays(1, Utils.getIndepenceDayObserved(Year.now())));
	}

	private void populateLaborDay() {
		holidaysRepository.save(new Holidays(2, Utils.getLaborDay(Year.now())));
	}
}
