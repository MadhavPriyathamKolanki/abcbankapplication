package com.bankingapp.abcbankapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankingapp.abcbankapplication.ExceptionHandling.CustomerNotFoundException;
import com.bankingapp.abcbankapplication.model.Customer;
import com.bankingapp.abcbankapplication.repository.AccountRepository;
import com.bankingapp.abcbankapplication.repository.CustomerRepository;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerByUsername(String username) {
		return customerRepository.findCustomerByUsername(username);
	}

	@Override
	public Customer findCustomerByCustomerid(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(int customerid, Customer customer) {
		Optional<Customer> holder = customerRepository.findById(customerid);
		if(!holder.isPresent()) {
			throw new CustomerNotFoundException("The customer with this id is not found");
		}
		Customer accholder = holder.get();
		accholder.setFirstname(customer.getFirstname());
		accholder.setLastname(customer.getLastname());
		accholder.setAddress(customer.getAddress());
		accholder.setEmail(customer.getEmail());
		accholder.setUsername(customer.getUsername());
		accholder.setPassword(customer.getPassword());
		customerRepository.save(accholder);
		return accholder;
	}

	@Override
	public List<Customer> CustomerfindCustomerByLastnameMatch(String lastname) {
		Optional<List<Customer>> customers= customerRepository.findCustomerByLastnameMatch(lastname);
		if(! customers.isPresent()) {
			throw new CustomerNotFoundException("The customer with this id is not found");
		}
		return customers.get();
	}

	
}
