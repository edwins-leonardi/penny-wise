package com.cwbyte.business.statement.service;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cwbyte.business.repository.statement.StatementCategoryRepository;
import com.cwbyte.business.service.statement.StatementCategoryService;
import com.cwbyte.model.statement.StatementCategory;

public class StatementCategoryServiceTest {

	private static final Long ID = 1l;
	@Mock
	private StatementCategoryRepository repository;
	@InjectMocks
	private StatementCategoryService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addStatementCategory() {
		final StatementCategory category = mockStatementCategory();
		service.add(category);
		Mockito.verify(repository).add(category);
	}

	@Test
	public void updateStatementCategory() {
		final StatementCategory category = mockStatementCategory();
		service.update(category);
		Mockito.verify(repository).update(category);
	}

	@Test
	public void deleteStatementCategory() {
		service.delete(ID);
		Mockito.verify(repository).delete(ID);
	}

	@Test
	public void findAll() {
		final List<StatementCategory> mockedList = mockStatementCategoryList();
		Mockito.when(repository.findAll()).thenReturn(mockedList);
		final List<StatementCategory> statementCategories = service.findAll();
		MatcherAssert.assertThat(statementCategories, Matchers.hasSize(mockedList.size()));
	}

	@Test
	public void findById() {
		Mockito.when(repository.findById(ID)).thenReturn(mockStatementCategory());
		final StatementCategory statementCategory = service.findById(ID);
		MatcherAssert.assertThat(statementCategory.getId(), Matchers.equalTo(ID));
	}

	private StatementCategory mockStatementCategory() {
		return StatementCategory.builder().id(ID).build();
	}

	private List<StatementCategory> mockStatementCategoryList() {
		final StatementCategory obj1 = StatementCategory.builder().id(ID).build();
		final StatementCategory obj2 = StatementCategory.builder().id(2l).build();
		final StatementCategory obj3 = StatementCategory.builder().id(3l).build();
		return Arrays.asList(obj1, obj2, obj3);
	}

}
