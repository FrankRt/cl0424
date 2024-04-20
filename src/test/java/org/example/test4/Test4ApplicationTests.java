package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.repository.HolidaysRepository;
import org.example.test4.utilities.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Year;

@SpringBootTest
@Slf4j
class Test4ApplicationTests {
	@Autowired
	private HolidaysRepository holidaysRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testIndependenceDayOfWeek2024() {
		LocalDate jul4 = Utils.getIndepenceDayObserved(Year.of(2024));
		log.info("7-4: " + jul4);
	}

}
