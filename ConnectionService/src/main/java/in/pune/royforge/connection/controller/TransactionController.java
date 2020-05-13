package in.pune.royforge.connection.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.connection.exceptionhandler.RecordNotFoundException;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public ResponseEntity<Response> getTransactions() {
		if (transactionService.getTransactions().isEmpty()) {
			throw new RecordNotFoundException("Lender Not Exist");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, transactionService.getTransactions()),
				HttpStatus.OK);
	}
}
