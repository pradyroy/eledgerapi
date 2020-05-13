package in.pune.royforge.connection.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.pune.royforge.connection.entity.WalletEntity;
import in.pune.royforge.connection.model.WalletData;
import in.pune.royforge.connection.model.WalletTransaction;

@Service
@FeignClient(name = "main-api", url = "localhost:8080/wallet")
public interface WalletService {

	@RequestMapping(method = RequestMethod.POST)
	public WalletEntity save(WalletTransaction walletTransaction);

	@RequestMapping(value = "/wallets", method = RequestMethod.GET)
	public List<WalletData> getWallets();

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.GET)
	public WalletData getWallet(@PathVariable(value = "walletId") Long walletId);

	@RequestMapping(value = "/lenderId/{lenderid}", method = RequestMethod.GET)
	public List<WalletData> findWalletsListByLenderId(@PathVariable(value = "lenderid") String lenderId);

	@RequestMapping(value = "/lenderId/{lenderId}/borrowId/{borrowId}", method = RequestMethod.GET)
	public WalletData getWalletDataByIds(@PathVariable(value = "lenderId") String lenderId,
			@PathVariable(value = "borrowId") String borrowId);

	@RequestMapping(value = "/walletId/{walletId}", method = RequestMethod.DELETE)
	public boolean deleteWallet(@PathVariable(value = "walletId") Long walletId);
}
