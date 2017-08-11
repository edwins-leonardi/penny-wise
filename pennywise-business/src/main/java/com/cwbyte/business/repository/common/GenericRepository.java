package com.cwbyte.business.repository.common;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericRepository<T> {

	public abstract Class<T> getPersistentClass();

	public abstract EntityManager getEntityManager();

	public abstract String getDefaultOrderByField();

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getEntityManager().createQuery(
				"Select e From " + getPersistentClass().getCanonicalName() + " e Order by e."
						+ getDefaultOrderByField())
				.getResultList();
	}

	public T add(final T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public T findById(final Long id) {
		if (id == null) {
			return null;
		}
		return getEntityManager().find(getPersistentClass(), id);
	}

	public void update(final T entity) {
		getEntityManager().merge(entity);
	}

	public void delete(final Long id) {
		getEntityManager().remove(id);
	}
}
