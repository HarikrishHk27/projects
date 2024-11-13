package com.example.demo.eo;

import java.util.List;

import com.example.demo.entity.Customer;


public interface CustomerServiceEo {

	List<Customer> customerDetails();
	
	public Customer addCustomer(Customer c);
	public Customer deleteById(long customerId);
}
