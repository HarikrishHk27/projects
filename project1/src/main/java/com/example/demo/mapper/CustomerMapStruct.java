package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.entity.Customer;
import com.example.demo.vo.CustomerInputVo;
import com.example.demo.vo.CustomerOuputVo;

@Mapper(componentModel = "spring")
public interface CustomerMapStruct {
	public Customer CustomerInputVoToCustomer(CustomerInputVo customerInputVo);
	public static CustomerOuputVo CustomerToCustomerOutputVo(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	}
