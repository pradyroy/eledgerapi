package in.pune.royforge.eledgerapi.data.service;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface WalletService {

	void save(WalletTransaction walletTransaction);

	WalletData listOfWallet();


	WalletData getAWallet(Long walletId);
}
