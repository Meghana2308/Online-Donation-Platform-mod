package com.cts.ds.odp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ds.odp.entity.Donation;
import com.cts.ds.odp.service.DonationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value="The DonationController", description="Rest controller for user")
public class DonationController {
	
	private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		public DonationService donationService;
		
		@ApiOperation(value="Post all user",
		produces="A list of user",
		notes="Hit this URL to get all user"   
		)
		
		  @PostMapping("/donation")
		    public void addProduct(@RequestBody Donation product) {
			logger.info("Adding a product {}");
			//LOGGER.debug("debug - {}", value);
		        donationService.saveproduct(product);    
		    }
		
	
		//    @RequestMapping("donation/{donationId}")
		// 	public Optional<Donation> getById(@PathVariable int donationId) {
		// 		return donationService.getdonationById(donationId);
		// 	}
		   

			@GetMapping("donation/{donationId}")
		    public Optional<Donation> getById(@PathVariable int donationId) {
				logger.debug("debugging donation Id{}");
		        return donationService.getdonationById(donationId);
		    }
			
			
			
			
		   
		   
}
		


