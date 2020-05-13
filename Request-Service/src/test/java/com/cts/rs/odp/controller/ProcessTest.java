package com.cts.rs.odp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.rs.odp.model.Process;
import com.cts.rs.odp.repository.ProcessRepository;
import com.cts.rs.odp.service.ProcessService;

import antlr.collections.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProcessTest {
	
	@Autowired
	private ProcessService processService;
	@MockBean
	private ProcessRepository processRepository;

	@Test
	public void saveProcessTest() {
		Process process=new Process(98,3,5,56,"13-11-2010",null);
		when(processRepository.save(process)).thenReturn(process);
		assertEquals(process,processService.saveprocess(process));	
	}
	
	@Test
	public void findbyRequestIdTest() {
		Integer requestId=5;
		when(processRepository.findByRequestId(requestId))
			.thenReturn(Stream.of(new Process(98,3,5,56,"13-11-2010",null)).collect(Collectors.toList()));
		assertEquals(5,processService.findByRequestIdService(requestId));
		
	}
	
}
