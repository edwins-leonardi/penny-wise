package com.cwbyte.business.common.repository;

//@Ignore
public interface DBCommand<T> {

	T execute();

}