package com.cwbyte.business.statement.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cwbyte.business.common.repository.GenericRepository;
import com.cwbyte.model.statement.StatementCategory;

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
