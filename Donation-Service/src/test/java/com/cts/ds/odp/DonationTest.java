package com.cts.ds.odp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.ds.odp.entity.Donation;
import com.cts.ds.odp.repository.DonationRepo;
import com.cts.ds.odp.service.DonationService;


@RunWith(SpringRunner.class)
@SpringBootTest

class DonationTest {
			@Autowired
			private DonationService donationservice;
			
			@MockBean
			private DonationRepo repo;
			
			@Test
			public void findbyIdTest() {
				Donation donation= new Donation(2,"Books",8,"Bengaluru","20-11-2010",2);
				when(repo.findById(2)).thenReturn(Optional.of(donation));
				
			}
			@Test
			public void saveProductTest() {
				Donation donation=new Donation();
				when(repo.save(donation)).thenReturn(donation);
				assertEquals(donation,donationservice.saveproduct(donation));	
			}
}

