package com.bank.account.core.ports.buisness;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.core.exceptions.AccountNotFoundException;
import com.bank.account.core.exceptions.OperationDeniedException;
import com.bank.account.core.models.Account;
import com.bank.account.core.models.Operation;
import com.bank.account.core.models.OperationTypeEnum;
import com.bank.account.core.ports.persistence.AccountPersistancePort;

@Service
public class ManageAccountImpl implements ManageAccount {

	private final String ACCOUNT_NOT_FOUND_ERROR_TEMPLATE = "Account with id {0} not found";
	private final AccountPersistancePort peristrancePort;

	@Autowired
	public ManageAccountImpl(AccountPersistancePort peristrancePort) {
		this.peristrancePort = peristrancePort;

	}

	@Override
	public Account depositMoneyToAccount(int accountID, Double ammount) throws OperationDeniedException, AccountNotFoundException {
		Optional<Account> account = peristrancePort.getAccountById(accountID);
		if (!account.isPresent()) {
			throw new AccountNotFoundException(MessageFormat.format(ACCOUNT_NOT_FOUND_ERROR_TEMPLATE, accountID));
		}
		if (ammount != null && ammount > 0) {
			account.get().getOperations().add(Operation.builder().impactOnAccount(ammount)
					.operationType(OperationTypeEnum.DEPOSIT).time(LocalDateTime.now()).build());
			account.get().setBalanace(account.get().getBalanace() + ammount);
			return peristrancePort.perisitAccount(account.get());
		} else {
			throw new OperationDeniedException("Either ammount is null or less or equal to zero, depoit denied.");
		}

	}

	@Override
	public Account withdrawMoneyMoneyToAccount(int accountID, Double ammount)
			throws OperationDeniedException, AccountNotFoundException {
		Optional<Account> account = peristrancePort.getAccountById(accountID);
		if (!account.isPresent()) {
			throw new AccountNotFoundException(MessageFormat.format(ACCOUNT_NOT_FOUND_ERROR_TEMPLATE, accountID));
		}
		if (ammount != null && ammount > 0 && account.get().getBalanace() >= ammount) {
			account.get().getOperations().add(Operation.builder().impactOnAccount(ammount)
					.operationType(OperationTypeEnum.WITHDRAW).time(LocalDateTime.now()).build());
			account.get().setBalanace(account.get().getBalanace() - ammount);
			return peristrancePort.perisitAccount(account.get());
		} else {
			throw new OperationDeniedException(
					"Either ammount is null ,less or equal to zero or balance not enough, withdraw denied.");
		}

	}

	@Override
	public void intAccount(String userName) {
		Account account = Account.builder().userName(userName).operations(new ArrayList<Operation>()).build();
		peristrancePort.perisitAccount(account);
	}

	@Override
	public AccountHistory getHistory(Integer id) throws AccountNotFoundException {
		Optional<Account> account = peristrancePort.getAccountById(id);
		if (account.isPresent()) {
			return AccountHistory.builder().balance(account.get().getBalanace()).history(account.get().getOperations())
					.userName(account.get().getUserName()).build();
		}
		throw new AccountNotFoundException(MessageFormat.format(ACCOUNT_NOT_FOUND_ERROR_TEMPLATE, id));
	}

}
