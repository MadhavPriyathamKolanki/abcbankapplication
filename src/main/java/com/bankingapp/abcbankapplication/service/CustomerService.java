package com.bankingapp.abcbankapplication.service;

import java.util.List;
import java.util.Optional;

import com.bankingapp.abcbankapplication.model.Customer;

public interface CustomerService {
	public List<Customer> findAllCustomers();
	public Optional<Customer> findCustomerByUsername(String username);
	
	public Customer findCustomerByCustomerid(int customerid);
	public Customer updateCustomer(int customerid,Customer customer);
	public List<Customer> CustomerfindCustomerByLastnameMatch(String lastname);
}
