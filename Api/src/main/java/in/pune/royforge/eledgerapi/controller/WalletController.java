package in.pune.royforge.eledgerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.data.service.WalletService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public WalletEntity createOrUpdateWallet(@RequestBody WalletTransaction walletTransaction) {
		return walletEntityService.save(walletTransaction);
	}

	@RequestMapping(value = "/wallets", method = RequestMethod.GET)
	public List<WalletData> getWallets() {
		return walletEntityService.getWallets();
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.GET)
	public WalletData getWallet(@PathVariable(value = "walletId") Long walletId) {
		return walletEntityService.getWallet(walletId);
	}

	@RequestMapping(value = "/lenderId/{lenderid}", method = RequestMethod.GET)
	public List<WalletData> findWalletsListByLenderId(@PathVariable(value = "lenderid") String lenderId) {
		return walletEntityService.findWalletsListByLenderId(lenderId);
	}

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowId}", method = RequestMethod.GET)
	public WalletData getListOfWalletById(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowId") String borrowId) {
		return walletEntityService.getWalletDataByIds(lenderId, borrowId);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.DELETE)
	public boolean deleteWallet(@PathVariable(value = "walletId") Long walletId) {
		return walletEntityService.deleteWallet(walletId);
	}

}