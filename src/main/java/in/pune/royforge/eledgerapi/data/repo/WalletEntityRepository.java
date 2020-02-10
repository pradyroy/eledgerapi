package in.pune.royforge.eledgerapi.data.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public interface WalletEntityRepository extends PagingAndSortingRepository<WalletEntity, Long> {

}
