package in.pune.royforge.connection.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.connection.entity.LenderDataEntity;

public interface AuthenticationUserRepository extends PagingAndSortingRepository<LenderDataEntity, Long> {

	LenderDataEntity findByPhone(Long phone);

	LenderDataEntity findByEmail(String email);
}
