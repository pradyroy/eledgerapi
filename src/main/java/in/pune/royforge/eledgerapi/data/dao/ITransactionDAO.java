package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface ITransactionDAO {

	List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId);

}
