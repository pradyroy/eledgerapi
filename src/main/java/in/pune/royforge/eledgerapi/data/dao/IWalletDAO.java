package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;
import java.util.UUID;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface IWalletDAO {

	boolean save(WalletTransaction wallet);

	WalletData getWalletDataByIds(String lenderId, String borrowId);

	List<WalletData> getWallets();

	WalletData getWallet(long walletId);

	List<WalletData> findWalletsListByLenderId(String lenderId);
	
	boolean deleteWallet(long walletId);

}
