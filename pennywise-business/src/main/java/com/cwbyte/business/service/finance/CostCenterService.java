package com.cwbyte.business.service.finance;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.business.repository.finance.CostCenterRepository;
import com.cwbyte.business.service.common.AbstractCRUDService;
import com.cwbyte.model.finance.CostCenter;

@Stateless
public class CostCenterService extends AbstractCRUDService<CostCenter> {
	@Inject
	private CostCenterRepository repository;

	@Override
	public GenericRepository<CostCenter> getRepository() {
		return repository;
	}
}
