package com.bank.account.controllers.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountHistoryDTO {
	private Double balance;
	private String userName;
	private List<OperationDto> history;
}
