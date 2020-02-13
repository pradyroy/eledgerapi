package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.model.WalletData;

public interface TransactionService {

	void save(Transaction transaction);
	
	//List<Transaction> walletTransactionLog(TransactionEntity transactionEntity, Transaction transaction, String borrowerId, String lenderId);
	
	List<Transaction> walletTransactions(String borrowerId, String lenderId);
	
	List<Transaction> walletTransactionLog(String lenderId, String borrowerId);

}
