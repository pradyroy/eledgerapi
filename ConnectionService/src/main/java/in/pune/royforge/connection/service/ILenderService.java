package in.pune.royforge.connection.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.pune.royforge.connection.entity.LenderDataEntity;
import in.pune.royforge.connection.model.LenderData;

@FeignClient(name = "lenderService", url = "http://localhost:8081/lender/")
public interface ILenderService {

	@RequestMapping(value = "/lenders", method = RequestMethod.GET)
	public List<LenderData> getLenders();

	@RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
	public LenderData getLender(@PathVariable(value = "id") Long userId);

	@RequestMapping(method = RequestMethod.POST)
	public LenderDataEntity save(@RequestBody LenderData lenderData);

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpLender(@RequestBody LenderData lenderData);

	@RequestMapping(value = "/lenderId/{lenderId}", method = RequestMethod.GET)
	public LenderData getLenderByLenderId(@PathVariable(value = "lenderId") String lenderId);

	@RequestMapping(value = "/validatePhoneOrEmail/{phoneOrEmail}", method = RequestMethod.GET)
	public LenderData getLenderByPhoneOrEmail(@PathVariable(value = "phoneOrEmail") String phoneOrEmail);
}