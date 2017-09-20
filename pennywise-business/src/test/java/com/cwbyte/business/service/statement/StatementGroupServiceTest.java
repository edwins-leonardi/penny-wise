package com.cwbyte.business.service.statement;

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

import com.cwbyte.business.repository.statement.StatementGroupRepository;
import com.cwbyte.model.statement.StatementGroup;

public class StatementGroupServiceTest {

	private static final Long ID = 1l;
	@Mock
	private StatementGroupRepository repository;
	@InjectMocks
	private StatementGroupService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addStatementGroup() {
		final StatementGroup category = mockStatementGroup();
		service.add(category);
		Mockito.verify(repository).add(category);
	}

	@Test
	public void updateStatementGroup() {
		final StatementGroup category = mockStatementGroup();
		service.update(category);
		Mockito.verify(repository).update(category);
	}

	@Test
	public void deleteStatementGroup() {
		service.delete(ID);
		Mockito.verify(repository).delete(ID);
	}

	@Test
	public void findAll() {
		final List<StatementGroup> mockedList = mockStatementGroupList();
		Mockito.when(repository.findAll()).thenReturn(mockedList);
		final List<StatementGroup> statementCategories = service.findAll();
		MatcherAssert.assertThat(statementCategories, Matchers.hasSize(mockedList.size()));
	}

	@Test
	public void findById() {
		Mockito.when(repository.findById(ID)).thenReturn(mockStatementGroup());
		final StatementGroup StatementGroup = service.findById(ID);
		MatcherAssert.assertThat(StatementGroup.getId(), Matchers.equalTo(ID));
	}

	private StatementGroup mockStatementGroup() {
		return StatementGroup.builder().id(ID).build();
	}

	private List<StatementGroup> mockStatementGroupList() {
		final StatementGroup obj1 = StatementGroup.builder().id(ID).build();
		final StatementGroup obj2 = StatementGroup.builder().id(2l).build();
		final StatementGroup obj3 = StatementGroup.builder().id(3l).build();
		return Arrays.asList(obj1, obj2, obj3);
	}

}
