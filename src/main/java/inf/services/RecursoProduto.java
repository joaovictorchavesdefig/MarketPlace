package inf.services;

import com.google.gson.Gson;
import inf.entity.Produto;
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

@Path("/produtos")
public class RecursoProduto {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response todosProdutos(){
        String prods = "";
        try {
            Gson gson = new Gson();
            prods = gson.toJson(new AccessManager().getProdutos());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (prods.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(prods).build();
        }
    }

}
