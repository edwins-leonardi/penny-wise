package com.cwbyte.resource.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cwbyte.business.repository.common.exception.RecordNotFoundException;

@Provider
public class RecordNotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException> {

	@Override
	public Response toResponse(RecordNotFoundException exception) {
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}

}
