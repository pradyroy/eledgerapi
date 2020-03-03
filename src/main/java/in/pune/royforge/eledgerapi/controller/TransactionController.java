package in.pune.royforge.eledgerapi.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.model.Response;
import in.pune.royforge.eledgerapi.data.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/lenderId/{lenderId}/date/{date}", method = RequestMethod.GET)
	public ResponseEntity<Response> getTransactionListByLenderIdAndDate(
			@PathVariable(value = "lenderId") String lenderId, @PathVariable(value = "date") java.sql.Date date) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK,
				transactionService.transactionListByLenderIdAndDate(lenderId, date)), HttpStatus.OK);
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public ResponseEntity<Response> getTransactions() {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, transactionService.getTransactions()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowerId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getTransactionsUsingLenderIdAndBorrowerId(
			@PathVariable(value = "lenderId") String lenderId, @PathVariable(value = "borrowerId") UUID borrowerId) {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK,
						transactionService.getTransactionsUsingLenderIdAndBorrowerId(lenderId, borrowerId)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/lenderId/{lenderId}", method = RequestMethod.GET)
	public ResponseEntity<Response> transactionsByLenderId(@PathVariable(value = "lenderId") String lenderId) {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, transactionService.transactionsByLenderId(lenderId)),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/lenderId/{lenderId}/startDate/{startDate}/endDate/{endDate}", method = RequestMethod.GET)
	public ResponseEntity<Response> transactionLogsBetweenTwoDates(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "startDate") java.sql.Date startDate,
			@PathVariable(value = "endDate") java.sql.Date endDate) {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK,
						transactionService.getListOfTransactionBetweenTwoDates(lenderId, startDate, endDate)),
				HttpStatus.OK);
	}
}