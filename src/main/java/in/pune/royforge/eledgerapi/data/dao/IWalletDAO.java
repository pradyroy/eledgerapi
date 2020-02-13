package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface IWalletDAO {

	void save(WalletTransaction wallet);

	List<WalletData> getListOfWalletById(String lenderId, String borrowId);

	List<WalletData> getWallets();

	WalletData getWallet(Long walletId);
}
