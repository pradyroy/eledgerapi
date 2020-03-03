package in.pune.royforge.eledgerapi.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	public ResponseEntity<Response> createOrUpdateWallet(@RequestBody WalletTransaction walletTransaction) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.save(walletTransaction)), HttpStatus.OK);
	}

	@RequestMapping(value = "/wallets", method = RequestMethod.GET)
	public ResponseEntity<Response> getWallets() {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.getWallets()), HttpStatus.OK);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getWallet(@PathVariable(value = "walletId") Long walletId) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.getWallet(walletId)), HttpStatus.OK);
	}


	@RequestMapping(value = "/lenderId/{lenderid}", method = RequestMethod.GET)
	public ResponseEntity<Response> findWalletsListByLenderId(
			@PathVariable(value = "lenderid") String lenderId) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.findWalletsListByLenderId(lenderId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getListOfWalletById(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowId") UUID borrowId) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.getWalletDataByIds(lenderId, borrowId)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteWallet(@PathVariable(value = "walletId") Long walletId) {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletEntityService.deleteWallet(walletId)),HttpStatus.OK);
	}
}