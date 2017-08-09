package com.cwbyte.business.statement.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cwbyte.business.statement.repository.StatementCategoryRepository;

@Stateless
public class StatementCategoryService {
	@Inject
	private StatementCategoryRepository repository;

}
