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
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON}) //"application/json"
    public Response buscaProduto(Produto produto){
        String produtoString = "";
        Produto a = new Produto();
        try{
            a = new AccessManager().getProduto(produto.getId());
            Gson gson = new Gson();
            produtoString = gson.toJson(a);
        } catch(Exception e){
            e.printStackTrace();
        }
        if (a.getId() != 0) {
            return Response.ok(produtoString).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();            
        }
    }
   
    @POST
    @Path("/add")
    @Consumes("application/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response insereProduto(Produto produto){
        try{
            if (new AccessManager().insertProduto(produto))
                return Response.ok(produto).build();
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.noContent().build();
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
    public Response deletaProduto(@PathParam("id") String id){
        try{
            if (new AccessManager().delProduto(Integer.parseInt(id)))
                return Response.ok().build();
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response atualizaProduto(Produto produto){
        try{
            if (new AccessManager().updateProduto(produto))
                return Response.ok(produto).build();
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    

}