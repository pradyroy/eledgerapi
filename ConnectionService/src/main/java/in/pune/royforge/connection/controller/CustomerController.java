package in.pune.royforge.connection.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.connection.exceptionhandler.RecordNotFoundException;
import in.pune.royforge.connection.model.CustomerData;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.service.ICustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	ICustomerService customerEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> createOrUpdateCustomer(@RequestBody CustomerData customerData) {
		logger.info("calling /customer POST API");
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.CREATED, customerEntityService.save(customerData)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<Response> getCustomers() {
		logger.info("calling /customers GET API");
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, customerEntityService.getCustomers()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response> getCustomerById(@PathVariable(value = "id") Long id)
			throws RecordNotFoundException {
		logger.info("calling /customer/Id GET API");
		if (null == customerEntityService.getCustomerById(id)) {
			throw new RecordNotFoundException("User Not Found in Record");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "Success", HttpStatus.OK, customerEntityService.getCustomerById(id)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteCustomer(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
		logger.info("calling /customer/Id DELETE API");
		if (false == customerEntityService.deleteCustomer(id)) {
			throw new RecordNotFoundException("User Not Found");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "Success", HttpStatus.OK, !customerEntityService.deleteCustomer(id)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/allcustomers", method = RequestMethod.GET)
	public ResponseEntity<Response> getAllCustomers() {
		logger.info("calling /allcustomers GET API");
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, customerEntityService.getAllCustomers()),
				HttpStatus.OK);
	}
}
