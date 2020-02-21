package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface IWalletDAO {

	boolean save(WalletTransaction wallet);

	boolean delete(long walletId);

	WalletData getWalletDataByIds(String lenderId, String borrowId);

	List<WalletData> getWallets();

	WalletData getWallet(long walletId);

	List<WalletData> findWalletsListByLenderId(String lenderId);

}
