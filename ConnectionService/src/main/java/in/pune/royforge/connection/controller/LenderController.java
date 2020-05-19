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
import in.pune.royforge.connection.model.LenderData;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.service.ILenderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lender")
public class LenderController {
	private Logger logger = LoggerFactory.getLogger(LenderController.class);

	@Autowired
	private ILenderService lenderDataService;

	@RequestMapping(value = "/lenders", method = RequestMethod.GET)
	public ResponseEntity<Response> getListOfLenders() {
		logger.info("calling /lenders GET API");
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, lenderDataService.getLenders()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response> getLenderById(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
		logger.info("calling  /lender/userId/ GET API");
		if (lenderDataService.getLender(id) == null) {
			throw new RecordNotFoundException("User Not Found in Record");
		}
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, lenderDataService.getLender(id)),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> createOrUpdateLender(@RequestBody LenderData lenderData) {
		logger.info("calling /lender POST API");
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.CREATED, lenderDataService.save(lenderData)),
				HttpStatus.CREATED);
	}
}
