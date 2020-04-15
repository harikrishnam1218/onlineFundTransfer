package com.practice.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.client.BankServiceFeignClient;
import com.practice.exception.CustomerNotFoundException;
import com.practice.exception.DBException;
import com.practice.exception.TransferException;
import com.practice.model.Account;
import com.practice.model.PhonePayAccount;
import com.practice.model.PhonePayTransaction;
import com.practice.model.Transaction;
import com.practice.model.TransferBalanceRequest;
import com.practice.repository.PhonePayRepository;
import com.practice.repository.TransactionRepository;

@Service
public class PhonePayServiceImpl implements PhonePayService{

	@Autowired
	BankServiceFeignClient bankServiceFeignClient;
	
	@Autowired
	PhonePayRepository phonePayRepository ;
	
	@Autowired  
	TransactionRepository transactionRepo;
	
	@Override
	public PhonePayAccount registerPhonePay(Integer mobile) throws CustomerNotFoundException, DBException {
		Account account=bankServiceFeignClient.getAccountDetail(mobile);
		if(Objects.isNull(account) && Objects.isNull(account.getAid())) {
			throw new DBException("NO Accont is Registered to this Number");
		}
		PhonePayAccount ppa=new PhonePayAccount();
		ppa.setAccontno(account.getAccontno());
		ppa.setBankname(account.getName());
		ppa.setIfsccode(account.getIfsccode());
		ppa.setMobile(mobile);
		ppa.setType(account.getType());
		PhonePayAccount entity=	phonePayRepository.save(ppa);
		return entity;
	}

	@Override
	public PhonePayTransaction transferMoney(TransferBalanceRequest request) throws TransferException, DBException {
		List<Transaction> transactionList= bankServiceFeignClient.transferBalance(request);
		if(Objects.isNull(transactionList) && transactionList.isEmpty()) {
			throw new TransferException("Transaction Has been failed.Retry");
		}
		PhonePayTransaction ppt=dataSetPhonePayTransaction(request);
		PhonePayTransaction transactionentity=transactionRepo.save(ppt);
		if(Objects.isNull(transactionentity) && Objects.isNull(transactionentity.getPtid())) {
			throw new DBException("Transaction log has been failed ");
		}
		
		return transactionentity;
	}

	private PhonePayTransaction dataSetPhonePayTransaction(TransferBalanceRequest request) {
		PhonePayTransaction ppt=new PhonePayTransaction();
		ppt.setMobile(Long.valueOf(request.getToPhone()));
		ppt.setTransactionAmount(request.getAmount());
		ppt.setMessage(request.getAmount() +" Amount has been transfered to the Mobile Number "+request.getToPhone());
		ppt.setTransactiondate(new Timestamp(System.currentTimeMillis()));
		return ppt;
	}

}
