package com.cts.ds.odp.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cts.ds.odp.entity.Donation;
import com.cts.ds.odp.entity.Request;
import com.cts.ds.odp.repository.DonationRepo;

@Repository
@Transactional
@Component
public class DonationService {

	@PersistenceContext
  	private EntityManager entityManager;
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
    }

	
	@Autowired
	public DonationRepo donationRepository;
	

	  public Donation saveproduct(Donation product) {
		  Donation savedUser=  donationRepository.save(product);
	      return savedUser;
	  }


	public Optional<Donation> getdonationById(int donationId) {
		
		return donationRepository.findById(donationId);
	}


	public Optional<Donation> getdonationById(Donation donationId) {
		return null;
	}
	public Request getRequest( int requestId){
       
	return  restTemplate.getForObject("http://localhost:8083/request/{requestId}",Request.class,requestId);
        
       
    }
	


//	public Optional<Donation> getdonationByuserIdanddnationId(int donationId, int userId) {
//	
//		return donationRepository.find(donationId,userId);
//	}


	
	  
}



