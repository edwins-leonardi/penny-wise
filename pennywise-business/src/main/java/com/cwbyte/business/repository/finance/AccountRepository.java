package com.cwbyte.business.repository.finance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.model.finance.Account;

@Stateless
public class AccountRepository extends GenericRepository<Account> {
	@PersistenceContext
	EntityManager em;

	@Override
	public Class<Account> getPersistentClass() {
		return Account.class;
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public String getDefaultOrderByField() {
		return "name";
	}

	@Override
	public void update(Account entity) {
		Account old = em.find(Account.class, entity.getId());
		entity.setCreation(old.getCreation());
		em.merge(entity);
	}
}
