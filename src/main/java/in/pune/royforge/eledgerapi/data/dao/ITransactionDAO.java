package in.pune.royforge.eledgerapi.data.dao;

import java.sql.Date;
import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface ITransactionDAO {

	List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date);

	List<Transaction> getTransactions();

}
