package com.cwbyte.business.repository.common;

//@Ignore
public interface DBCommand<T> {

	T execute();

}