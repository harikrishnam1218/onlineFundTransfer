package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.PhonePayAccount;
@Repository
public interface PhonePayRepository extends JpaRepository<PhonePayAccount, Long>{

}
