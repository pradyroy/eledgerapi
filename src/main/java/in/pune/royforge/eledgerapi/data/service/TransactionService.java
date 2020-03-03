package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface TransactionService {

	List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, UUID borrowerId);

	List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate);

	List<Transaction> getTransactions();

	List<Transaction> transactionsByLenderId(String lenderId);

	List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date);
}
