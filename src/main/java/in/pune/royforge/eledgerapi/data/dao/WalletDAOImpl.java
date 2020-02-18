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
import in.pune.royforge.eledgerapi.data.model.TransactionType;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;

@Repository
public class WalletDAOImpl implements IWalletDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;
	@Autowired
	ITransactionLogRepository transactionLogRepository;

	/*
	 * Input: save(WalletTransaction wallet) method is used to create or update the
	 * wallet in the database. Output: save the walletEntity in the repository.
	 */
	@Override
	public void save(WalletTransaction walletTransaction) {
		WalletEntity walletEntity = new WalletEntity();
		WalletEntity walletEntityobj = null;
		if (walletTransaction.getWalletId() == null) {
			createWallet(walletEntity, walletTransaction);
			walletEntityobj = walletEntityRepository.save(walletEntity);
		} else {
			updateWallet(walletEntity, walletTransaction);
			walletEntityobj = walletEntityRepository.save(walletEntity);
		}
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionLogCreate(transactionEntity, walletTransaction, walletEntityobj.getWalletId());
		transactionLogRepository.save(transactionEntity);
	}

	/*
	 * Input: createWallet([walletEntity], [walletTransaction]) method is used to
	 * create the wallet in the database or to make entry in WalletEntity table.
	 * Output: save the entries in walletEntity object.
	 */
	private void createWallet(WalletEntity walletEntity, WalletTransaction walletTransaction) {
		Date currentDate = new Date();
		walletEntity.setLenderId(walletTransaction.getLenderId());
		walletEntity.setBorrowId(walletTransaction.getBorrowId());
		walletEntity.setBalance(walletTransaction.getAmount());
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);
	}

	/*
	 * Input: updateWallet([walletEntity], [walletTransaction]) method is used to
	 * update the wallet in the database by using specific walletId. Output: save
	 * the entries in walletEntity object.
	 */
	private void updateWallet(WalletEntity walletEntity, WalletTransaction wallet) {
		Optional<WalletEntity> existedWallet = walletEntityRepository.findById(wallet.getWalletId());
		if (!existedWallet.isEmpty()) {
			Date currentDate = new Date();
			Double newBalance = 0d;
			if (wallet.getTxnType() == TransactionType.CREDIT) {
				newBalance = existedWallet.get().getBalance() - wallet.getAmount();
			} else if (wallet.getTxnType() == TransactionType.DEBIT) {
				newBalance = existedWallet.get().getBalance() + wallet.getAmount();
			}
			walletEntity.setCreatedDate(existedWallet.get().getCreatedDate());
			walletEntity.setWalletId(existedWallet.get().getWalletId());
			walletEntity.setBalance(newBalance);
			walletEntity.setUpdatedDate(currentDate);
			walletEntity.setBorrowId(wallet.getBorrowId());
			walletEntity.setLenderId(wallet.getLenderId());
		}
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

	private void setWalletData(WalletEntity walletEntity, WalletData walletData) {
		walletData.setBalance(walletEntity.getBalance());
		walletData.setBorrowId(walletEntity.getBorrowId());
		walletData.setCreatedDate(walletEntity.getCreatedDate());
		walletData.setLenderId(walletEntity.getLenderId());
		walletData.setUpdatedDate(walletEntity.getUpdatedDate());
		walletData.setWalletId(walletEntity.getWalletId());
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

	/*
	 * Input: getWallet([walletId]) method is used to retrieve the walletData from
	 * the walletEntity table using specific walletID. Output: return walletData
	 * object.
	 */
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
	 * Method is used to fetch the wallets list by taking lender id;
	 */
	@Override
	public List<WalletData> findWalletsListByLenderId(String lenderId) {
		List<WalletData> walletsOfLender = new ArrayList<>();
		Iterable<WalletEntity> walletsList = walletEntityRepository.findByLenderId(lenderId);
		for (WalletEntity walletEntity : walletsList) {
			WalletData walletData = new WalletData();
			setWalletData(walletEntity, walletData);
			walletsOfLender.add(walletData);
		}
		return walletsOfLender;
	}
}
