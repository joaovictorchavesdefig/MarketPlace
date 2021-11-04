package inf.services;

import com.google.gson.Gson;
import inf.entity.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author viniciusspatto
 */
@Path("/alunos")
public class RecursoAluno {

    @GET
    @Produces({MediaType.APPLICATION_JSON}) //"application/json"
    public Response alunos(){
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(new Aluno(1, "Lobo", 'm'));
        alunos.add(new Aluno(2, "Chapeuzinho", 'f'));
        alunos.add(new Aluno(3, "Caçador", 'm'));
        Gson gson = new Gson();
        String turma = gson.toJson(alunos);
        if (turma.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(turma).build();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response adicionaDataNome(Aluno aluno){
        int i = 0 ;
        aluno.setNome(aluno.getNome() + " - 14/10/2021");
        return Response.ok(aluno).build();
    }

}
