package in.pune.royforge.eledgerapi.data.model;

import java.util.Date;
import java.util.UUID;

public class WalletTransaction {

	private Long walletId;

	private String lenderId;

	private UUID borrowId;

	private Double amount;

	private TransactionType txnType;

	private Date createdDate;

	private Date updatedDate;

	private String comment;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTxnType() {
		return txnType;
	}

	public void setTxnType(TransactionType txnType) {
		this.txnType = txnType;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
