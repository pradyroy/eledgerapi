package in.pune.royforge.eledgerapi.data.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public interface WalletEntityRepository extends PagingAndSortingRepository<WalletEntity, Long> {

	Iterable<WalletEntity> findByLenderId(String lenderId);

	@Query("FROM WalletEntity  WHERE lenderId= ?1 AND borrowId= ?2")
	WalletEntity getWalletDataByIds(String lenderId, String borrowId);
}
