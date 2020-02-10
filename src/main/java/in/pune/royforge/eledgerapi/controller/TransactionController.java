package in.pune.royforge.eledgerapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerapi.data.entity.TransactionStringEntity;
import in.pune.royforge.eledgerapi.data.repo.TransactionLogRepo;

@RestController
@RequestMapping("/tansactionlog")

public class TransactionController {
	
	@Autowired
	TransactionLogRepo transactionLogRepo;
	


}
