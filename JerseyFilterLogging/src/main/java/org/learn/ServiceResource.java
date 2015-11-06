
package org.learn;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/service")
public class ServiceResource {

	private static final String text = "Message from Server :%s ";

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getText() {
		String response = String.format(text, new Date());
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}

	@GET
	@Path("{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("name") String name) {
		String response = String.format(text, name);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeModel getJson() {

		//...........db operation..
		//suppose we get these value from database
		//............
		String randomName = "random" + UUID.randomUUID().toString().substring(0,4);
		int randomAge = new Random().nextInt(100);

		//returns the value received from database
		return new EmployeeModel(randomName,randomAge);
		//return new EmployeeModel("Tom", 21);
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public EmployeeModel getXml() {

		//...........db operation..
		//suppose we get these value from database
		//............
		String randomName = "random" + UUID.randomUUID().toString().substring(0,4);
		int randomAge = new Random().nextInt(100);

		//returns the value received from database
		return new EmployeeModel(randomName,randomAge);
		//return new EmployeeModel("Tom", 21);
	}

	@POST
	@Path("/json/object")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public EmployeeModel postEmployee(EmployeeModel employee) {
		//We receive the object from client
		//Client might have send the json string as {"name":"hello","age":"24"}
		//do some processing ..save in database
		//return the output in xml format....
		return employee;
	}

	@POST
	@Path("/json/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response postPathParamValue(@PathParam("name") String name) {
		//Return what ever received from client
		String output = "Jersey Says :" + name;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/exception")
	@Produces(MediaType.TEXT_PLAIN)
	public Response throwException() {
		throw new RuntimeException("Exception thrown by getPathParamValue resource");
	}
}
