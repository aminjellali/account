package com.bank.account.core.ports.buisness;

import java.util.List;

import com.bank.account.core.models.Operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountHistory {
	private Integer accountId;
	private Double balance;
	private String userName;
	private List<Operation> history;
}
