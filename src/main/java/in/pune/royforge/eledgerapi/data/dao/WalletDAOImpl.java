package in.pune.royforge.eledgerapi.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	public boolean save(WalletTransaction walletTransaction) {
		if (null != walletTransaction) {
			WalletEntity walletEntity = new WalletEntity();
			TransactionEntity transactionEntity = new TransactionEntity();
			WalletEntity walletEntityObj;
			UUID uuId = UUID.randomUUID();
			if (null == walletTransaction.getWalletId()) {
				walletTransaction.setBorrowId(uuId.toString());
				createWallet(walletEntity, walletTransaction);
				transactionEntity.setBorrowerId(uuId.toString());
				walletEntityObj = walletEntityRepository.save(walletEntity);
			} else {
				Optional<WalletEntity> existedWallet = walletEntityRepository.findById(walletTransaction.getWalletId());
				if (!existedWallet.get().isDeleted()) {
					updateWallet(walletEntity, walletTransaction);
					walletEntityObj = walletEntityRepository.save(walletEntity);
				} else {
					return false;
				}
			}
			transactionLogCreate(transactionEntity, walletTransaction, walletEntityObj.getWalletId());
			transactionLogRepository.save(transactionEntity);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Input: createWallet([walletEntity], [walletTransaction]) method is used to
	 * create the wallet in the database or to make entry in WalletEntity table.
	 * Output: save the entries in walletEntity object.
	 */
	private void createWallet(WalletEntity walletEntity, WalletTransaction walletTransaction) {
		Date currentDate = new Date();
		double newBalance = 0;
		walletEntity.setLenderId(walletTransaction.getLenderId());
		walletEntity.setBorrowId(walletTransaction.getBorrowId());
		if (walletTransaction.getTxnType() == TransactionType.CREDIT) {
			newBalance += walletTransaction.getAmount();
		} else if (walletTransaction.getTxnType() == TransactionType.DEBIT) {
			newBalance -= walletTransaction.getAmount();
		}
		walletEntity.setBalance(newBalance);
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);
		walletEntity.setDeleted(false);
	}

	/*
	 * Input: updateWallet([walletEntity], [walletTransaction]) method is used to
	 * update the wallet in the database by using specific walletId. Output: save
	 * the entries in walletEntity object.
	 */
	private void updateWallet(WalletEntity walletEntity, WalletTransaction wallet) {
		Optional<WalletEntity> existedWallet = walletEntityRepository.findById(wallet.getWalletId());
		if (existedWallet.isPresent()) {
			Date currentDate = new Date();
			double newBalance = 0d;
			if (wallet.getTxnType() == TransactionType.CREDIT) {
				newBalance = existedWallet.get().getBalance() + wallet.getAmount();
			} else if (wallet.getTxnType() == TransactionType.DEBIT) {
				newBalance = existedWallet.get().getBalance() - wallet.getAmount();
			}
			walletEntity.setCreatedDate(existedWallet.get().getCreatedDate());
			walletEntity.setWalletId(existedWallet.get().getWalletId());
			walletEntity.setBalance(newBalance);
			walletEntity.setUpdatedDate(currentDate);
			walletEntity.setBorrowId(existedWallet.get().getBorrowId());
			walletEntity.setLenderId(wallet.getLenderId());
		}
	}

	/*
	 * Get a list of wallets present in the data
	 */
	@Override
	public List<WalletData> getWallets() {
		List<WalletData> wallets = new ArrayList<>();
		Iterable<WalletEntity> walletsList = walletEntityRepository.findAll();
		if (null != walletsList) {
			for (WalletEntity walletEntity : walletsList) {
				if (!walletEntity.isDeleted()) {
					WalletData walletData = new WalletData();
					setWalletData(walletEntity, walletData);
					wallets.add(walletData);
				}
			}
		}
		return wallets;
	}

	/*
	 * Method to get Transaction details To get data from TransactionEntity into
	 * Transaction
	 */
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
	public WalletData getWallet(long walletId) {
		Optional<WalletEntity> walletEntity = walletEntityRepository.findById(walletId);
		WalletData walletData = null;
		if (walletEntity.isPresent()) {
			if (!walletEntity.get().isDeleted()) {
				walletData = new WalletData();
				walletData.setWalletId(walletEntity.get().getWalletId());
				walletData.setLenderId(walletEntity.get().getLenderId());
				walletData.setBorrowId(walletEntity.get().getBorrowId());
				walletData.setBalance(walletEntity.get().getBalance());
				walletData.setCreatedDate(walletEntity.get().getCreatedDate());
				walletData.setUpdatedDate(walletEntity.get().getUpdatedDate());
			}
		}
		return walletData;
	}

	/*
	 * Method is used to fetch the wallets list by taking lender id;
	 */
	@Override
	public List<WalletData> findWalletsListByLenderId(String lenderId) {
		List<WalletData> walletsOfLender = new ArrayList<>();
		List<WalletEntity> walletsList = walletEntityRepository.findByLenderId(lenderId);
		for (WalletEntity walletEntity : walletsList) {
			if (!walletEntity.isDeleted()) {
				WalletData walletData = new WalletData();
				setWalletData(walletEntity, walletData);
				walletsOfLender.add(walletData);
			}
		}
		return walletsOfLender;
	}

	/*
	 * Input: String [lenderId], String [borrowId]. Output: return WalletData
	 * object. Operation: This method is used to get the walletData object contain
	 * all information with the help of lenderId and borrowId.
	 */
	@Override
	public WalletData getWalletDataByIds(String lenderId, String borrowId) {
		WalletEntity walletEntity = walletEntityRepository.getWalletDataByIds(lenderId, borrowId);
		WalletData walletData = null;
		if (null != walletEntity) {
			if (!walletEntity.isDeleted()) {
				walletData = new WalletData();
				setWalletData(walletEntity, walletData);
			}
		}
		return walletData;
	}

	/*
	 * Input: (WalletEntity walletEntity, WalletData walletData), Output: This
	 * method is used to set the data from one object[WalletEntity] to another
	 * object[WalletData].
	 */
	private void setWalletData(WalletEntity walletEntity, WalletData walletData) {
		if (!walletEntity.isDeleted()) {
			walletData.setBalance(walletEntity.getBalance());
			walletData.setBorrowId(walletEntity.getBorrowId());
			walletData.setCreatedDate(walletEntity.getCreatedDate());
			walletData.setLenderId(walletEntity.getLenderId());
			walletData.setUpdatedDate(walletEntity.getUpdatedDate());
			walletData.setWalletId(walletEntity.getWalletId());
		}
	}

	// By taking input {lenderId} to delete the wallet.
	@Override
	public boolean deleteWallet(long walletId) {
		Optional<WalletEntity> existedWallet = walletEntityRepository.findById(walletId);
		if (existedWallet.isPresent()) {
			WalletEntity walletEntity = new WalletEntity();
			setWalletEntity(walletEntity, existedWallet);
			walletEntity.setDeleted(true);
			walletEntityRepository.save(walletEntity);
			return true;
		} else {
			return false;
		}
	}

	private void setWalletEntity(WalletEntity walletEntity, Optional<WalletEntity> existedWallet) {
		walletEntity.setCreatedDate(existedWallet.get().getCreatedDate());
		walletEntity.setWalletId(existedWallet.get().getWalletId());
		walletEntity.setBalance(existedWallet.get().getBalance());
		walletEntity.setUpdatedDate(existedWallet.get().getUpdatedDate());
		walletEntity.setBorrowId(existedWallet.get().getBorrowId());
		walletEntity.setLenderId(existedWallet.get().getLenderId());
	}
}