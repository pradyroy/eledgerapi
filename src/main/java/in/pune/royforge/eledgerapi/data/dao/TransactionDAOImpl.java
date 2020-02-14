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

			setTransaction(transaction1, transactionInfo);
			transactions.add(transactionInfo);
		}
		return transactions;
	}

	/*
	 * Method to get the details of a transaction
	 */
	private void setTransaction(TransactionEntity transaction1, Transaction transactionInfo) {
		transactionInfo.setTransactionId(transaction1.getTransactionId());
		transactionInfo.setWalletId(transaction1.getWalletId());
		transactionInfo.setBorrowerId(transaction1.getBorrowerId());
		transactionInfo.setlenderId(transaction1.getlenderId());
		transactionInfo.setAmount(transaction1.getAmount());
		transactionInfo.setDate(transaction1.getDate());
		transactionInfo.setComment(transaction1.getComment());
		transactionInfo.setType(transaction1.getTxnType());
	}

	/*
	 * Method to return a list of transactions for a specific lender between startDate and endDate.
	 * Input: lenderId, startDate, endDate.
	 * Output: list of transaction between two dates.
	 */
	@Override
	public List<Transaction> transactionListBetweenTwoDates(String lenderId, Date startDate, Date endDate) {
		List<Transaction> transactions = new ArrayList<>();
		Iterable<TransactionEntity> transactionsList = transactionLogRepository.transactionListBetweenTwoDates(lenderId,
				startDate, endDate);
		for (TransactionEntity transactionEntity : transactionsList) {
			Transaction transaction = new Transaction();
			setTransaction(transactionEntity, transaction);
			transactions.add(transaction);
		}
		return transactions;
	}
}
