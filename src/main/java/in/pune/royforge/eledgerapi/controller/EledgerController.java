package in.pune.royforge.eledgerapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.model.CustomerLedger;
import in.pune.royforge.eledgerapi.data.repo.CustomerLedgerRepository;
import in.pune.royforge.eledgerapi.data.service.WalletEntityService;

/**
 * 
 * @author pradyroy
 *
 */

@RestController
@RequestMapping("/eledgerapi")
public class EledgerController {

	@Autowired
	CustomerLedgerRepository customerLedgerRepository;

	@Autowired
	WalletEntityService walletEntityService;

	@RequestMapping(value = "heartbeat", method = RequestMethod.GET)
	public String heartbeat() {
		String currentDateOfTheServer = new Date().toString();
		return currentDateOfTheServer;
	}

	@RequestMapping(method = RequestMethod.POST)
	public CustomerLedger createCustomerAccount(@RequestBody CustomerLedger customerLedger) {
		Date currentDate = new Date();
		customerLedger.setTimestamp(currentDate);
		CustomerLedger createdLedger = customerLedgerRepository.save(customerLedger);
		return createdLedger;
	}

	@RequestMapping(value = "lendmoney", method = RequestMethod.POST)
	public CustomerLedger lendMoney(@RequestBody CustomerLedger customerLedger) {
		Date currentDate = new Date();
		customerLedger.setTimestamp(currentDate);

		Optional<CustomerLedger> existingLedger = customerLedgerRepository.findById(customerLedger.getId());

		Double newbalance = existingLedger.get().getBalance() - customerLedger.getDebit();

		customerLedger.setBalance(newbalance);

		CustomerLedger createdLedger = customerLedgerRepository.save(customerLedger);
		return createdLedger;
	}

	@RequestMapping(value = "receivemoney", method = RequestMethod.POST)
	public CustomerLedger receiveMoney(@RequestBody CustomerLedger customerLedger) {
		Date currentDate = new Date();
		customerLedger.setTimestamp(currentDate);

		Optional<CustomerLedger> existingLedger = customerLedgerRepository.findById(customerLedger.getId());

		Double newbalance = existingLedger.get().getBalance() + customerLedger.getCredit();

		customerLedger.setBalance(newbalance);

		CustomerLedger createdLedger = customerLedgerRepository.save(customerLedger);
		return createdLedger;
	}

	@RequestMapping(value = "getaccountbal/{accountNum}", method = RequestMethod.GET)
	public Double getAccountBalance(@PathVariable(value = "accountNum") Long accountNum) {

		Optional<CustomerLedger> existingLedger = customerLedgerRepository.findById(accountNum);

		return existingLedger.get().getBalance();
	}

	@RequestMapping(value = "getmerchantbal/{merchantid}", method = RequestMethod.GET)
	public Double getMerchAccountBalance(@PathVariable(value = "merchantid") String merchantid) {

		Iterable<CustomerLedger> existingLedgers = customerLedgerRepository.findByMerchantid(merchantid);
		Double totalBalance = 0.0;

		for (CustomerLedger existingLedger : existingLedgers) {
			totalBalance = existingLedger.getBalance() + totalBalance;
		}

		return totalBalance;
	}

	@RequestMapping(value = "/createawallet", method = RequestMethod.POST)
	public WalletEntity createaaccount(@RequestBody WalletEntity walletEntity) {
		walletEntityService.save(walletEntity);
		return walletEntity;
	}

}