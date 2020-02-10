package in.pune.royforge.eledgerapi.data.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerapi.data.entity.TransactionStringEntity;
import in.pune.royforge.eledgerapi.data.model.CustomerLedger;

/**
 * 
 * @author pradyroy
 *
 */

public interface CustomerLedgerRepository extends PagingAndSortingRepository<CustomerLedger, Long> {
	
	public Iterable<CustomerLedger> findByMerchantid(String merchantid);

	

//	public TransactionStringEntity save(TransactionStringEntity customerLedger);

}
