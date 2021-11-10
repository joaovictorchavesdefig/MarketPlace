package inf.dao;

import inf.entity.Carrinho;
import inf.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDao {
    
    private static List<Produto> produtos = new ArrayList();
    
    public static List todoCarrinho(){
        //produtos.add(new Produto("pc", 1, 10.99, 5, "Pc gamer"));
        return produtos;
    }

    public static boolean insereCarrinho(Produto produto){
        for(Produto p : produtos){
            if(p.getId() == produto.getId())
                return true;
        }
        produtos.add(produto);
        return true;
    }

    public static boolean excluiCarrinho(Produto produto){
        for(Produto p : produtos){
            if (p.getId() == produto.getId()){
                produtos.remove(produto);
                return true;    
            }
        }
        return false;
    }
    
}
