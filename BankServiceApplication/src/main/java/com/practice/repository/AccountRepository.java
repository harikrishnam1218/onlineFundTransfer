package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query("from Account acc where acc.customer.mobile=:mobile")
	Account getAccountDetailsByMobile(Integer mobile);

}
