package inf.dao;

import inf.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    
    public ArrayList<Produto> getProdutos(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            String  sql = "SELECT * FROM produto";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setId(Integer.parseInt(rs.getString("id")));
                produto.setPreco(Double.parseDouble(rs.getString("preco")));
                produto.setArmazem(Integer.parseInt(rs.getString("armazem")));
                produto.setDescricao(rs.getString("descricao"));
                produtos.add(produto);
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
        return produtos;
    }

    public Produto getProduto(Connection conn, int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Produto produto = new Produto();
        if (id < 1) {
            throw new SQLException("Nenhum produto com o código informado.");
        }
        try {
            String  sql = "SELECT * FROM aluno WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                produto.setNome(rs.getString("nome"));
                produto.setId(Integer.parseInt(rs.getString("id")));
                produto.setPreco(Double.parseDouble(rs.getString("preco")));
                produto.setArmazem(Integer.parseInt(rs.getString("armazem")));
                produto.setDescricao(rs.getString("descricao"));
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
        return produto;
    }
    
}
