package com.cts.rs.odp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.rs.odp.model.Process;

import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Integer> {
    public List<Process> findByRequestId(int requestId);
   
    
}
