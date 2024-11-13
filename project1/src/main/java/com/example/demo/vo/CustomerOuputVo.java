package com.example.demo.vo;

public class CustomerOuputVo {

	private long customerId;
	private String customerName;
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerOuputVo(long customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public CustomerOuputVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerOuputVo [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

}
