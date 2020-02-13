package in.pune.royforge.eledgerapi.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

import in.pune.royforge.eledgerapi.data.repo.ITransactionLogRepository;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;

@Repository
public class WalletDAOImpl implements IWalletDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;

	@Autowired
	ITransactionLogRepository transactionLogRepository;

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
		transactionLogRepository.save(transactionEntity);

	}

	private void createWallet(WalletEntity walletEntity, WalletTransaction walletTransaction) {

		Date currentDate = new Date();
		walletEntity.setLenderId(walletTransaction.getLenderId());
		walletEntity.setBorrowId(walletTransaction.getBorrowId());
		walletEntity.setBalance(walletTransaction.getAmount());
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);
	}

	@Override
	public List<WalletData> getWallets() {
		List<WalletData> wallets = new ArrayList<>();
		Iterable<WalletEntity> walletsList = walletEntityRepository.findAll();
		for (WalletEntity walletEntity : walletsList) {
			WalletData walletData = new WalletData();
			setWalletData(walletEntity, walletData);
			wallets.add(walletData);
		}
		return wallets;
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
	public WalletData getWallet(Long walletId) {
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

	/*
	 * Input: String [lenderId], String [borrowId]. Output: return list of type
	 * WalletData. Operation: This method is used to get the list of wallet with the
	 * help of lenderId and borrowId.
	 */
	@Override
	public List<WalletData> getListOfWalletById(String lenderId, String borrowId) {
		List<WalletData> wallets = new ArrayList<>();
		Iterable<WalletEntity> walletsList = walletEntityRepository.getListOfWalletById(lenderId, borrowId);
		for (WalletEntity walletEntity : walletsList) {
			WalletData walletData = new WalletData();
			setWalletData(walletEntity, walletData);
			wallets.add(walletData);
		}
		return wallets;
	}

	/*
	 * Input: (WalletEntity walletEntity, WalletData walletData) Output: This method
	 * is used to set the data from one object[WalletEntity] to another
	 * object[WalletData].
	 */
	private void setWalletData(WalletEntity walletEntity, WalletData walletData) {
		walletData.setBalance(walletEntity.getBalance());
		walletData.setBorrowId(walletEntity.getBorrowId());
		walletData.setCreatedDate(walletEntity.getCreatedDate());
		walletData.setLenderId(walletEntity.getLenderId());
		walletData.setUpdatedDate(walletEntity.getUpdatedDate());
		walletData.setWalletId(walletEntity.getWalletId());
	}
}
