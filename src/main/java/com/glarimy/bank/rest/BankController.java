package com.glarimy.bank.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glarimy.bank.api.Account;
import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.CustomerData;
import com.glarimy.bank.biz.SimpleBank;

@Path("/bank")
public class BankController {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account")
	public Response add(CustomerData data) {
		Bank bank = new SimpleBank();
		int number = bank.openAccount(data);
		return Response.ok().entity(number + "").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/account/{no}")
	public Response read(@PathParam("no") int number) {
		Bank bank = new SimpleBank();
		Account account = bank.get(number);
		return Response.ok().entity(account).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/account")
	public Response update(Account account) {
		Bank bank = new SimpleBank();
		bank.update(account);
		return Response.ok().entity(account).build();
	}
}
