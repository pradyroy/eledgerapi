package in.pune.royforge.eledgerapi.data.dao;

import java.util.Date;
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
	public void save(WalletTransaction wallet) {

		if (wallet.getWalletId() == null) {
			WalletEntity walletEntity = new WalletEntity();
			createWallet(walletEntity, wallet);
			WalletEntity walletEntityobj = walletEntityRepository.save(walletEntity);
		}

	}

	private void createWallet(WalletEntity walletEntity, WalletTransaction wallet) {
		Date currentDate = new Date();
		walletEntity.setLenderId(wallet.getLenderId());
		walletEntity.setBorrowId(wallet.getBorrowId());
		walletEntity.setBalance(wallet.getAmount());
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);

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
