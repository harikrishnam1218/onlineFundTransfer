package com.practice.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="phonepaytransaction")
public class PhonePayTransaction {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long ptid;

    private Double transactionAmount;

    private Timestamp transactiondate;
    
    private Long mobile;
    
    private String message;

	public Long getPtid() {
		return ptid;
	}

	public void setPtid(Long ptid) {
		this.ptid = ptid;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Timestamp transactiondate) {
		this.transactiondate = transactiondate;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
}
