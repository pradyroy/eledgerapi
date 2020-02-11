package in.pune.royforge.eledgerapi.data.model;

import java.util.List;

import in.pune.royforge.eledgerapi.data.entity.WalletEntity;

public class WalletData {
	
	private List<WalletEntity> listOfWallets;

	public List<WalletEntity> getListOfWallets() {
		return listOfWallets;
	}

	public void setListOfWallets(List<WalletEntity> listOfWallets2) {
		this.listOfWallets = listOfWallets2;
	}

}
