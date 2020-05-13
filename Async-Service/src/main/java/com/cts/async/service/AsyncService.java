package com.cts.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.async.model.Process;


@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Async("asyncExecutor")
	public CompletableFuture <List<Process>> getProcess() throws InterruptedException 
	{
		log.info("getProcess Starts");
		List<Process> processData = (List<Process>) restTemplate.getForObject("http://localhost:8083/request/process/16",Process.class);

		log.info("processData, {}", processData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("processData completed");
		return CompletableFuture.completedFuture(processData);
	}

}
