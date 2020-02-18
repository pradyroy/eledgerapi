package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
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
	public List<Transaction> transactionListByLenderIdAndDate(String lenderId, Date date) {
		return transactionEntityDAO.transactionListByLenderIdAndDate(lenderId, date);
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactionEntityDAO.getTransactions();

	}

}
