package in.pune.royforge.eledgerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.model.WalletData;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.data.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public void createWallet(@RequestBody WalletTransaction wallet) {
		walletEntityService.save(wallet);
	}

	@RequestMapping(value = "/{walletId}", method = RequestMethod.GET)
	public WalletData getWallet(@PathVariable(value = "walletId") Long walletId) {
		return walletEntityService.getAWallet(walletId);
	}

	@RequestMapping(value = "/{lenderId}/{borrowId}", method = RequestMethod.GET)
	public List<WalletData> getListOfWalletByLenderIdAndBorrowId(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowId") String borrowId) {
		return walletEntityService.getListOfWalletByLenderIdAndBorrowId(lenderId, borrowId);
	}
}
