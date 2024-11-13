package com.example.demo.mapper;

import javax.annotation.Generated;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Student;
import com.example.demo.vo.CustomerInputVo;
import com.example.demo.vo.CustomerOuputVo;
import com.example.demo.vo.StudentOutputVo;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2022-04-02T15:38:27+0530",
	    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Eclipse Adoptium)"
	)
public class CustomerMapStuctImpl implements CustomerMapStruct{

	@Override
	public Customer CustomerInputVoToCustomer(CustomerInputVo customerInputVo) {
		if ( customerInputVo == null ) {
			return null;
		}
		Customer customer = new Customer();

			customer.setCustomerId( (int) customerInputVo.getCustomerId() );
			customer.setCustomerName( customerInputVo.getCustomerName() );
	        
	        return customer;
	}

	public CustomerOuputVo CustomerToCustomerOutputVo(Customer customer) {
		if ( customer == null ) {
		return null;
	}
		CustomerOuputVo customerOutputVo = new CustomerOuputVo();

	customerOutputVo.setCustomerId( customer.getCustomerId() );
	customerOutputVo.setCustomerName( customer.getCustomerName() );
    
	return customerOutputVo;
	}

}
