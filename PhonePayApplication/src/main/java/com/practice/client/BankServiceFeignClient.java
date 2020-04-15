package com.practice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.exception.CustomerNotFoundException;
import com.practice.exception.DBException;
import com.practice.exception.TransferException;
import com.practice.model.Account;
import com.practice.model.CustomerData;
import com.practice.model.Transaction;
import com.practice.model.TransferBalanceRequest;

@FeignClient(name="http://BANK-SERVICE/bank/api")
public interface BankServiceFeignClient {

	@PostMapping("/register")
	public Long registerUser(@RequestBody CustomerData customerData) throws DBException;
	
	@PostMapping("/transfer")
	public List<Transaction> transferBalance(@RequestBody TransferBalanceRequest balanceRequest)
			throws TransferException ;
	@GetMapping("/fetchAccount")
	public Account getAccountDetail(Integer mobile) throws CustomerNotFoundException;

	
}
