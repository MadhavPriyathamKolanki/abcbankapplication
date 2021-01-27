package com.bankingapp.abcbankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.abcbankapplication.model.Customer;
import com.bankingapp.abcbankapplication.repository.AccountRepository;
import com.bankingapp.abcbankapplication.repository.CustomerRepository;
import com.bankingapp.abcbankapplication.repository.TransactionRepository;
import com.bankingapp.abcbankapplication.service.CustomerService;




@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping(value = "/getallcustomers")  // TO GET ALL CUSTOMERS
	public List<Customer> getAllCustomers() {
		return customerService.findAllCustomers();
	}
	@GetMapping(value = "/getcustomerbyname/{name}")  // TO GET ALL CUSTOMERS STARTING WITH A NAME
	public Customer getCustomerByName(@PathVariable("name") String lastname) {
		return customerService.findCustomerByUsername(lastname).get();
	}
	
	@GetMapping(value = "/getallcustomerswithname/{lastname}")  // TO GET ALL CUSTOMERS
	public List<Customer> getAllCustomer(@PathVariable("lastname") String lastname) {
		return customerService.CustomerfindCustomerByLastnameMatch(lastname);
	}
	
	@PutMapping("/updatecustomer/{customerid}")  // TO UPDATE DETAILS OF A CUSTOMER
	public Customer updateCustomer(@PathVariable("customerid") int customerid,
			@RequestBody Customer customer) {
		return customerService.updateCustomer(customerid, customer);
	}
	
}
