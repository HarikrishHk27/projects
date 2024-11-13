package com.example.demo.eo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.CustomerRepository;

public class CustomerServiceEoImpl implements CustomerServiceEo {


	@Autowired
	private CustomerRepository cusRepo;

	@Override
	public List<Customer> customerDetails() {
		// TODO Auto-generated method stub
		return cusRepo.customerDetails();
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return cusRepo.addCustomer(c);
	}

	public Customer deleteById(int cId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return cusRepo.deleteById(cId);
	}
}
