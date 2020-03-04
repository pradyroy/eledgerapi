package in.pune.royforge.eledgerapi.data.dao;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface ITransactionDAO {

	List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId);

	List<Transaction> getTransactions();

	List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date);

	List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate);

	List<Transaction> transactionsByLenderId(String lenderId);

}