
package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.pune.royforge.eledgerapi.data.dao.ITransactionDAO;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.exceptionhandler.RecordNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {
	public void save(Transaction transaction) {

	}

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
	public List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId) {
		return transactionDAO.getTransactionsUsingLenderIdAndBorrowerId(lenderId, borrowerId);
	}

	@Override
	public List<Transaction> getListOfTransactionBetweenTwoDates(String lenderId, Date startDate, Date endDate) {
		return transactionDAO.getListOfTransactionBetweenTwoDates(lenderId, startDate, endDate);
	}

}
