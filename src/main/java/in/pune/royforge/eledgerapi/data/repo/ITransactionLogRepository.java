package in.pune.royforge.eledgerapi.data.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;

public interface ITransactionLogRepository extends PagingAndSortingRepository<TransactionEntity, String> {
	public Iterable<TransactionEntity> findByLenderId(String lenderId);

}