package in.pune.royforge.eledgerapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import in.pune.royforge.eledgerapi.data.repo.TransactionLogRepository;
import in.pune.royforge.eledgerapi.data.service.WalletService;

@RestController
@RequestMapping("/tansactionlog")

public class TransactionController {
		
	@Autowired
	WalletService walletEntityService;

//	@RequestMapping(method = RequestMethod.GET)
//	public void transactionlog() {
//		walletEntityService.save(wallet);
//	}
	

}
