package com.cwbyte.business.service.common;

import java.util.List;

import com.cwbyte.business.repository.common.GenericRepository;
import com.cwbyte.business.repository.common.exception.RecordNotFoundException;

public abstract class AbstractCRUDService<T> {

	public abstract GenericRepository<T> getRepository();

	public T add(final T entity) {
		return getRepository().add(entity);
	}

	public void update(final T entity) throws RecordNotFoundException {
		getRepository().update(entity);
	}

	public void delete(final Long id) {
		getRepository().delete(id);
	}

	public List<T> findAll() {
		return getRepository().findAll();
	}

	public T findById(final Long id) {
		return getRepository().findById(id);
	}
}
