package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.repository.HolidaysRepository;
import org.example.test4.repository.ToolsRepository;
import org.example.test4.repository.ToolTypesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class DbTests {
	@Autowired
	private HolidaysRepository  holidaysRepository;

	@Autowired
	private ToolTypesRepository tooltypesRepository;

	@Autowired
	private ToolsRepository     toolsRepository;

	@Test
	void tst() {
		holidaysRepository.findAll().stream().forEach(h -> log.info("Holiday: " + h));
		tooltypesRepository.findAll().stream().forEach(tt -> log.info("ToolType: " + tt));
		toolsRepository.findAll().forEach(t -> log.info("Tool: " + t));
//		log.info("Tooltypes: " + tooltypesRepository.findAll());
//		log.info("Tools: " +
	}
}
