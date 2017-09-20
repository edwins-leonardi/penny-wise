package com.cwbyte.business.repository.statement;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cwbyte.business.repository.common.TestBaseRepository;
import com.cwbyte.model.statement.StatementGroup;

public class StatementGroupRepositoryTest extends TestBaseRepository {

	private StatementGroupRepository repository;

	@Before
	public void initTestCase() {
		initializeTestDB();

		repository = new StatementGroupRepository();
		repository.em = em;
	}

	@After
	public void setDownTestCase() {
		closeEntityManager();
	}

	@Test
	public void addStatementGroupAndFindIt() {
		final String categoryName = "Master";
		final Long categoryAddedId = dbCommandExecutor.executeCommand(() -> {
			return repository.add(mockCategory(categoryName)).getId();
		});
		Assert.assertThat(categoryAddedId, CoreMatchers.notNullValue());

		final StatementGroup category = repository.findById(categoryAddedId);
		Assert.assertThat(categoryAddedId, CoreMatchers.notNullValue());
		Assert.assertThat(category.getName(), CoreMatchers.equalTo(categoryName));
	}

	private StatementGroup mockCategory(final String name) {
		return StatementGroup.builder().name(name).build();
	}

}
