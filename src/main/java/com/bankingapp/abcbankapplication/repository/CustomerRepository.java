package com.bankingapp.abcbankapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankingapp.abcbankapplication.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value ="select * from customer where username=?1",nativeQuery = true)
	Optional<Customer> findCustomerByUsername(String username);
	
	@Query(value ="select * from customer where lastname like ':lastname%'",nativeQuery = true)
	Optional<List<Customer>> findCustomerByLastnameMatch(@Param("lastname") String lastname);
}
