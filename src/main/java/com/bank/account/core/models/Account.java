package com.bank.account.core.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
	private Integer id;
	private String userName;
	private double balanace;
	private List<Operation> operations;

}
