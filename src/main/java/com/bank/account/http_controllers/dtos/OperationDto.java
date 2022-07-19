package com.bank.account.http_controllers.dtos;

import java.time.LocalDateTime;

import com.bank.account.core.models.OperationTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDto {
	private Double impactOnAccount;
	private OperationTypeEnum operationType;
	private LocalDateTime time;
}
