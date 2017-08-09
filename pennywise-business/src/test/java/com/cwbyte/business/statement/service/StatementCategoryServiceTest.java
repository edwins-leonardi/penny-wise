package com.cwbyte.business.statement.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cwbyte.business.statement.repository.StatementCategoryRepository;

public class StatementCategoryServiceTest {

	@Mock
	private StatementCategoryRepository repository;
	@InjectMocks
	private StatementCategoryService service;

	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

}
