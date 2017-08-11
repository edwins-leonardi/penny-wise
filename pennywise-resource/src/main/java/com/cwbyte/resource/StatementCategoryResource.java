package com.cwbyte.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cwbyte.business.service.statement.StatementCategoryService;
import com.cwbyte.model.statement.StatementCategory;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/categories")
public class StatementCategoryResource {

	@Inject
	private StatementCategoryService service;

	@GET
	public List<StatementCategory> findAll() {
		return service.findAll();
	}

}
