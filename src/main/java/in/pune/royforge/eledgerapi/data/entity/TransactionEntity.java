package in.pune.royforge.eledgerapi.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class TransactionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;

	@Column
	private long walletId;

	@Column
	private String lenderId;

	@Column
	private String borrowerId;

	@Column
	private String comment;

	@Column
	private double amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date date;

	@Column
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

	public void setTxnType(String string) {
		this.txnType = string;
	}

}
