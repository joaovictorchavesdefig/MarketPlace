package inf.services;

import com.google.gson.Gson;
import inf.entity.Aluno;
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

/**
 *
 * @author viniciusspatto
 */
@Path("/alunos")

public class RecursoAluno {

    /**
     * @return a JSON (collection of alunos)
     * Acessa todos os alunos por 
     * http://localhost:8080/webService1/resources/alunos (método GET)
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON}) //"application/json"
    public Response todosAlunos(){
        String turma = "";
        try {
            Gson gson = new Gson();
            turma = gson.toJson(new AccessManager().getAlunos());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (turma.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(turma).build();
        }
    }
    
    /*
     * @return a JSON (just one aluno)
     *Acessa um unico o aluno por 
     *http://localhost:8080/webService1/resources/alunos
    */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON}) //"application/json"
    public Response buscaAluno(Aluno aluno){
        String alunoString = "";
        Aluno a = new Aluno();
        try{
            a = new AccessManager().getAluno(aluno.getId());
            Gson gson = new Gson();
            alunoString = gson.toJson(a);
        } catch(Exception e){
            e.printStackTrace();
        }
        if (a.getId() != 0) {
            return Response.ok(alunoString).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();            
        }
    }
    
    /*
     * @return a HTTP Response (OK, or Expectation Failed)
     * Insere um aluno por 
     *http://localhost:8080/webService1/resources/alunos/add
    */
    @POST
    @Path("/add")
    @Consumes("application/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response insereAluno(Aluno aluno){
        try{
            if (new AccessManager().insertAluno(aluno))
                return Response.ok(aluno).build();
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.noContent().build();
    }
    
    
    /*
     * @return a HTTP Response (OK or Not Found)
     *Acessa e atualiza um unico o aluno por 
     *http://localhost:8080/webService1/resources/alunos/udate
    */
    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response atualizaAluno(Aluno aluno){
        try{
            if (new AccessManager().udateAluno(aluno))
                return Response.ok(aluno).build();
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    /*
     * @return a HTTP Response (OK, or Not Found)
     * Exclui um aluno por 
     *http://localhost:8080/webService1/resources/alunos/del
    */
    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
    public Response deletaAluno(@PathParam("id") String id){
        try{
            if (new AccessManager().delAluno(Integer.parseInt(id)))
                return Response.ok().build();
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
