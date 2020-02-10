package in.pune.royforge.eledgerapi.data.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.Wallet;
import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;

@Repository
public class WalletDAOImpl implements WalletDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;

	@Override
	public void save(Wallet wallet) {

		if (wallet.getWalletId() == null) {
			WalletEntity walletEntity = new WalletEntity();
			createWallet(walletEntity, wallet);
			WalletEntity walletEntityobj = walletEntityRepository.save(walletEntity);
		}

	}

	private void createWallet(WalletEntity walletEntity, Wallet wallet) {
		Date currentDate = new Date();
		walletEntity.setLenderId(wallet.getLenderId());
		walletEntity.setBorrowId(wallet.getBorrowId());
		walletEntity.setBalance(wallet.getAmount());
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);

	}

}
