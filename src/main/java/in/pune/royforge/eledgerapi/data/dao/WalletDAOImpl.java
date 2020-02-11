package in.pune.royforge.eledgerapi.data.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

import in.pune.royforge.eledgerapi.data.repo.ITransactionLogRepository;
import in.pune.royforge.eledgerapi.data.model.TransactionType;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;

@Repository
public class WalletDAOImpl implements IWalletDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;
	@Autowired
	ITransactionLogRepository iTransactionLogRepository;

	@Override

	public void save(WalletTransaction wallet) {
		WalletEntity walletEntity = new WalletEntity();
		WalletEntity walletEntityobj = null;

		if (wallet.getWalletId() == null) {
			createWallet(walletEntity, wallet);
			walletEntityobj = walletEntityRepository.save(walletEntity);
		}

		TransactionEntity transactionEntity = new TransactionEntity();
		transactionLogCreate(transactionEntity, wallet, walletEntityobj.getWalletId());

	}

	private void createWallet(WalletEntity walletEntity, WalletTransaction wallet) {
		Date currentDate = new Date();
		walletEntity.setLenderId(wallet.getLenderId());
		walletEntity.setBorrowId(wallet.getBorrowId());
		walletEntity.setBalance(wallet.getAmount());
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);
	}

	private void transactionLogCreate(TransactionEntity transactionEntity, WalletTransaction wallet, long walletId) {
		Date currentDate = new Date();
		transactionEntity.setWalletId(walletId);
		transactionEntity.setlenderId(wallet.getLenderId());
		transactionEntity.setBorrowerId(wallet.getBorrowId());
		transactionEntity.setComment(wallet.getComment());
		transactionEntity.setAmount(wallet.getAmount());
		transactionEntity.setTxnType(wallet.getTxnType().name());
		transactionEntity.setDate(currentDate);

	}

	@Override
	public WalletData getAWallet(Long walletId) {
		Optional<WalletEntity> walletEntity = walletEntityRepository.findById(walletId);

		WalletData walletData = new WalletData();

		walletData.setWalletId(walletEntity.get().getWalletId());
		walletData.setLenderId(walletEntity.get().getLenderId());
		walletData.setBorrowId(walletEntity.get().getBorrowId());
		walletData.setBalance(walletEntity.get().getBalance());
		walletData.setCreatedDate(walletEntity.get().getCreatedDate());
		walletData.setUpdatedDate(walletEntity.get().getUpdatedDate());

		return walletData;
	}

}
