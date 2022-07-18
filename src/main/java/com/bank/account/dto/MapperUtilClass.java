package com.bank.account.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.bank.account.application.persistence.AccountEntity;
import com.bank.account.application.persistence.OperationEntity;
import com.bank.account.controllers.dtos.AccountHistoryDTO;
import com.bank.account.controllers.dtos.OperationDto;
import com.bank.account.core.models.Account;
import com.bank.account.core.models.Operation;
import com.bank.account.core.ports.buisness.AccountHistory;

public class MapperUtilClass {
	public static AccountEntity AccountToEntity(Account account) {
		List<OperationEntity> operations = account.getOperations().stream().map(operation -> OperationEntity.builder().id(operation.getId()).impactOnAccount(operation.getImpactOnAccount()).operationType(operation.getOperationType()).time(operation.getTime()).build()).collect(Collectors.toList());
		AccountEntity entity = AccountEntity.builder().id(account.getId()).balanace(account.getBalanace()).userName(account.getUserName()).operations(operations).build();
		return entity;
	}

	public static Account EntityToAccount(AccountEntity accountEntity) {
		List<Operation> operations = accountEntity.getOperations().stream().map(operation -> Operation.builder().id(operation.getId()).impactOnAccount(operation.getImpactOnAccount()).operationType(operation.getOperationType()).time(operation.getTime()).build()).collect(Collectors.toList());
		Account account = Account.builder().id(accountEntity.getId()).balanace(accountEntity.getBalanace()).userName(accountEntity.getUserName()).operations(operations).build();
		return account;
		}
	
	public static AccountHistoryDTO histoToHistoDto(AccountHistory accountHist) {
		List<OperationDto> operations = accountHist.getHistory().stream().map(operation -> OperationDto.builder().impactOnAccount(operation.getImpactOnAccount()).operationType(operation.getOperationType()).time(operation.getTime()).build()).collect(Collectors.toList());
		AccountHistoryDTO account = AccountHistoryDTO.builder().balance(accountHist.getBalance()).userName(accountHist.getUserName()).history(operations).build();
		return account;
		}
	
}
