package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.pune.royforge.eledgerapi.data.dao.IWalletDAO;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.exceptionhandler.RecordNotFoundException;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private IWalletDAO walletEntityDAO;

	@Override
	public void save(WalletTransaction walletTransaction) {
		walletEntityDAO.save(walletTransaction);
	}

	@Override
	public WalletData getWallet(Long walletId) throws RecordNotFoundException{
		WalletData walletData = walletEntityDAO.getWallet(walletId);
		if(walletData == null) {
			throw new RecordNotFoundException("Record Not Found");
		}
		return walletData;
	}

	@Override
	public List<WalletData> getWallets() {
		return walletEntityDAO.getWallets();
	}

	@Override
	public List<WalletData> findWalletsListByLenderId(String lenderId) {
		return walletEntityDAO.findWalletsListByLenderId(lenderId);
	}

	public boolean delete(Long walletId) {
		return walletEntityDAO.delete(walletId);

	}

	@Override
	public WalletData getWalletDataByIds(String lenderId, String borrowId) {
		return walletEntityDAO.getWalletDataByIds(lenderId, borrowId);
	}
}