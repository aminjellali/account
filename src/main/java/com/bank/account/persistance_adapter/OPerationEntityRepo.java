package com.bank.account.persistance_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OPerationEntityRepo extends JpaRepository<OperationEntity, Integer> {

}
