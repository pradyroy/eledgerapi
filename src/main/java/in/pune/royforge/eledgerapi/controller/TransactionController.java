package in.pune.royforge.eledgerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.service.TransactionService;

@RestController
@RequestMapping("/tansaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/{lenderId}/{borrowerId}", method = RequestMethod.GET)
	public List<Transaction> walletTransactionsLog(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowerId") String borrowerId) {
		return transactionService.walletTransactionLog(lenderId, borrowerId);
	}

}
