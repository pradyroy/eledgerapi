
package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.pune.royforge.eledgerapi.data.dao.ITransactionDAO;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.exceptionhandler.RecordNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private ITransactionDAO transactionDAO;

	@Override
	public List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date) {
		return transactionDAO.transactionListByLenderIdAndDate(lenderId, date);
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactionDAO.getTransactions();
	}

	@Override
	public List<Transaction> transactionsByLenderId(String lenderId) throws RecordNotFoundException {
		List<Transaction> transactions = transactionDAO.transactionsByLenderId(lenderId);
		if (transactions.isEmpty()) {
			throw new RecordNotFoundException("Lender Not Exist");
		}
		return transactions;
	}

	@Override
	public List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId)
			throws RecordNotFoundException {
		List<Transaction> transaction = transactionDAO.getTransactionsUsingLenderIdAndBorrowerId(lenderId, borrowerId);
		if (transaction.isEmpty()) {
			throw new RecordNotFoundException("No transactions found between the given lender and borrower");
		}
		return transaction;
	}

	@Override
	public List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate) {
		return transactionDAO.getListOfTransactionBetweenTwoDates(lenderId, startDate, endDate);
	}
}
