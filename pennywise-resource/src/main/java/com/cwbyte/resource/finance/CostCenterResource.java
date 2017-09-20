package com.cwbyte.resource.finance;

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

import com.cwbyte.business.service.finance.CostCenterService;
import com.cwbyte.model.finance.CostCenter;
import com.cwbyte.resource.commom.HttpCode;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/costcenters")
public class CostCenterResource {
	@Inject
	private CostCenterService service;

	@GET
	public List<CostCenter> findAll() {
		return service.findAll();
	}

	@POST
	public Response save(CostCenter costCenter) {
		try {
			costCenter = service.add(costCenter);
			return Response.status(HttpCode.CREATED.getCode()).entity(costCenter).build();
		} catch (final Exception e) {
			return Response.status(HttpCode.VALIDATION_ERROR.getCode()).build();
		}
	}

	@PUT
	public Response update(final CostCenter costCenter) {
		service.update(costCenter);
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
	public CostCenter findById(@PathParam("id") final Long id) {
		return service.findById(id);
	}

}
