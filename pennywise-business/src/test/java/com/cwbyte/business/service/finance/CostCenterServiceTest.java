package com.cwbyte.business.service.finance;

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

import com.cwbyte.business.repository.finance.CostCenterRepository;
import com.cwbyte.business.service.finance.CostCenterService;
import com.cwbyte.model.finance.CostCenter;

public class CostCenterServiceTest {
	private static final Long ID = 1l;
	@Mock
	private CostCenterRepository repository;
	@InjectMocks
	private CostCenterService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addCostCenter() {
		final CostCenter category = mockCostCenter();
		service.add(category);
		Mockito.verify(repository).add(category);
	}

	@Test
	public void updateCostCenter() {
		final CostCenter category = mockCostCenter();
		service.update(category);
		Mockito.verify(repository).update(category);
	}

	@Test
	public void deleteCostCenter() {
		service.delete(ID);
		Mockito.verify(repository).delete(ID);
	}

	@Test
	public void findAll() {
		final List<CostCenter> mockedList = mockCostCenterList();
		Mockito.when(repository.findAll()).thenReturn(mockedList);
		final List<CostCenter> statementCategories = service.findAll();
		MatcherAssert.assertThat(statementCategories, Matchers.hasSize(mockedList.size()));
	}

	@Test
	public void findById() {
		Mockito.when(repository.findById(ID)).thenReturn(mockCostCenter());
		final CostCenter CostCenter = service.findById(ID);
		MatcherAssert.assertThat(CostCenter.getId(), Matchers.equalTo(ID));
	}

	private CostCenter mockCostCenter() {
		return CostCenter.builder().id(ID).build();
	}

	private List<CostCenter> mockCostCenterList() {
		final CostCenter obj1 = CostCenter.builder().id(ID).build();
		final CostCenter obj2 = CostCenter.builder().id(2l).build();
		final CostCenter obj3 = CostCenter.builder().id(3l).build();
		return Arrays.asList(obj1, obj2, obj3);
	}

}
