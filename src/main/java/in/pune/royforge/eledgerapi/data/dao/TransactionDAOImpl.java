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

	/*
	 * Method to return a list List contains the details of transaction done between
	 * a particular lender ID and borrower ID Lender Id and Borrower ID is passed as
	 * argument to this method
	 * 
	 */
	@Override
	public List<Transaction> walletTransactionLog(String lenderId, String borrowerId) {
		List<Transaction> transactions = new ArrayList<>();
		Iterable<TransactionEntity> transactionsList = transactionLogRepository.transactionsList(lenderId, borrowerId);
		for (TransactionEntity transaction1 : transactionsList) {
			Transaction transactionInfo = new Transaction();

			transaction(transaction1, transactionInfo);
			transactions.add(transactionInfo);
		}
		return transactions;
	}

	/*
	 * Method to get the details of a transaction
	 */
	private void transaction(TransactionEntity transaction1, Transaction transactionInfo) {
		transactionInfo.setTransactionId(transaction1.getTransactionId());
		transactionInfo.setWalletId(transaction1.getWalletId());
		transactionInfo.setBorrowerId(transaction1.getBorrowerId());
		transactionInfo.setlenderId(transaction1.getlenderId());
		transactionInfo.setAmount(transaction1.getAmount());
		transactionInfo.setDate(transaction1.getDate());
		transactionInfo.setComment(transaction1.getComment());
		transactionInfo.setType(transaction1.getTxnType());
	}

}
