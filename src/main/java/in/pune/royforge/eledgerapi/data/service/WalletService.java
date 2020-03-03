package in.pune.royforge.eledgerapi.data.service;

import java.util.List;
import java.util.UUID;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface WalletService {

	boolean save(WalletTransaction walletTransaction);

	List<WalletData> getWallets();

	WalletData getWalletDataByIds(String lenderId, UUID borrowId);

	WalletData getWallet(Long walletId);

	List<WalletData> findWalletsListByLenderId(String lenderId);

	boolean deleteWallet(long walletId);

}
