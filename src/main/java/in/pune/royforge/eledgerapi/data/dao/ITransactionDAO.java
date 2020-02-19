package in.pune.royforge.eledgerapi.data.dao;

import java.sql.Date;
import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface ITransactionDAO {

	List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date);

	List<Transaction> getTransactions();

	List<Transaction> walletTransactionLog(String lenderId, String borrowerId);

	List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate);

	List<Transaction> transactionsByLenderId(String lenderId);

}