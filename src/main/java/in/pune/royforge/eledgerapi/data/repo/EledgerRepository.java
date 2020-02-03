package in.pune.royforge.eledgerapi.data.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.model.Eledger;

/**
 * 
 * @author pradyroy
 *
 */

public interface EledgerRepository extends PagingAndSortingRepository<Eledger, Long> {

}
