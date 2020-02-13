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
	public void save(WalletTransaction wallet) {
		walletEntityDAO.save(wallet);
	}

	@Override
	public WalletData getAWallet(Long walletId) {
		return walletEntityDAO.getAWallet(walletId);
	}

	@Override
	public List<WalletData> getListOfWalletById(String lenderId, String borrowId) {
		return walletEntityDAO.getListOfWalletById(lenderId, borrowId);
	}
}