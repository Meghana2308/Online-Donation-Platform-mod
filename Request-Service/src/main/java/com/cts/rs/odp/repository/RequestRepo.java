package com.cts.rs.odp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.rs.odp.model.Request;

public interface RequestRepo extends JpaRepository<Request , Integer>{

	Optional<Request> findById(int requestId); 

	

}
