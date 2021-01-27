package com.bankingapp.abcbankapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankingapp.abcbankapplication.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query(value ="select * from admin where username=?1",nativeQuery = true)
	Optional<Admin> findAdminByUsername(String username);
}
