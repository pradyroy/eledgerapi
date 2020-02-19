package in.pune.royforge.eledgerapi.data.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;

public interface ITransactionLogRepository extends PagingAndSortingRepository<TransactionEntity, String> {
	 List<TransactionEntity> findByLenderId(String lenderId);

}