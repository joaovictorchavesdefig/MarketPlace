package inf.services;

import com.google.gson.Gson;
import inf.entity.Produto;
import inf.manager.AccessManager;
import inf.dao.CarrinhoDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
    
@Path("/compra")
public class RecursoCompra {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response Comprar(){
    String preco = "";
    try {
            Gson gson = new Gson();
            preco = gson.toJson(new AccessManager().RealizarCompra());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (preco.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(preco).build();
        }
}

    @GET
    @Path("/historico")
    @Produces({MediaType.APPLICATION_JSON})
    public Response todasCompras(){
        String vendidos = "";
        try {
            Gson gson = new Gson();
            vendidos = gson.toJson(new AccessManager().getComprados());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (vendidos.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(vendidos).build();
        }
    }
    
}
