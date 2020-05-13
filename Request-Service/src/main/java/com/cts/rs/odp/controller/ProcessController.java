package com.cts.rs.odp.controller;
import com.cts.rs.odp.model.Process;
import com.cts.rs.odp.service.ProcessService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/request/process")
public class ProcessController {
	private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProcessService processService;
    @GetMapping
    public List<Process> getProcessTableData(){
    	logger.info("Data of process table {}");
        return processService.getAllProcess();
    }

    @GetMapping("/{requestId}")
    public Process processRequestedId(@PathVariable Integer requestId) {
    	logger.info("Process the request by requestId {}");
        return processService.findByRequestIdService(requestId);
    }
    @GetMapping("/{requestId}/{quantity}")
    public Process processRequestedId(@PathVariable Integer requestId,@PathVariable Integer quantity) throws Exception {
    	logger.debug("Debug the process {}");
        return processService.findByRequestIdUpdateQuantityService(requestId,quantity);
    }
    @PostMapping
    public void addProcess(@RequestBody Process id) {
    	logger.debug("Debug the process based on process id {}");
	  processService.saveprocess(id);    
    }


}