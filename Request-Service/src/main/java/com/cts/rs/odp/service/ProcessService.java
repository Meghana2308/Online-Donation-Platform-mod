package com.cts.rs.odp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.rs.odp.model.Process;
import com.cts.rs.odp.repository.ProcessRepository;
@Service
public class ProcessService {
    @Autowired
    private ProcessRepository processRepository;
    public List<Process> getAllProcess(){
        return (List<Process>) processRepository.findAll();
    }
    public Process findByRequestIdService(Integer requestId) {
        Process result = processRepository.findByRequestId(requestId).stream()
                        .filter(x -> requestId.equals(x.getRequestId()))
                        .findAny()
                        .orElse(null);
        return result;
    }
    public Process findByRequestIdUpdateQuantityService(Integer requestId, Integer quantityInput) throws Exception {
        int saveQuantity=0;
        Process result = processRepository.findByRequestId(requestId).stream()
                .filter(x -> requestId.equals(x.getRequestId()))
                .findAny()
                .orElse(null);

        System.out.println("Before Update, Quantity value with respect to Request Id ");
        System.out.println("The Result"+result);

        if(result.getQuantity() > quantityInput){
            saveQuantity = result.getQuantity() - quantityInput;
        }else if(result.getQuantity()==0||result.getQuantity()<quantityInput) {
        	throw new Exception("The requested quantity is not available ");
        }

        System.out.println("After Update, Quantity value with respect to Request Id ");
        processRepository.save(new Process(result.getId(),result.getUserId(),result.getRequestId(),saveQuantity,result.getDate(),result.getTime()));
        return result;
    }
    public Process saveprocess(Process id) {
		  Process savedProcess=  processRepository.save(id);
	      return savedProcess;
	  }
}
