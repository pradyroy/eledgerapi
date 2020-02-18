package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface TransactionService {

	void save(Transaction transaction);

	List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId);

}
