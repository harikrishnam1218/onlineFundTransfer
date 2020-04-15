package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.PhonePayTransaction;

public interface TransactionRepository extends JpaRepository<PhonePayTransaction, Long>{

}
