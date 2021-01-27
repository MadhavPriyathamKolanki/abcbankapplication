package com.bankingapp.abcbankapplication.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.abcbankapplication.ExceptionHandling.AdminNotFoundException;
import com.bankingapp.abcbankapplication.ExceptionHandling.CustomerNotFoundException;
import com.bankingapp.abcbankapplication.model.Admin;
import com.bankingapp.abcbankapplication.model.Customer;
import com.bankingapp.abcbankapplication.model.Login;
import com.bankingapp.abcbankapplication.model.LoginInfo;
import com.bankingapp.abcbankapplication.repository.AdminRepository;
import com.bankingapp.abcbankapplication.repository.CustomerRepository;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/adminlogin")
	public Admin adminLogin(@RequestBody Login login) {
		
		Optional<Admin> admin = adminRepository.findAdminByUsername(login.getUsername());
		if (!admin.isPresent()) {
			throw new AdminNotFoundException("The admin name is invalid");
		}
		
		String adminpassword=admin.get().getPassword();
		String loginpassword=login.getPassword();
		if (adminpassword.equals(loginpassword)) {
			return admin.get(); 
		} else {
			throw new AdminNotFoundException("The admin password is invalid");
		}
	}
	@PostMapping("/customerlogin")
	public Customer customerLogin(@RequestBody Login login) {
		System.out.println(login);
		Login customerlogin=login;
		System.out.println(customerlogin.getUsername());
		System.out.println(customerlogin.getPassword());
		Optional<Customer> customer = customerRepository.findCustomerByUsername(customerlogin.getUsername());
		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("The user name entered is invalid");
		}
		String customerpassword=customer.get().getPassword();
		String loginpassword=customerlogin.getPassword();
		if (customerpassword.equals(loginpassword)) {
			return customer.get();
		}
		else {
			throw new CustomerNotFoundException("The user password is invalid");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
