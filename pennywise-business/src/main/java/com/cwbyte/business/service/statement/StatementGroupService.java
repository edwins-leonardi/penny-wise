package com.cwbyte.business.service.statement;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.business.repository.statement.StatementGroupRepository;
import com.cwbyte.business.service.common.AbstractCRUDService;
import com.cwbyte.model.statement.StatementGroup;

@Stateless
public class StatementGroupService extends AbstractCRUDService<StatementGroup> {
	@Inject
	private StatementGroupRepository repository;

	@Override
	public GenericRepository<StatementGroup> getRepository() {
		return repository;
	}
}
