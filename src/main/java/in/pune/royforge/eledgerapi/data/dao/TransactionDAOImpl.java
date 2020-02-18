package in.pune.royforge.eledgerapi.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.repo.ITransactionLogRepository;

@Repository
public class TransactionDAOImpl implements ITransactionDAO {
	@Autowired
	ITransactionLogRepository transactionLogRepository;
	
	
	//Method is used to display the list of transaction logs
	@Override
	public List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		Iterable<TransactionEntity> transactionlogs = transactionLogRepository.findAll();
		for (TransactionEntity transactionEntity : transactionlogs) {
			Transaction transactionData = new Transaction();
			setTransactionData(transactionEntity, transactionData);
			transactions.add(transactionData);
		}
		return transactions;

	}

	//Method is used to fetch the data from the transaction table in the object transaction();
	public void setTransactionData(TransactionEntity transactionEntity, Transaction transactionData) {

		transactionData.setTransactionId(transactionEntity.getTransactionId());
		transactionData.setWalletId(transactionEntity.getWalletId());
		transactionData.setlenderId(transactionEntity.getlenderId());
		transactionData.setBorrowerId(transactionEntity.getBorrowerId());
		transactionData.setTxnType(transactionEntity.getTxnType());
		transactionData.setAmount(transactionEntity.getAmount());
		transactionData.setComment(transactionEntity.getComment());
		transactionData.setDate(transactionEntity.getDate());

	}

}
