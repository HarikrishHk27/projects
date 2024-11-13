package com.example.demo.vo;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerInputVo {

	@PrimaryKeyJoinColumn
	private long customerId;
	@NotNull(message="name should not be null or 0")
	@Pattern(regexp="(^[a-z,A-Z]+)",message="Name should be in alphabets")
	private String customerName;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerInputVo(long customerId,
			@NotNull(message = "name should not be null or 0") @Pattern(regexp = "(^[a-z,A-Z]+)", message = "Name should be in alphabets") String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public CustomerInputVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerInputVo [customerId=" + customerId + ", customerName=" + customerName + "]";
	}
	
}

