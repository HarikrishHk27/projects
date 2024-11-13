package com.example.demo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Customer;
import com.example.demo.eo.CustomerServiceEo;
import com.example.demo.eo.CustomerServiceEoImpl;
import com.example.demo.exception.CustomerNotFoundException;

public class CustomerServiceBoImpl implements CustomerServiceBo{

	@Autowired
	CustomerServiceEoImpl customerEo;

	@Override
	public List<Customer> customerDetails() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return customerEo.customerDetails();
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return customerEo.addCustomer(c);
	}
	@Override
	public Customer deleteById(int customerId) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		return CustomerServiceEo.deleteById(customerId);
	}

	@Override
	public int deleteById(long customerId) {
		// TODO Auto-generated method stub
		return  customerEo.deleteById(customerId);
	}


}
