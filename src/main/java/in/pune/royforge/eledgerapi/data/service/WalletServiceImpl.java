package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.pune.royforge.eledgerapi.data.dao.IWalletDAO;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.exceptionhandler.InvalidArgumentException;
import in.pune.royforge.eledgerapi.exceptionhandler.RecordNotFoundException;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private IWalletDAO walletEntityDAO;

	@Override
	public boolean save(WalletTransaction walletTransaction) throws InvalidArgumentException {
		if (null != walletTransaction.getLenderId() && null != walletTransaction.getAmount()
				&& null != walletTransaction.getTxnType()) {
			return walletEntityDAO.save(walletTransaction);
		} else {
			throw new InvalidArgumentException("Required Valid Input to Perform Operation");
		}
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

	@Override
	public WalletData getWalletDataByIds(String lenderId, String borrowId) throws RecordNotFoundException {
		WalletData walletData = walletEntityDAO.getWalletDataByIds(lenderId, borrowId);
		if (null == walletData) {
			throw new RecordNotFoundException("Customer or Merchant or both Not Found");
		}
		return walletData;
	}

	@Override
	public boolean deleteWallet(long walletId) {
		boolean deleteWallet = walletEntityDAO.deleteWallet(walletId);
		if (!deleteWallet) {
			throw new RecordNotFoundException("Wallet Not Found");
		}
		return deleteWallet;

	}
}