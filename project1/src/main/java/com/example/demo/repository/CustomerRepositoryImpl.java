package com.example.demo.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entity.Customer;


public class CustomerRepositoryImpl implements CustomerRepository {
	@Autowired
	JdbcTemplate jdbcTemp;
	
	private RowMapper<Customer> mapper =(ResultSet res, int rowNumber) ->{
		Customer c1 = new Customer();
		c1.setCustomerId(res.getInt(1));
		c1.setCustomerName(res.getString(2));
		return c1;
	};

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		jdbcTemp.update("insert into customer (ID, NAME) values (?,?)", c.getCustomerId(),c.getCustomerName());
		return c;
	}

	@Override
	public int deleteById(int cId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		int r= jdbcTemp.update("delete from customer where ID=?",cId);
		return cId;
	}

	@Override
	public List<Customer> customerDetails() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return jdbcTemp.query("select * from customer",mapper );
	}

}
