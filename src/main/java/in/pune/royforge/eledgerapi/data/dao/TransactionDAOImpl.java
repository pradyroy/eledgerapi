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
}
