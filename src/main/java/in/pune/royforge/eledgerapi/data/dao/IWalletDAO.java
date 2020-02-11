package in.pune.royforge.eledgerapi.data.dao;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface IWalletDAO {

	void save(WalletTransaction wallet);
	
	WalletData listOfWallet();
	
}
