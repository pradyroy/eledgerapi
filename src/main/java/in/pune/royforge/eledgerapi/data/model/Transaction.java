package in.pune.royforge.eledgerapi.data.model;

import java.util.Date;

public class Transaction {

	private long transactionId;

	private long walletId;

	private String lenderId;

	private String borrowerId;

	private String comment;

	private double amount;

	private Date date;
	
	private String txnType;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getWalletId() {
		return walletId;
	}

	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}

	public String getlenderId() {
		return lenderId;
	}

	public void setlenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public String getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	
	
	

}
