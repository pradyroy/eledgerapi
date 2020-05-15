package in.pune.royforge.connection.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<RelationCustomer> getUsers(String lenderId) {
		RestTemplate resetemplate = new RestTemplate();
		ResponseEntity<WalletData[]> responseWallet = resetemplate
				.getForEntity("http://localhost:8080/wallet/lenderId/" + lenderId, WalletData[].class);
		ResponseEntity<CustomerData[]> responseCustomer = resetemplate
				.getForEntity("http://localhost:8081/customer/customers", CustomerData[].class);

		WalletData[] walletList = responseWallet.getBody();
		CustomerData[] customerList = responseCustomer.getBody();
		List<RelationCustomer> userList = new ArrayList<>();

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
	}

	@Override
	public List<RelationReport> getAllUsers(String lenderId) {
		RestTemplate resetemplate = new RestTemplate();
		ResponseEntity<Transaction[]> responseWallet = resetemplate
				.getForEntity("http://localhost:8080/transaction/lenderId/" + lenderId, Transaction[].class);
		ResponseEntity<CustomerData[]> responseCustomer = resetemplate
				.getForEntity("http://localhost:8081/customer/allcustomers", CustomerData[].class);

		Transaction[] transactionList = responseWallet.getBody();
		CustomerData[] customerList = responseCustomer.getBody();
		List<RelationReport> userList = new ArrayList<>();

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
	}
}
