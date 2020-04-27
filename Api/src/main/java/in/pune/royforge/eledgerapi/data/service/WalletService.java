package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public interface WalletService {

	WalletEntity save(WalletTransaction walletTransaction);

	List<WalletData> getWallets();

	WalletData getWalletDataByIds(String lenderId, String borrowId);

	WalletData getWallet(Long walletId);

	List<WalletData> findWalletsListByLenderId(String lenderId);

	boolean deleteWallet(long walletId);

}
