package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerapi.data.dao.ITransactionDAO;
import in.pune.royforge.eledgerapi.data.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private ITransactionDAO transactionEntityDAO;

	@Override
	public void save(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Transaction> getTransactionsUsingLenderIdAndBorrowerId(String lenderId, String borrowerId) {
		// TODO Auto-generated method stub
		return transactionEntityDAO.getTransactionsUsingLenderIdAndBorrowerId(lenderId, borrowerId);
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactionEntityDAO.getTransactions();

	}

}
