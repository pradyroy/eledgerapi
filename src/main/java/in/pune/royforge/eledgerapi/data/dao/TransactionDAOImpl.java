package in.pune.royforge.eledgerapi.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.Transaction;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.data.repo.ITransactionLogRepository;

@Repository
public class TransactionDAOImpl implements ITransactionDAO{

	@Autowired
	ITransactionLogRepository transactionLogRepository;

	@Override
	public List<Transaction> walletTransactionLog(String lenderId, String borrowerId) {
		List<Transaction> transactions = new ArrayList<>();
	//	Optional<TransactionEntity> givenBorrowId = transactionLogRepository.findByBorrowId(borrowerId);
	//	Optional<TransactionEntity> givenLenderId = transactionLogRepository.findByLenderId(lenderId);

		Iterable<TransactionEntity> transactionsList = transactionLogRepository.transactionsList(lenderId, borrowerId);		
 		for(TransactionEntity transaction1:transactionsList) {
 			Transaction transactionInfo = new Transaction();

 					transactionInfo.setTransactionId(transaction1.getTransactionId());
 					transactionInfo.setWalletId(transaction1.getWalletId());
 					transactionInfo.setBorrowerId(transaction1.getBorrowerId());
 					transactionInfo.setlenderId(transaction1.getlenderId());
 					transactionInfo.setAmount(transaction1.getAmount());
 					transactionInfo.setDate(transaction1.getDate());
 					transactionInfo.setComment(transaction1.getComment());
 					transactionInfo.setType(transaction1.getTxnType());
 					transactions.add(transactionInfo);
 		}
 		return transactions;
	}
	
	@Override
	public List<Transaction> walletTransactions(String borrowerId, String lenderId) {
		WalletData walletData = new WalletData();
		walletData.setBorrowId(borrowerId);
		walletData.setLenderId(lenderId);
		return walletTransactionLog(borrowerId, lenderId);
		
	}
}


