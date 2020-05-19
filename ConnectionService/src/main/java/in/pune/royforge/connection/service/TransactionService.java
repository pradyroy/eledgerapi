package in.pune.royforge.connection.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.pune.royforge.connection.model.Transaction;

@Service
@FeignClient(name = "transaction-api", url = "localhost:8080/transaction")
public interface TransactionService {

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public List<Transaction> getTransactions();

	@RequestMapping(value = "/lenderId/{lenderId}", method = RequestMethod.GET)
	public List<Transaction> transactionsByLenderId(@PathVariable(value = "lenderId") String lenderId);

	@RequestMapping(value = "/lenderId/{lenderId}/date/{date}", method = RequestMethod.GET)
	public List<Transaction> transactionListByLenderIdAndDate(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "date") java.sql.Date date);

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowerId}", method = RequestMethod.GET)
	public List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(
			@PathVariable(value = "lenderId") String lenderId, @PathVariable(value = "borrowerId") String borrowerId);

	@RequestMapping(value = "/lenderId/{lenderId}/startDate/{startDate}/endDate/{endDate}", method = RequestMethod.GET)
	public List<Transaction> getListOfTransactionBetweenTwoDates(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "startDate") java.sql.Date startDate,
			@PathVariable(value = "endDate") java.sql.Date endDate);

}
