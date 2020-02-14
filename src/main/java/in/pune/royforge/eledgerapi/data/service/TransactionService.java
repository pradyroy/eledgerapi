package in.pune.royforge.eledgerapi.data.service;

import java.sql.Date;
import java.util.List;

import in.pune.royforge.eledgerapi.data.model.Transaction;

public interface TransactionService {

	List<Transaction> transactionListByLenderIdAndStratDate(String lenderId, Date startDate);
}
