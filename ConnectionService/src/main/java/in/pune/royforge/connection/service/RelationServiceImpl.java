package in.pune.royforge.connection.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.pune.royforge.connection.model.CustomerData;
import in.pune.royforge.connection.model.RelationCustomer;
import in.pune.royforge.connection.model.RelationReport;
import in.pune.royforge.connection.model.Transaction;
import in.pune.royforge.connection.model.WalletData;

@Service
public class RelationServiceImpl implements IRelationService {

	@Autowired
	TransactionService transactionService;

	@Autowired
	ICustomerService customerEntityService;
	@Autowired
	WalletService walletService;

	@Override
	public List<RelationCustomer> getUsers(String lenderId) {
		List<WalletData> walletList = walletService.findWalletsListByLenderId(lenderId);
		List<CustomerData> customerList = customerEntityService.getAllCustomers();

		List<RelationCustomer> userList = new ArrayList<>();
		if (null != lenderId) {
			for (WalletData wallet : walletList) {
				for (CustomerData customer : customerList) {
					if (wallet.getBorrowId().equals(customer.getBorrowId())) {
						RelationCustomer user = new RelationCustomer();
						user.setWalletId(wallet.getWalletId());
						user.setDate(wallet.getUpdatedDate());
						user.setAmount(wallet.getBalance());
						user.setBorrowId(customer.getBorrowId());
						user.setId(customer.getId());
						user.setLenderId(customer.getLenderId());
						user.setName(customer.getName());
						user.setPhone(customer.getPhone());
						userList.add(user);
					}
				}
			}
			return userList;
		} else {
			return null;
		}
	}

	@Override
	public List<RelationReport> getAllUsers(String lenderId) {
		List<Transaction> transactionList = transactionService.transactionsByLenderId(lenderId);
		List<CustomerData> customerList = customerEntityService.getAllCustomers();
		List<RelationReport> userList = new ArrayList<>();
		if (null != lenderId) {
			for (Transaction transaction : transactionList) {
				for (CustomerData customer : customerList) {
					if (transaction.getBorrowerId().equals(customer.getBorrowId())) {
						RelationReport user = new RelationReport();
						user.setDate(transaction.getDate());
						user.setAmount(transaction.getAmount());
						user.setName(customer.getName());
						user.setPhone(customer.getPhone());
						user.setTxnType(transaction.getTxnType());
						userList.add(user);
					}
				}
			}
			return userList;
		} else {
			return null;
		}
	}
}
