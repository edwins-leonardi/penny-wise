package com.cwbyte.resource.statement;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cwbyte.business.service.statement.StatementGroupService;
import com.cwbyte.model.statement.StatementGroup;
import com.cwbyte.resource.commom.HttpCode;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/statementgroups")
public class StatementGroupResource {

	@Inject
	private StatementGroupService service;

	@GET
	public List<StatementGroup> findAll() {
		return service.findAll();
	}

	@POST
	public Response save(StatementGroup category) {
		try {
			category = service.add(category);
			return Response.status(HttpCode.CREATED.getCode()).entity(category).build();
		} catch (final Exception e) {
			return Response.status(HttpCode.VALIDATION_ERROR.getCode()).build();
		}
	}

	@PUT
	public Response update(final StatementGroup group) {
		System.out.println("update");
		service.update(group);
		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") final Long id) {
		service.delete(id);
		return Response.ok().build();
	}

	@GET
	@Path("{id}")
	public StatementGroup findById(@PathParam("id") final Long id) {
		return service.findById(id);
	}
}
