package in.pune.royforge.eledgerapi.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.pune.royforge.eledgerapi.data.dao.IWalletDAO;
import in.pune.royforge.eledgerapi.data.model.Wallet;

@Transactional
@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private IWalletDAO walletEntityDAO;

	@Transactional
	@Override
	public void save(Wallet wallet) {
		walletEntityDAO.save(wallet);

	}
}