package com.bankingapp.abcbankapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bankingapp.abcbankapplication.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query(value ="select * from transaction where accountid=?1 order by transactiontimestamp desc limit 10;",nativeQuery = true)
	public List<Transaction> findTxnsByAccountId(int id);
	
	@Query(value ="select * from transaction where accountid=:accountid and"
			+ " (transactiondate between :fromdate and :todate) order by transactiontimestamp desc;",nativeQuery = true)
	public List<Transaction> findDetailedTransactionsByDate(@Param("accountid")int accountid, @Param("fromdate") String fromdate,@Param("todate") String todate);
	
	@Query(value ="select * from transaction where accountid=:accountid and "
			+ "transactionamount between :minamnt and :maxamnt order by transactiontimestamp desc;",nativeQuery = true)
	public List<Transaction> findDetailedTransactionsByAmount(@Param("accountid")int accountid, @Param("minamnt") int minamnt,@Param("maxamnt") int maxamnt);
	
	@Query(value ="select * from transaction where accountid=:accountid and fromaccountnumber=:fromaccid ;",nativeQuery = true)
	public List<Transaction> getDetailedTransactionsByFromAccount(@Param("accountid")int accountid, @Param("fromaccid") int fromaccid);
	
	@Query(value ="select * from transaction where accountid=:accountid and toaccountnumber=:toaccid ;",nativeQuery = true)
	public List<Transaction> getDetailedTransactionsByToAccount(@Param("accountid")int accountid, @Param("toaccid") int toaccid);
	
}
