package in.pune.royforge.eledgerapi.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;

@Repository
public class WalletDAOImpl implements IWalletDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;

	@Override
	public void save(WalletTransaction walletTransaction) {

		if (walletTransaction.getWalletId() == null) {
			WalletEntity walletEntity = new WalletEntity();
			createWallet(walletEntity, walletTransaction);
			WalletEntity walletEntityobj = walletEntityRepository.save(walletEntity);
		}
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
	public List<WalletData> getWallets(){
		List<WalletData> wallets = new ArrayList<>();
		Iterable<WalletEntity> walletsList =  walletEntityRepository.findAll();
		for(WalletEntity walletEntity:walletsList) {
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
