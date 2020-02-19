  
package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerapi.data.dao.ITransactionDAO;
import in.pune.royforge.eledgerapi.data.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	ITransactionDAO transactionDAO;

	@Override
	public List<Transaction> getTransactions() {
		return transactionDAO.getTransactions();

	}

	@Override
	public List<Transaction> transactionsByLenderId(String lenderId) {
		return transactionDAO.transactionsByLenderId(lenderId);
	}

}