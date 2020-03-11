package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface IWalletDAO {

	WalletEntity save(WalletTransaction wallet);

	WalletData getWalletDataByIds(String lenderId, String borrowId);

	List<WalletData> getWallets();

	WalletData getWallet(long walletId);

	List<WalletData> findWalletsListByLenderId(String lenderId);

	boolean deleteWallet(long walletId);

}
