package com.cts.rs.odp.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cts.rs.odp.model.Request;
import com.cts.rs.odp.repository.RequestRepo;

@Repository
@Transactional
@Component
public class RequestService {
	@PersistenceContext
  	private EntityManager entityManager;
	@Autowired
	public RequestRepo requestRepo;
	
	public Request saveproduct(Request product) {
		 Request savedRequest= requestRepo.save(product);
		return savedRequest;
	}
	public Optional<Request> getrequestById(int requestId) {
		return requestRepo.findById(requestId);
	
	}
}
