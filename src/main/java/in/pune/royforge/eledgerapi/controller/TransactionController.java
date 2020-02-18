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

	@RequestMapping(value = "/lenderId/{lenderId}/date/{date}", method = RequestMethod.GET)
	public List<Transaction> lenderTransactionsLog(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "date") Date date) {
		return transactionService.transactionListByLenderIdAndDate(lenderId, date);
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public List<Transaction> getTransactions() {
		return transactionService.getTransactions();

	}

}
