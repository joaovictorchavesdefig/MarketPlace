package inf.entity;
import inf.entity.Produto;
import java.util.ArrayList;

public class Carrinho {
    
    ArrayList <Produto> itens;
    
    public ArrayList <Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList <Produto> itens) {
        this.itens = itens;
    }
    
    public Carrinho(ArrayList <Produto> itens) {
        this.itens = itens;
    }
    public Carrinho(){
    }
}
