package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface ITransactionDAO {

	List<Transaction> getTransactions();

	List<Transaction> transactionsByLenderId(String lenderId);


}
