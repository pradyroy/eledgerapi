package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.pune.royforge.eledgerapi.data.model.LenderData;

@FeignClient(name = "lenderService", url = "http://localhost:8081/lender/")
public interface ILenderDataService {

	@RequestMapping(value = "/lenders", method = RequestMethod.GET)
	public List<LenderData> getLenders();
	
	@RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
	public LenderData getLender(@PathVariable(value = "id") 	Long userId);
	
}