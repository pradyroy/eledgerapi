package in.pune.royforge.eledgerapi.data.dao;

import java.sql.Date;
import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface ITransactionDAO {

	List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId);

	List<Transaction> getTransactions();

	List<Transaction> transactionsByLenderId(String lenderId);

	List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate);
}