package in.pune.royforge.eledgerapi.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.pune.royforge.eledgerapi.data.dao.IWalletDAO;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

@Transactional
@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private IWalletDAO walletEntityDAO;

	@Transactional
	@Override
	public void save(WalletTransaction wallet) {
		walletEntityDAO.save(wallet);

	}

	@Override
	public WalletData getAWallet(Long walletId) {
		WalletData walletData = walletEntityDAO.getAWallet(walletId);
		return walletData;
	}
}