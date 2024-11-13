package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.vo.CustomerInputVo;
import com.example.demo.vo.CustomerOuputVo;
//@Service
public interface CustomerService {

	//@Autowired
	//private CustomerServiceBo customerServiceBo;
	public List<Customer> customerDetails() throws CustomerNotFoundException;

	public CustomerOuputVo addCustomer(CustomerInputVo customer);

	public int deleteById(long customerId);

}
