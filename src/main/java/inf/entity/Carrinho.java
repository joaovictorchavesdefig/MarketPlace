package inf.entity;
import inf.entity.Produto;
import java.util.ArrayList;

public class Carrinho {
    
    private ArrayList <Produto> itens;
    
    public ArrayList <Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList <Produto> itens) {
        this.itens = itens;
    }

    public void setItem(Produto item) {
        this.itens.add(item);
    }

    public void removeItem(Produto item) {
        this.itens.remove(item);
    }
    
    public Carrinho(ArrayList <Produto> itens) {
        this.itens = itens;
    }
    public Carrinho(){
    }
}
