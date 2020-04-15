package com.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phonepayaccount")
public class PhonePayAccount {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	
	private Long accontno;
	
	private String bankname;
	
	private Integer mobile;
	
	private String type;
	
	private String ifsccode;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getAccontno() {
		return accontno;
	}

	public void setAccontno(Long accontno) {
		this.accontno = accontno;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	
	

}
