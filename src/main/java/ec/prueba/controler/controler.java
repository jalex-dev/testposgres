package ec.prueba.controler;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.prueba.model.Person;
import ec.prueba.service.ImplService;

@Path("/person")
public class controler {
    @Inject
    ImplService implService;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/listAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTodosRegistro() {
        List<Person> personList = Person.listAll();

        return Response.ok(personList).build();

        // return Response.ok("Lista Vacia").build();
    }

    @GET
    @Path("buscar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return Person.findByIdOptional(id)
                .map(Person -> Response.ok(Person).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("person/{edad}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getEdad(@PathParam("edad") Integer edad){
        return Response.ok(implService.listPersonAge(edad)).build();
    }

    @POST
    @Path("create")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Person person){
        Person.persist(person);
        if(person.isPersistent()){
            return Response.created(URI.create("/buscar"+person.id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}