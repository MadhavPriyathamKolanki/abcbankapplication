package com.bankingapp.abcbankapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bankingapp.abcbankapplication.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query(value ="select * from account where customerid=?1",nativeQuery = true)
	public List<Account> findAccountsByCustomerId(int customerid);

	@Query(value ="select * from account where accountid=?1",nativeQuery = true)
	public Optional<Account> findAccountByAccountId(int accountid);
}
