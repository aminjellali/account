package com.bank.account.application.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OPerationEntityRepo extends JpaRepository<OperationEntity, Integer> {

}
