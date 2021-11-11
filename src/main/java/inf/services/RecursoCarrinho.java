package inf.services;

import com.google.gson.Gson;
import inf.entity.Produto;
import inf.entity.Carrinho;
import inf.dao.CarrinhoDao;
import inf.manager.AccessManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/carrinho")

public class RecursoCarrinho {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response todoCarrinho(){
        String car = "";
        Gson gson = new Gson();
        car = gson.toJson(new CarrinhoDao().todoCarrinho());
        if (car.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(car).build();
        }
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response insereCarrinho(Produto produto){
        if (new CarrinhoDao().insereCarrinho(produto))
            return Response.ok(produto).build();
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
    public Response deletaCarrinho(@PathParam("id") String id){
        if (new CarrinhoDao().excluiCarrinho(Integer.parseInt(id)))
                return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
