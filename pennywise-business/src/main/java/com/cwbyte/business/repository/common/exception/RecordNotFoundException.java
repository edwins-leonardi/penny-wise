package com.cwbyte.business.repository.common.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1245831705372573567L;
	private static final String MESSAGE = "The %s with id = %s does not exist";

	public RecordNotFoundException(Class entityClass, Long id) {
		super(String.format(MESSAGE, entityClass.getSimpleName(), id));
	}
}
