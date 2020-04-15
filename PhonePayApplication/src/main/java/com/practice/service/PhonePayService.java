package com.practice.service;

import com.practice.exception.CustomerNotFoundException;
import com.practice.exception.DBException;
import com.practice.exception.TransferException;
import com.practice.model.PhonePayAccount;
import com.practice.model.PhonePayTransaction;
import com.practice.model.TransferBalanceRequest;

public interface PhonePayService {
	PhonePayAccount registerPhonePay(Integer mobile) throws CustomerNotFoundException, DBException;
	
	PhonePayTransaction transferMoney(TransferBalanceRequest request) throws TransferException, DBException;

}
