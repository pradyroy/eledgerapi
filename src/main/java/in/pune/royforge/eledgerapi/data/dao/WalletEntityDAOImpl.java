package in.pune.royforge.eledgerapi.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;
import in.pune.royforge.eledgerapi.data.repo.WalletEntityRepository;


@Repository
public class WalletEntityDAOImpl implements WalletEntityDAO {

	@Autowired
	WalletEntityRepository walletEntityRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<WalletEntity> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from WalletEntity", WalletEntity.class);
		List<WalletEntity> list = query.getResultList();
		return list;
	}

	@Override
	public WalletEntity get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(WalletEntity walletEntity) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(walletEntity);

	}

}
