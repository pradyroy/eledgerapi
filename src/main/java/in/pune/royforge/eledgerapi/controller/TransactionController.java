package in.pune.royforge.eledgerapi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.service.TransactionService;

@RestController
@RequestMapping("/transaction")

public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public List<Transaction> getTransactions() {
		return transactionService.getTransactions();
	}

	@RequestMapping(value = "/lenderId/{lenderId}/startDate/{startDate}/endDate/{endDate}", method = RequestMethod.GET)
	public List<Transaction> transactionLogsBetweenTwoDates(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
		return transactionService.getListOfTransactionBetweenTwoDates(lenderId, startDate, endDate);
	}
}
