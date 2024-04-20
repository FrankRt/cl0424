package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.repository.HolidaysRepository;
import org.example.test4.repository.TooltypesRepository;
import org.example.test4.utilities.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class DbTests {
	@Autowired
	private HolidaysRepository holidaysRepository;

	@Autowired
	private TooltypesRepository tooltypesRepository;

	@Test
	void tst() {
		log.info("Holidays: " + holidaysRepository.findAll());
		log.info("Tooltypes: " + tooltypesRepository.findAll());
	}
}
