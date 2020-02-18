package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.pune.royforge.eledgerapi.data.dao.IWalletDAO;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private IWalletDAO walletEntityDAO;

	@Override
	public void save(WalletTransaction walletTransaction) {
		walletEntityDAO.save(walletTransaction);
	}

	@Override
	public WalletData getWallet(Long walletId) {
		return walletEntityDAO.getWallet(walletId);
	}

	@Override
	public List<WalletData> getWallets() {
		return walletEntityDAO.getWallets();
	}

	@Override
	public List<WalletData> findWalletsListByLenderId(String lenderId) {
		return walletEntityDAO.findWalletsListByLenderId(lenderId);
	}
}