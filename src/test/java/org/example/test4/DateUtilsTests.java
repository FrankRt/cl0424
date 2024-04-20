package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.repository.HolidaysRepository;
import org.example.test4.utilities.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class DateUtilsTests {
	@Autowired
	private HolidaysRepository holidaysRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testIndependenceDay2024_Jul4() {
		LocalDate indDay = Utils.getIndepenceDayObserved(Year.of(2024));

		assertEquals(2024, indDay.getYear());
		assertEquals(7, indDay.getMonthValue());
		assertEquals(4, indDay.getDayOfMonth());
	}

	@Test
	void testIndependenceDay2025_Jul4() {
		LocalDate indDay = Utils.getIndepenceDayObserved(Year.of(2025));

		assertEquals(2025, indDay.getYear());
		assertEquals(7, indDay.getMonthValue());
		assertEquals(4, indDay.getDayOfMonth());
	}

	@Test
	void testIndependenceDay2026_Jul3() {
		LocalDate indDay = Utils.getIndepenceDayObserved(Year.of(2026));

		assertEquals(2026, indDay.getYear());
		assertEquals(7, indDay.getMonthValue());
		assertEquals(3, indDay.getDayOfMonth());
	}

	@Test
	void testIndependenceDay2027_Jul3() {
		LocalDate indDay = Utils.getIndepenceDayObserved(Year.of(2027));

		assertEquals(2027, indDay.getYear());
		assertEquals(7, indDay.getMonthValue());
		assertEquals(5, indDay.getDayOfMonth());
	}

	@Test
	void testLaborDay2024_Sep2() {
		LocalDate labDay = Utils.getLaborDay(Year.of(2024));

		assertEquals(2024, labDay.getYear());
		assertEquals(9, labDay.getMonthValue());
		assertEquals(2, labDay.getDayOfMonth());
	}

	@Test
	void testLaborDay2025_Sep1() {
		LocalDate labDay = Utils.getLaborDay(Year.of(2025));

		assertEquals(2025, labDay.getYear());
		assertEquals(9, labDay.getMonthValue());
		assertEquals(1, labDay.getDayOfMonth());
	}

	@Test
	void testLaborDay2026_Sep7() {
		LocalDate labDay = Utils.getLaborDay(Year.of(2026));

		assertEquals(2026, labDay.getYear());
		assertEquals(9, labDay.getMonthValue());
		assertEquals(7, labDay.getDayOfMonth());
	}

//	@Test
//	void tst() {
//		log.info("All?? " + holidaysRepository.findAll());
//	}
}
