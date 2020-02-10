package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public interface WalletEntityDAO {

	List<WalletEntity> get();

	WalletEntity get(long id);

	void save(WalletEntity walletEntity);
}
