package in.pune.royforge.eledgerapi.data.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;

public interface ITransactionLogRepository extends PagingAndSortingRepository<TransactionEntity, String> {

	@Query("FROM TransactionEntity WHERE lenderId = ?1  AND DATE(date) =?2 ")
	Iterable<TransactionEntity> transactionListByLenderIdAndStratDate(String lenderId, Date date);
	
}
