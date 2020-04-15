package com.practice.model;

public class TransferBalanceRequest {
	private Integer fromPhone;
	
	private Integer toPhone;
	
	private Double amount;

	public Integer getFromPhone() {
		return fromPhone;
	}

	public void setFromPhone(Integer fromPhone) {
		this.fromPhone = fromPhone;
	}

	public Integer getToPhone() {
		return toPhone;
	}

	public void setToPhone(Integer toPhone) {
		this.toPhone = toPhone;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
