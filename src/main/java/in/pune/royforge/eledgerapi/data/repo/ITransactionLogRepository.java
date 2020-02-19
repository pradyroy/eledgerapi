package in.pune.royforge.eledgerapi.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;

public interface ITransactionLogRepository extends PagingAndSortingRepository<TransactionEntity, Long> {

	@Query("FROM TransactionEntity WHERE lenderId = ?1 AND borrowerId = ?2")
	List<TransactionEntity> transactionsList(String lenderId, String borrowerId);

}
