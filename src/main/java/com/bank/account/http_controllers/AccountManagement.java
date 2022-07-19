package com.bank.account.http_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.core.exceptions.AccountNotFoundException;
import com.bank.account.core.exceptions.OperationDeniedException;
import com.bank.account.core.ports.buisness.ManageAccount;
import com.bank.account.dto_utils.MapperUtilClass;

@RestController
@RequestMapping("/api/account")
public class AccountManagement {

	private final ManageAccount accountManagementPort;

	public AccountManagement(ManageAccount accountManagementPort) {
		this.accountManagementPort = accountManagementPort;
	}

	@PostMapping("/init")
	void initAccount(@RequestParam String userName) {
		this.accountManagementPort.intAccount(userName);
	}

	@PostMapping("/deposit-money-to-account")
	ResponseEntity<?> deposit(@RequestParam int accountId, @RequestParam Double amount) {
		try {
			this.accountManagementPort.depositMoneyToAccount(accountId, amount);
			return ResponseEntity.ok("Account deposit success.");
		} catch (AccountNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (OperationDeniedException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@PostMapping("/withdraw-money-from-account")
	ResponseEntity<?> withdraw(@RequestParam int accountId, @RequestParam Double amount) {
		try {
			this.accountManagementPort.withdrawMoneyMoneyToAccount(accountId, amount);
			return ResponseEntity.ok("Account withdraw success.");
		} catch (AccountNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (OperationDeniedException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@GetMapping("/get-account-history")
	ResponseEntity<?> withdraw(@RequestParam int accountId) {
		try {
			return ResponseEntity.ok(MapperUtilClass.histoToHistoDto(this.accountManagementPort.getHistory(accountId)));
		} catch (AccountNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
