package in.pune.royforge.eledgerapi.data.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;

public interface ITransactionLogRepository extends PagingAndSortingRepository<TransactionEntity, Long> {

	@Query("FROM TransactionEntity WHERE lenderId = ?1 AND borrowerId = ?2")
	Iterable<TransactionEntity> transactionsList(String lenderId, String borrowerId);

	@Query("FROM TransactionEntity WHERE lenderId = ?1  AND ( DATE(date) BETWEEN ?2 AND ?3 )")
	Iterable<TransactionEntity> transactionListBetweenTwoDates(String lenderId, Date startDate, Date endDate);
}
