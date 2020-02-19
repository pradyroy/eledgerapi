package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface TransactionService {
	void save(Transaction transaction);

	List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date);

	List<Transaction> getTransactions();

	List<Transaction> walletTransactionLog(String lenderId, String borrowerId);

	List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate);

}
