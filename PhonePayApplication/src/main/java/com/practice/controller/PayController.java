package com.practice.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.client.BankServiceFeignClient;
import com.practice.exception.CustomerNotFoundException;
import com.practice.exception.DBException;
import com.practice.exception.TransferException;
import com.practice.model.PhonePayAccount;
import com.practice.model.PhonePayTransaction;
import com.practice.model.TransferBalanceRequest;
import com.practice.service.PhonePayService;

@RestController
@RequestMapping("/pay/api")
public class PayController {
	
	@Autowired
	PhonePayService phonePayService;

	//@Autowired
	//BankServiceFeignClient bankServiceFeignClient;
	@PostMapping("registerPhonepay")
	public ResponseEntity<String> reisterphonePay(@RequestParam Integer mobile) throws CustomerNotFoundException, DBException {
	PhonePayAccount paccount=	phonePayService.registerPhonePay(mobile);
	if(Objects.isNull(paccount)) {
		throw new DBException("Account is not registered with current mobile");
	}
		return new ResponseEntity("Registered Successfully", HttpStatus.OK);
	}
	@PostMapping("sendamount")
	public ResponseEntity<PhonePayTransaction> transferMoneyToPhonePay(@RequestBody TransferBalanceRequest request) throws TransferException, DBException {
		
		PhonePayTransaction transaction=phonePayService.transferMoney(request);
		return new ResponseEntity(transaction, HttpStatus.OK);
	}
}
