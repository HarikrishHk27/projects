package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Customer;

//@Repository
public interface CustomerRepository {


	public Customer addCustomer(Customer c);
	public int deleteById(int cId) throws CustomerNotFoundException;
	public List<Customer> customerDetails() throws CustomerNotFoundException;
}
