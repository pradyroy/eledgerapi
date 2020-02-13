package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerapi.data.dao.ITransactionDAO;
import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.model.WalletData;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private ITransactionDAO transactionEntityDAO;
	
	@Override
	public void save(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> walletTransactions(String borrowerId, String lenderId) {
		// TODO Auto-generated method stub
		return transactionEntityDAO.walletTransactions(borrowerId, lenderId);
	}

	@Override
	public List<Transaction> walletTransactionLog(String lenderId, String borrowerId) {
		// TODO Auto-generated method stub
		return transactionEntityDAO.walletTransactionLog(lenderId, borrowerId);
	}

}
