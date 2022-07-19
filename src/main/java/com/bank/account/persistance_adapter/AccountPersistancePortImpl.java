package com.bank.account.persistance_adapter;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.account.core.models.Account;
import com.bank.account.core.ports.persistence.AccountPersistancePort;
import com.bank.account.dto_utils.MapperUtilClass;

@Service
public class AccountPersistancePortImpl implements AccountPersistancePort {
	private final AccountEntityRepository accountRepo;

	public AccountPersistancePortImpl(AccountEntityRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public Optional<Account> getAccountById(int id) {
		Optional<AccountEntity> entity = accountRepo.findById(id);
		if (entity.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(MapperUtilClass.EntityToAccount(entity.get()));
	}

	@Override
	public Account perisitAccount(Account account) {
		AccountEntity entity = MapperUtilClass.AccountToEntity(account);
		accountRepo.save(entity);
		return MapperUtilClass.EntityToAccount(entity);
	}

}
