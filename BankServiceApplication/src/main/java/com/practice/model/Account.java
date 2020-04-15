package com.practice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class Account {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	
	private Long accontno;
	
	private Double balance;
	
	private String ifsccode;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	private Customer customer;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Long getAccontno() {
		return accontno;
	}

	public void setAccontno(Long accontno) {
		this.accontno = accontno;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
