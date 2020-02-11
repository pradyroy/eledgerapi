package in.pune.royforge.eledgerapi.data.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.Wallet;
import in.pune.royforge.eledgerapi.data.repo.TransactionLogRepository;
import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;

@Repository
public class WalletDAOImpl implements IWalletDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;
	@Autowired
	TransactionLogRepository transactionLogRepository;

	@Override
	public void save(Wallet wallet) {
		WalletEntity walletEntity = new WalletEntity();
		WalletEntity walletEntityobj = null;

		if (wallet.getWalletId() == null) {
			createWallet(walletEntity, wallet);
			walletEntityobj = walletEntityRepository.save(walletEntity);		
		}
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionLogCreate(transactionEntity, wallet, walletEntityobj.getWalletId());
		TransactionEntity transactioEntityobj = transactionLogRepository.save(transactionEntity);
		
	}

	private void createWallet(WalletEntity walletEntity, Wallet wallet) {
		Date currentDate = new Date();
		walletEntity.setLenderId(wallet.getLenderId());
		walletEntity.setBorrowId(wallet.getBorrowId());
		walletEntity.setBalance(wallet.getAmount());
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);

	}

	private void transactionLogCreate(TransactionEntity transactionEntity, Wallet wallet,
			long walletId) {
		Date currentDate = new Date();
		transactionEntity.setWalletId(walletId);
		transactionEntity.setlenderId(wallet.getLenderId());
		transactionEntity.setBorrowerId(wallet.getBorrowId());
		transactionEntity.setComment(wallet.getComment());
		transactionEntity.setAmount(wallet.getAmount());
		transactionEntity.setType(wallet.getTxnType());
		transactionEntity.setDate(currentDate);

	}

}
