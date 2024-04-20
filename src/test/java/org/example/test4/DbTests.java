package org.example.test4;

import lombok.extern.slf4j.Slf4j;
import org.example.test4.entity.Tool;
import org.example.test4.entity.ToolType;
import org.example.test4.repository.HolidayRepository;
import org.example.test4.repository.ToolTypeRepository;
import org.example.test4.repository.ToolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class DbTests {
	@Autowired
	private HolidayRepository holidaysRepository;

	@Autowired
	private ToolTypeRepository toolTypeRepository;

	@Autowired
	private ToolRepository toolRepository;

	@Test
	public void printTables() {
		holidaysRepository.findAll().stream().forEach(h -> log.info("Holiday: " + h));
		toolTypeRepository.findAll().stream().forEach(tt -> log.info("ToolType: " + tt));
		toolRepository.findAll().forEach(t -> log.info("Tool: " + t));
	}

	@Test
	public void testToolCode_CHNS() {
		List<Tool> toolsForCode = toolRepository.findByToolCode("CHNS");
		assert(toolsForCode.size() == 1);

		Tool tool = toolsForCode.get(0);
		assertEquals(1, tool.getId());
		assertEquals("Stihl", tool.getBrand());

		ToolType tType = tool.getToolType();
		assert(tType != null);
	}

	@Test
	public void testToolCode_JAKD() {
		List<Tool> toolsForCode = toolRepository.findByToolCode("JAKD");
		assert(toolsForCode.size() == 1);

		Tool tool = toolsForCode.get(0);
		assertEquals(3, tool.getId());
		assertEquals("DeWalt", tool.getBrand());

		ToolType tType = tool.getToolType();
		assert(tType != null);
	}
}
