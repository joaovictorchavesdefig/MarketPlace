package inf.dao;

import inf.entity.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viniciusspatto
 */
public class AlunoDao {


/****************************BUSCA TODOS******************************/
//    private static List<Aluno> alunos = new ArrayList();
//    public static List todosAlunos(){
//        if (alunos.isEmpty()) {
//            alunos.add(new Aluno(1, "Lobo", 'm'));
//            alunos.add(new Aluno(2, "Chapeuzinho", 'f'));
//            alunos.add(new Aluno(3, "Caçador", 'm'));
//        }
//        return alunos;
//    }
    /**
     * Metodo chamado para executar a query para buscar alunos no banco de
     * dados (tabela aluno - bd escola)
     *
     * @Param Connection conn
     * @return ArrayList<Aluno> alunos throws SQLException
     */
    public ArrayList<Aluno> getAlunos(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        try {
            String  sql = "SELECT * FROM aluno";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(Integer.parseInt(rs.getString("id")));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                alunos.add(aluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return alunos;
    }

/****************************BUSCA UM ALUNO******************************/    
//    public static Aluno buscaAluno(int id){
//        for(Aluno a : alunos){
//            if(a.getId() == id)
//                return a;
//        }
//        return new Aluno();
//    }
     /**
     * Metodo chamado para executar a query para recuperar um aluno no banco
     * de dados (tabela aluno - bd escola)
     *
     * @Param Connection conn
     * @Param int id
     * @return Aluno throws SQLException
     */
    public Aluno getAluno(Connection conn, int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Aluno aluno = new Aluno();
        if (id < 1) {
            throw new SQLException("Nenhum aluno com o código informado.");
        }
        try {
            String  sql = "SELECT * FROM aluno WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);  //ESTAVA aluno.getId() e ps.setString
            rs = ps.executeQuery();
            while(rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return aluno;
    }
        
/****************************INSERE UM ALUNO******************************/
//    public static boolean insereAluno(Aluno aluno){
//        for(Aluno a : alunos){
//            if(a.getId() == aluno.getId())
//                return true;
//        }
//        alunos.add(aluno);
//        return true;
//    }
    /**
     * Metodo chamado para executar a query para inserir um aluno no banco de
     * dados (tabela aluno - bd escola)
     *
     * @Param Connection conn
     * @Param Aluno aluno
     * @return boolean throws SQLException
     */
    public boolean insertAluno(Connection conn, Aluno aluno) throws SQLException {
        PreparedStatement ps = null;
        if (aluno.getId() == 0) {
            throw new SQLException("Nenhum aluno com o código informado.");
        }
        try {
            String  sql = "INSERT INTO aluno (id, nome, sexo) " +
                    "VALUES(?, ?, ?) ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ps.setString(2, aluno.getNome());
            ps.setString(3, String.valueOf(aluno.getSexo()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return true;
    }
    
/****************************ATUALIZA UM ALUNO******************************/
//    public static boolean atualizaAluno(Aluno aluno){
//        for(Aluno a : alunos){
//            if (a.getId() == aluno.getId()){
//                alunos.add(alunos.indexOf(a), aluno);
//                alunos.remove(a);
//                return true;
//            }
//        }
//        return false;
//    }    
    /**
     * Metodo chamado para executar a query para atalizar um aluno no banco de
     * dados (tabela aluno - bd escola)
     *
     * @Param Connection conn
     * @Param Aluno aluno
     * @return boolean throws SQLException
     */
    public boolean updateAluno(Connection conn, Aluno aluno) throws SQLException {
        PreparedStatement ps = null;
        if (aluno.getId() == 0) {
            throw new SQLException("Nenhum aluno com o código informado.");
        }
        try {
            String  sql = "UPDATE aluno SET nome=?, sexo=?"+
                    "WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, String.valueOf(aluno.getSexo()));
            ps.setInt(3, aluno.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return true;
    }

/****************************EXCLUI UM ALUNO******************************/
//    public static boolean excluiAluno(Aluno aluno){
//        for(Aluno a : alunos){
//            if (a.getId() == aluno.getId()){
//                alunos.remove(a);
//                return true;    
//            }
//        }
//        return false;
//    }    
    /**
     * Metodo chamado para executar a query para excluir um aluno no banco de
     * dados (tabela aluno - bd escoa)
     *
     * @Param Connection conn
     * @Param Aluno aluno
     * @return boolean throws SQLException
     */
    public boolean delAluno(Connection conn, int id) throws SQLException {
        PreparedStatement ps = null;
        if (id < 1) {
            throw new SQLException("Nenhum aluno com o código informado.");
        }
        try {
            String  sql = "DELETE FROM aluno WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return true;
    }

}