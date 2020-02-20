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
	public WalletData getWallet(Long walletId) throws RecordNotFoundException {
		WalletData walletData = walletEntityDAO.getWallet(walletId);
		if (null == walletData) {
			throw new RecordNotFoundException("walletId Not Found in Record");
		}
		return walletData;
	}

	@Override
	public List<WalletData> getWallets() {
		return walletEntityDAO.getWallets();
	}

	@Override
	public List<WalletData> findWalletsListByLenderId(String lenderId) throws RecordNotFoundException {
		List<WalletData> walletData = walletEntityDAO.findWalletsListByLenderId(lenderId);
		if (walletData.isEmpty()) {
			throw new RecordNotFoundException("List of Wallets not found for the given lender-ID");
		}
		return walletData;
	}

	public boolean delete(Long walletId) {
		boolean walletDelete = walletEntityDAO.delete(walletId);
		if (!walletDelete) {
			throw new RecordNotFoundException("Wallet Not Exist");
		}
		return walletDelete;
	}

	@Override
	public WalletData getWalletDataByIds(String lenderId, String borrowId) {
		WalletData walletData = walletEntityDAO.getWalletDataByIds(lenderId, borrowId);
		if (null == walletData) {
			throw new RecordNotFoundException("Customer or Merchant or both Not Found");
		}
		return walletData;
	}
}