package inf.entity;
import inf.entity.Produto;
import java.util.ArrayList;

public class Compra {
    
    private ArrayList <Produto> itens;
    
    public ArrayList <Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList <Produto> itens) {
        this.itens = itens;
    }
    
    public Compra(ArrayList <Produto> itens) {
        this.itens = itens;
    }
    public Compra(){
    }
}
