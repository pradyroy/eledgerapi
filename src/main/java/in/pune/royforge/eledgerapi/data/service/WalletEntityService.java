package in.pune.royforge.eledgerapi.data.service;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public interface WalletEntityService {
	
	List<WalletEntity> get();
	
	WalletEntity get(long id);
	
	void save(WalletEntity walletEntity);

}
