package com.bank.account.application.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Integer>{

}
