package inf.manager;

import inf.dao.DBConn;
import inf.dao.AlunoDao;
import inf.dao.ProdutoDao;
import inf.entity.Aluno;
import inf.entity.Produto;
import java.sql.Connection;
import java.util.ArrayList;

public class AccessManager {

    public ArrayList<Aluno> getAlunos() throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        AlunoDao alunoDAO = new AlunoDao();
        return alunoDAO.getAlunos(conn);
    }
    
    public Aluno getAluno(int id) throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        AlunoDao alunoDAO = new AlunoDao();
        return alunoDAO.getAluno(conn, id);
    }
    
    public boolean insertAluno(Aluno aluno) throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        AlunoDao alunoDAO = new AlunoDao();
        return alunoDAO.insertAluno(conn, aluno);
    }
    
    public boolean udateAluno(Aluno aluno) throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        AlunoDao alunoDAO = new AlunoDao();
        return alunoDAO.updateAluno(conn, aluno);
    }
    
    public boolean delAluno(int id) throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        AlunoDao alunoDAO = new AlunoDao();
        return alunoDAO.delAluno(conn, id);
    }

    public ArrayList<Produto> getProdutos() throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        ProdutoDao produtoDAO = new ProdutoDao();
        return produtoDAO.getProdutos(conn);
    }

    public Produto getProduto(int id) throws Exception{
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConnection();
        ProdutoDao produtoDAO = new ProdutoDao();
        return produtoDAO.getProduto(conn, id);
    }

}