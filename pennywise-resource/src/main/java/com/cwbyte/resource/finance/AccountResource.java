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

import com.cwbyte.business.repository.common.exception.RecordNotFoundException;
import com.cwbyte.business.service.finance.AccountService;
import com.cwbyte.model.finance.Account;
import com.cwbyte.resource.common.HttpCode;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/accounts")
public class AccountResource {
	@Inject
	private AccountService service;

	@GET
	public List<Account> findAll() {
		return service.findAll();
	}

	@POST
	public Response save(Account account) {
		try {
			account = service.add(account);
			return Response.status(HttpCode.CREATED.getCode()).entity(account).build();
		} catch (final Exception e) {
			return Response.status(HttpCode.VALIDATION_ERROR.getCode()).build();
		}
	}

	@PUT
	public Response update(final Account account) throws RecordNotFoundException {
		service.update(account);
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
	public Account findById(@PathParam("id") final Long id) {
		return service.findById(id);
	}

}
