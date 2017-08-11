package com.cwbyte.business.service.statement;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.business.repository.statement.StatementCategoryRepository;
import com.cwbyte.business.service.common.AbstractCRUDService;
import com.cwbyte.model.statement.StatementCategory;

@Stateless
public class StatementCategoryService extends AbstractCRUDService<StatementCategory> {
	@Inject
	private StatementCategoryRepository repository;

	@Override
	public GenericRepository<StatementCategory> getRepository() {
		return repository;
	}
}
