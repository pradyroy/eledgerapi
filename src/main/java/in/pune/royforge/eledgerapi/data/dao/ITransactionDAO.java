package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.model.WalletData;

public interface ITransactionDAO {

	
	

	List<Transaction> walletTransactions(String borrowerId, String lenderId);

	List<Transaction> walletTransactionLog(String lenderId, String borrowerId);

}
