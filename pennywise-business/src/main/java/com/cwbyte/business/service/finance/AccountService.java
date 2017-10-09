package com.cwbyte.business.service.finance;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.business.repository.common.exception.RecordNotFoundException;
import com.cwbyte.business.repository.finance.AccountRepository;
import com.cwbyte.business.service.common.AbstractCRUDService;
import com.cwbyte.model.finance.Account;

@Stateless
public class AccountService extends AbstractCRUDService<Account> {
	@Inject
	private AccountRepository repository;

	@Override
	public GenericRepository<Account> getRepository() {
		return repository;
	}

	@Override
	public void update(Account entity) throws RecordNotFoundException {
		if (!repository.existsById(entity.getId()))
			throw new RecordNotFoundException(entity.getClass(), entity.getId());

		Account existing = repository.findById(entity.getId());
		entity.setCreation(existing.getCreation());
		repository.update(entity);
	}
}
