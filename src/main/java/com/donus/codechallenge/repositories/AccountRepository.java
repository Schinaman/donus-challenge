package com.donus.codechallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.codechallenge.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
