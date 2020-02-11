package in.pune.royforge.eledgerapi.data.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionEntity;


public interface TransactionLogRepository extends PagingAndSortingRepository<TransactionEntity, String> {
	


	


}
