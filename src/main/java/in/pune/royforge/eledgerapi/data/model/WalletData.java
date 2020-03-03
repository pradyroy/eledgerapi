package in.pune.royforge.eledgerapi.data.model;

import java.util.Date;
import java.util.UUID;

public class WalletData {

	private Long walletId;

	private String lenderId;

	private UUID borrowId;

	private Double balance;

	private Date createdDate;

	private Date updatedDate;

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

	public UUID getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(UUID borrowId) {
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
