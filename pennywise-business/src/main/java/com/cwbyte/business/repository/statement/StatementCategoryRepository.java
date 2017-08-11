package com.cwbyte.business.repository.statement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.model.statement.StatementCategory;

@Stateless
public class StatementCategoryRepository extends GenericRepository<StatementCategory> {

	@PersistenceContext
	EntityManager em;

	@Override
	public Class<StatementCategory> getPersistentClass() {
		return StatementCategory.class;
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public String getDefaultOrderByField() {
		return "name";
	}

}
