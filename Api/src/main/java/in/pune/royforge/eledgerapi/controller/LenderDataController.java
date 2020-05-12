package in.pune.royforge.eledgerapi.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.model.Response;
import in.pune.royforge.eledgerapi.data.service.ILenderDataService;
import in.pune.royforge.eledgerapi.exceptionhandler.RecordNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lender")
public class LenderDataController {

	private Logger logger = LoggerFactory.getLogger(LenderDataController.class);

	@Autowired
	private ILenderDataService lenderDataService;

	@RequestMapping(value = "/lenders", method = RequestMethod.GET)
	public ResponseEntity<Response> getListOfLenders() {
		logger.info("calling  getLenders() API");
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, lenderDataService.getLenders()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response> getLenderById(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
		logger.info("calling  getLendersById() API");
		if(lenderDataService.getLender(id) == null) {
			throw new RecordNotFoundException("User Not Found in Record");
		}
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, lenderDataService.getLender(id)),
				HttpStatus.OK);
	}
}
