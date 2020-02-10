package in.pune.royforge.eledgerapi.data.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.pune.royforge.eledgerapi.data.dao.WalletEntityDAO;
import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

@Transactional
@Service
public class WalletEntityServiceImpl implements WalletEntityService {

	@Autowired
	private WalletEntityDAO walletEntityDAO;

	@Transactional
	@Override
	public List<WalletEntity> get() {
		return walletEntityDAO.get();
	}

	@Transactional
	@Override
	public WalletEntity get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(WalletEntity walletEntity) {
		Date currentDate = new Date();
		walletEntity.setCreatedDate(currentDate);
		walletEntity.setUpdatedDate(currentDate);
		walletEntityDAO.save(walletEntity);
	}

}
