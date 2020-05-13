package com.cts.rs.odp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.rs.odp.model.Process;
import com.cts.rs.odp.model.Request;
import com.cts.rs.odp.repository.RequestRepo;
import com.cts.rs.odp.service.RequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
class RequestTest {
	
	
		@Autowired
		private RequestService requestservice;
		
		@MockBean
		private RequestRepo repo;
		
		@Test
		public void findbyIdTest() {
			Request request= new Request(1,1,"Scales",2,"20-12-2020");
			when(repo.findById(1)).thenReturn(Optional.of(request));
			
		}
		@Test
		public void saveProductTest() {
			Request request=new Request(1,1,"Scales",2,"20-12-2020");
			when(repo.save(request)).thenReturn(request);
			assertEquals(request,requestservice.saveproduct(request));	
		}
		
	
	
}
