package com.cwbyte.business.repository.finance;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cwbyte.business.repository.common.TestBaseRepository;
import com.cwbyte.model.finance.CostCenter;

public class CostCenterRepositoryTest extends TestBaseRepository {
	private CostCenterRepository repository;

	@Before
	public void initTestCase() {
		initializeTestDB();

		repository = new CostCenterRepository();
		repository.em = em;
	}

	@After
	public void setDownTestCase() {
		closeEntityManager();
	}

	@Test
	public void addCostCenterAndFindIt() {
		final String costCenterName = "Julia";
		final Long costCenterAddedId = dbCommandExecutor.executeCommand(() -> {
			return repository.add(mockCostCenter(costCenterName)).getId();
		});
		Assert.assertThat(costCenterAddedId, CoreMatchers.notNullValue());

		final CostCenter category = repository.findById(costCenterAddedId);
		Assert.assertThat(costCenterAddedId, CoreMatchers.notNullValue());
		Assert.assertThat(category.getName(), CoreMatchers.equalTo(costCenterName));
	}

	private CostCenter mockCostCenter(final String name) {
		return CostCenter.builder().name(name).build();
	}

}
