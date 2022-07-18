package com.bank.account.core.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {
	private Integer id;
	private Double impactOnAccount;
	private OperationTypeEnum operationType;
	private LocalDateTime time;
}
