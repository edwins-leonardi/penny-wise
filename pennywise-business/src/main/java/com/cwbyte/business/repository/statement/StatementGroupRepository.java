package com.cwbyte.business.repository.statement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.model.statement.StatementGroup;

@Stateless
public class StatementGroupRepository extends GenericRepository<StatementGroup> {

	@PersistenceContext
	EntityManager em;

	@Override
	public Class<StatementGroup> getPersistentClass() {
		return StatementGroup.class;
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
