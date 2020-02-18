package in.pune.royforge.eledgerapi.data.dao;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.repo.ITransactionLogRepository;

@Repository

public class TransactionDAOImpl implements ITransactionDAO{
	
	@Autowired
	ITransactionLogRepository transactionLogRepository;
	
	@Override
	public List<Transaction> transactionListByLenderIdAndStratDate(String lenderId, Date startDate) {
		List<Transaction> transactions = new ArrayList<>();
		Iterable<TransactionEntity> transactionsList = transactionLogRepository.transactionListByLenderIdAndStratDate(lenderId,
				startDate);
		for (TransactionEntity transactionEntity : transactionsList) {
			Transaction transaction = new Transaction();
			setTransaction(transactionEntity, transaction);
			transactions.add(transaction);
		}
		return transactions;
	}

	//Method is used to fetch the data from the transaction table in the object transaction();
	private void setTransaction(TransactionEntity transaction1, Transaction transactionInfo) {
		transactionInfo.setTransactionId(transaction1.getTransactionId());
		transactionInfo.setWalletId(transaction1.getWalletId());
		transactionInfo.setBorrowerId(transaction1.getBorrowerId());
		transactionInfo.setlenderId(transaction1.getlenderId());
		transactionInfo.setAmount(transaction1.getAmount());
		transactionInfo.setDate(transaction1.getDate());
		transactionInfo.setComment(transaction1.getComment());
		transactionInfo.setTxnType(transaction1.getTxnType());
	}

	//Method is used to display the list of transaction logs
	@Override
	public List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		Iterable<TransactionEntity> transactionlogs = transactionLogRepository.findAll();
		for (TransactionEntity transactionEntity : transactionlogs) {
			Transaction transactionData = new Transaction();
			setTransaction(transactionEntity, transactionData);
			transactions.add(transactionData);
		}
		return transactions;

	}


}
