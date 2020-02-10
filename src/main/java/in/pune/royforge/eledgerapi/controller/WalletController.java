package in.pune.royforge.eledgerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.model.Wallet;
import in.pune.royforge.eledgerapi.data.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public void createaaccount(@RequestBody Wallet wallet) {
		walletEntityService.save(wallet);
	}
}
