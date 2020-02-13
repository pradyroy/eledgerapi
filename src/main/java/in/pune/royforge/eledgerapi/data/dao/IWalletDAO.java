package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface IWalletDAO {

	void save(WalletTransaction wallet);

	WalletData getAWallet(Long walletId);

	List<WalletData> getListOfWalletById(String lenderId, String borrowId);
}
