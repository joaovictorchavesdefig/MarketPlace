package inf.dao;

import inf.entity.Carrinho;
import inf.entity.Produto;
import inf.dao.CarrinhoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDao {
    
    public ArrayList<Produto> getComprados(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            String  sql = "SELECT * FROM compras";
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

    public static double RealizarCompra(Connection conn) throws SQLException{
        PreparedStatement ps = null;
        List<Produto> produtos = new CarrinhoDao().todoCarrinho();
        double preco = 0;
        try {
            for(Produto p : produtos){
                String  sql = "INSERT INTO compras (nome, id, preco, armazem, descricao) " +
                    "VALUES(?, ?, ?, ?, ?) ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, p.getNome());
                ps.setInt(2, p.getId());
                ps.setDouble(3, p.getPreco());
                ps.setInt(4, p.getArmazem());
                ps.setString(5, p.getDescricao());
                ps.executeUpdate();
                preco = preco + p.getPreco();
}
        } catch (Exception e) {
            e.printStackTrace();
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
        return preco;
}
    
}
