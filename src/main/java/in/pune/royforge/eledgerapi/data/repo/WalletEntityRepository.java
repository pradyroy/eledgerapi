package in.pune.royforge.eledgerapi.data.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public interface WalletEntityRepository extends PagingAndSortingRepository<WalletEntity, Long> {

	List<WalletEntity> findByLenderId(String lenderId);

	@Query("FROM WalletEntity  WHERE lenderId= ?1 AND borrowId= ?2")
	WalletEntity getWalletDataByIds(String lenderId, UUID borrowId);
}
