package com.cwbyte.business.statement.repository;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cwbyte.business.common.repository.TestBaseRepository;
import com.cwbyte.model.statement.StatementCategory;

public class StatementCategoryRepositoryTest extends TestBaseRepository {

	private StatementCategoryRepository repository;

	@Before
	public void initTestCase() {
		initializeTestDB();

		repository = new StatementCategoryRepository();
		repository.em = em;
	}

	@After
	public void setDownTestCase() {
		closeEntityManager();
	}

	@Test
	public void addStatementCategoryAndFindIt() {
		final String categoryName = "Alimentacao";
		final Long categoryAddedId = dbCommandExecutor.executeCommand(() -> {
			return repository.add(mockCategory(categoryName)).getId();
		});
		Assert.assertThat(categoryAddedId, CoreMatchers.notNullValue());

		final StatementCategory category = repository.findById(categoryAddedId);
		Assert.assertThat(categoryAddedId, CoreMatchers.notNullValue());
		Assert.assertThat(category.getName(), CoreMatchers.equalTo(categoryName));
	}

	private StatementCategory mockCategory(final String name) {
		return StatementCategory.builder().name(name).build();
	}

}
