package in.pune.royforge.connection.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.connection.exceptionhandler.RecordNotFoundException;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.service.IRelationService;
import in.pune.royforge.connection.service.RelationServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/relation")
public class RelationController {

	private Logger logger = LoggerFactory.getLogger(RelationServiceImpl.class);

	@Autowired
	IRelationService iRelationService;

	@RequestMapping(value = "/users/lenderId/{lenderId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getRelationUsers(@PathVariable(value = "lenderId") String lenderId)
			throws RecordNotFoundException {
		logger.info("calling /relation/users/lenderId API");
		if (iRelationService.getUsers(lenderId).isEmpty()) {
			throw new RecordNotFoundException("List not found for the given lender-ID");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, iRelationService.getUsers(lenderId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/allusers/lenderId/{lenderId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getAllRelationUsers(@PathVariable(value = "lenderId") String lenderId)
			throws RecordNotFoundException {
		logger.info("calling /relation/allusers/lenderId API");
		if (iRelationService.getAllUsers(lenderId).isEmpty()) {
			throw new RecordNotFoundException("List not found for the given lender-ID");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, iRelationService.getAllUsers(lenderId)),
				HttpStatus.OK);
	}
}
