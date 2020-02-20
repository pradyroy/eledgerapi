package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface TransactionService {
	void save(Transaction transaction);

	List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId);

	List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate);

	List<Transaction> getTransactions();

	List<Transaction> transactionsByLenderId(String lenderId);

	List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date);
}
