package in.pune.royforge.eledgerapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.model.Response;
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
	public ResponseEntity<Boolean> createOrUpdateWallet(@RequestBody WalletTransaction walletTransaction) {
		return new ResponseEntity<>(walletEntityService.save(walletTransaction), HttpStatus.OK);
	}

	@RequestMapping(value = "/wallets", method = RequestMethod.GET)
	public ResponseEntity<List<WalletData>> getWallets() {
		return new ResponseEntity<>(walletEntityService.getWallets(), HttpStatus.OK);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getWallet(@PathVariable(value = "walletId") Long walletId) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.getWallet(walletId)), HttpStatus.OK);
	}


	@RequestMapping(value = "/lenderId/{lenderid}", method = RequestMethod.GET)
	public ResponseEntity<List<WalletData>> findWalletsListByLenderId(
			@PathVariable(value = "lenderid") String lenderId) {
		return new ResponseEntity<>(walletEntityService.findWalletsListByLenderId(lenderId), HttpStatus.OK);
	}

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowId}", method = RequestMethod.GET)
	public ResponseEntity<WalletData> getListOfWalletById(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowId") String borrowId) {
		return new ResponseEntity<>(walletEntityService.getWalletDataByIds(lenderId, borrowId),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteWallet(@PathVariable(value = "walletId") Long walletId) {
		return new ResponseEntity<>(walletEntityService.deleteWallet(walletId),HttpStatus.OK);
	}
}