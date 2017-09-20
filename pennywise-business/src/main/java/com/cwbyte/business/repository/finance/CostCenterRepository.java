package com.cwbyte.business.repository.finance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.model.finance.CostCenter;

@Stateless
public class CostCenterRepository extends GenericRepository<CostCenter> {
	@PersistenceContext
	EntityManager em;

	@Override
	public Class<CostCenter> getPersistentClass() {
		return CostCenter.class;
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
