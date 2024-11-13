package com.example.demo.bo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;

public interface CustomerServiceBo {
	
	public List<Customer> customerDetails() throws CustomerNotFoundException;
	
	public Customer addCustomer(Customer c);
	public int deleteById(long customerId);
	
}
