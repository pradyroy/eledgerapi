package in.pune.royforge.connection.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.connection.exceptionhandler.InvalidArgumentException;
import in.pune.royforge.connection.exceptionhandler.RecordNotFoundException;
import in.pune.royforge.connection.model.Response;
import in.pune.royforge.connection.model.WalletTransaction;
import in.pune.royforge.connection.service.WalletService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> createOrUpdateWallet(@RequestBody WalletTransaction walletTransaction) {
		if (null != walletTransaction.getLenderId() && null != walletTransaction.getAmount()
				&& null != walletTransaction.getTxnType()) {

			return new ResponseEntity<>(
					new Response(new Date(), "success", HttpStatus.CREATED, walletService.save(walletTransaction)),
					HttpStatus.CREATED);
		} else {

			throw new InvalidArgumentException("Required Valid Input to Perform Operation");
		}

	}

	@RequestMapping(value = "/wallets", method = RequestMethod.GET)
	public ResponseEntity<Response> getWallets() {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, walletService.getWallets()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getWallet(@PathVariable(value = "walletId") Long walletId)
			throws RecordNotFoundException {
		if (null == walletService.getWallet(walletId)) {
			throw new RecordNotFoundException("walletId Not Found in Record");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, walletService.getWallet(walletId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/lenderId/{lenderid}", method = RequestMethod.GET)
	public ResponseEntity<Response> findWalletsListByLenderId(@PathVariable(value = "lenderid") String lenderId)
			throws RecordNotFoundException {
		if (walletService.findWalletsListByLenderId(lenderId).isEmpty()) {
			throw new RecordNotFoundException("List of Wallets not found for the given lender-ID");
		}

		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, walletService.findWalletsListByLenderId(lenderId)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowId}", method = RequestMethod.GET)
	public ResponseEntity<Response> getListOfWalletById(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowId") String borrowId) {
		if (null == walletService.getWalletDataByIds(lenderId, borrowId)) {
			throw new RecordNotFoundException("Customer or Merchant or both Not Found");
		}
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK,
				walletService.getWalletDataByIds(lenderId, borrowId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteWallet(@PathVariable(value = "walletId") Long walletId) {
		if (!walletService.deleteWallet(walletId)) {
			throw new RecordNotFoundException("Wallet Not Found");
		}
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, walletService.deleteWallet(walletId)),
				HttpStatus.OK);
	}

}
