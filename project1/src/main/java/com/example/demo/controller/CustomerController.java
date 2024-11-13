package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.service.CustomerService;
import com.example.demo.vo.CustomerInputVo;
import com.example.demo.vo.CustomerOuputVo;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/customers")
	public ResponseEntity<List<Customer>> customerDetails() throws CustomerNotFoundException{
		
		List<Customer> newCustomer=customerService.customerDetails();
		return new ResponseEntity<>(newCustomer,HttpStatus.OK);
			
	}
	
	@PostMapping("/customer")
	public ResponseEntity<CustomerOuputVo> addCustomer( @RequestBody CustomerInputVo c)
	{
		try {
			CustomerOuputVo newCustomer=customerService.addCustomer(c);
			return new ResponseEntity<CustomerOuputVo>(newCustomer,HttpStatus.CREATED);
			}
			catch(Exception e)  {
				return new ResponseEntity<CustomerOuputVo>(new CustomerOuputVo(),HttpStatus.INTERNAL_SERVER_ERROR);
				}		
	}
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Integer> deleteById(@PathVariable int cId)throws CustomerNotFoundException {
		int a=customerService.deleteById(cId);
		return new ResponseEntity<>(a,HttpStatus.OK);
	
	}
}
