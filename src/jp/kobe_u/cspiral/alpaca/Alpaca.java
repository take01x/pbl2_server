package jp.kobe_u.cspiral.alpaca;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class Alpaca {

	private final AlpacaController controller = new AlpacaController();

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/like")
	public Response like() {
		controller.like();
		return Response.status(200).entity("<like>ok</like>").build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/comment")
	public Response comment(@QueryParam("msg") final String message) {
		if ("".equals(message)) {
			return Response.status(403).entity("<comment>error</comment>").build();
		}
		controller.comment(message);
		return Response.status(200).entity("<comment>ok</comment>").build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/getComment")
	public Response getComment(
			@PathParam("presenter") final String presenter,
			@DefaultValue("-1") @QueryParam("n") final int n) {
		if (n < 0 && n != -1) {
			return Response.status(403).entity("<comment>error</comment>").build();
		}
		return Response.status(200).entity(controller.getComment(controller.getPresenter(), n)).build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/report")
	public Response getReport(
			@PathParam("presenter") final String presenter,
			@DefaultValue("20") @QueryParam("n") final int n) {
		if (n < 0) {
			return Response.status(403).entity("<comment>error</comment>").build();
		}
		return Response.status(200).entity(controller.getReport(controller.getPresenter(), n)).build();
	}

	@GET
	@Path("/")
	public Response redirect() throws URISyntaxException{
		URI uri = new URI("application.wadl");
		return Response.seeOther(uri).build();
	}

/*
	@GET
	@Produces({"application/xml"})
	@Path("/setPresenter")
	public Response setPresenter(@QueryParam("presenter") final String presenter) {
		controller.setPresenter(presenter);
		return Response.status(200).entity(presenter).build();
	}

	@GET
	@Produces({"application/xml"})
	@Path("/getPresenter")
	public Response getPresenter() {
		return Response.status(200).entity(controller.getPresenter()).build();
	}


	@GET
	@Produces({"application/xml"})
	@Path("/listPresenters")
	public Response listPresenters() {
		Presenters list = controller.listPresenters();

		return Response.status(200).entity(list).build();
	}
*/

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/next")
	public Response next() {
		controller.next();
		return Response.status(200).entity("<next>ok</next>").build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/prev")
	public Response prev() {
		controller.prev();
		return Response.status(200).entity("<prev>ok</prev>").build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/getSlide")
	public Response getSlideURL() {
		return Response.status(200).entity(this.controller.getSlideURL()).build();
	}


}
