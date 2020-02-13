package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface TransactionService {

	List<Transaction> getTransactions();
	List<Transaction> findByLenderId(String lenderId);

}
