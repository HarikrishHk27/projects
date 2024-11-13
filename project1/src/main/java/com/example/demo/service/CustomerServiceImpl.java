package com.example.demo.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.bo.CustomerServiceBo;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapStruct;
import com.example.demo.vo.CustomerInputVo;
import com.example.demo.vo.CustomerOuputVo;

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerServiceBo customerServiceBo;

	CustomerMapStruct studentMapStruct=Mappers.getMapper(CustomerMapStruct.class);

	@Override
	public List<Customer> customerDetails() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return customerServiceBo.customerDetails();
	}

	@Override
	public CustomerOuputVo addCustomer(CustomerInputVo customer) {
		// TODO Auto-generated method stub
		Customer c = studentMapStruct.CustomerInputVoToCustomer(customer);
		Customer c1=customerServiceBo.addCustomer(c);
		CustomerOuputVo c2=CustomerMapStruct.CustomerToCustomerOutputVo(c1);
		return c2;
	}

	@Override
	public int deleteById(long customerId) {
		// TODO Auto-generated method stub
		return customerServiceBo.deleteById(customerId);
	}
}
