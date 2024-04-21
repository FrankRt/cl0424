package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.entity.Holiday;
import org.example.test4.service.HolidayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class HolidayServiceTests {
	@Autowired
	private HolidayService holidayService;

	@Test
	void testHolidays_2024() {
		int year = 2024;
		holidayService.populateHolidays(year);

		List<Holiday> holidays = holidayService.getHolidaysForYear(year);
		assertEquals(2, holidays.size());
		assertEquals(LocalDate.of(year, 7, 4), holidays.get(0).getDate());
		assertEquals(LocalDate.of(year, 9, 2), holidays.get(1).getDate());
	}

	@Test
	void testHolidays_2021() {
		int year = 2021;
		holidayService.populateHolidays(year);

		List<Holiday> holidays = holidayService.getHolidaysForYear(year);
		assertEquals(2, holidays.size());
		assertEquals(LocalDate.of(year, 7, 5), holidays.get(0).getDate());
		assertEquals(LocalDate.of(year, 9, 6), holidays.get(1).getDate());
	}

	@Test
	void testHolidays_2015() {
		int year = 2015;
		holidayService.populateHolidays(year);

		List<Holiday> holidays = holidayService.getHolidaysForYear(year);
		assertEquals(2, holidays.size());
		assertEquals(LocalDate.of(year, 7, 3), holidays.get(0).getDate());
		assertEquals(LocalDate.of(year, 9, 7), holidays.get(1).getDate());
	}

	@Test
	void testHolidays_multiple() {
		final int year = 2015;
		IntStream.range(1, 100).forEach(i -> holidayService.populateHolidays(year));

		List<Holiday> holidays = holidayService.getHolidaysForYear(year);
		assertEquals(2, holidays.size());
	}
}
