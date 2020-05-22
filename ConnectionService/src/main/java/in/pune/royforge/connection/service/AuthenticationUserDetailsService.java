package in.pune.royforge.connection.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.pune.royforge.connection.entity.LenderDataEntity;
import in.pune.royforge.connection.model.LenderData;
import in.pune.royforge.connection.repo.AuthenticationUserRepository;

@Service
public class AuthenticationUserDetailsService implements UserDetailsService {

	@Autowired(required = true)
	private AuthenticationUserRepository repository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LenderDataEntity user = null;

		if (username.matches("^(.+)@(.+)$")) {
			user = repository.findByEmail(username);
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					new ArrayList<>());
		} else {
			user = repository.findByPhone(Long.parseLong(username));
			return new org.springframework.security.core.userdetails.User(user.getPhone().toString(),
					user.getPassword(), new ArrayList<>());
		}
	}

	public LenderData getLenderDetails(String username) {
		LenderData lender = new LenderData();
		LenderDataEntity user = null;
		if (username.matches("^(.+)@(.+)$")) {
			user = repository.findByEmail(username);
			lender = setLenderData(user);
			return lender;

		} else {
			user = repository.findByPhone(Long.parseLong(username));
			lender = setLenderData(user);
			return lender;
		}
	}

	private LenderData setLenderData(LenderDataEntity user) {
		LenderData lender = new LenderData();
		lender.setId(user.getId());
		lender.setLenderId(user.getLenderId());
		lender.setEmail(user.getEmail());
		lender.setName(user.getName());
		lender.setPassword(user.getPassword());
		lender.setPhone(user.getPhone());
		lender.setShopName(user.getShopName());
		return lender;
	}
}
