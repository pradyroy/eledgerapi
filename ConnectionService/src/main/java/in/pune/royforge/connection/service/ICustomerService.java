package in.pune.royforge.connection.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.pune.royforge.connection.entity.CustomerDataEntity;
import in.pune.royforge.connection.model.CustomerData;

@FeignClient(name = "customerService", url = "http://localhost:8081/customer/")
public interface ICustomerService {

	@RequestMapping(method = RequestMethod.POST)
	CustomerDataEntity save(@RequestBody CustomerData customerData);

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	List<CustomerData> getCustomers();

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	CustomerData getCustomerById(@PathVariable(value = "id") Long id);

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	boolean deleteCustomer(@PathVariable(value = "id") long id);

	@RequestMapping(value = "/allcustomers", method = RequestMethod.GET)
	List<CustomerData> getAllCustomers();

}
