package in.pune.royforge.eledgerapi.data.model;

import java.util.List;
import java.util.Date;


import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public class WalletData {
	
	private List<WalletEntity> listOfWallets;

	private Long walletId;

	private String lenderId;

	private String borrowId;

	private Double balance;

	private Date createdDate;

	private Date updatedDate;

	public List<WalletEntity> getListOfWallets() {
		return listOfWallets;
	}

	public void setListOfWallets(List<WalletEntity> listOfWallets2) {
		this.listOfWallets = listOfWallets2;
	}

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public String getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
