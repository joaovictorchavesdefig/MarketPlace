package inf.entity;
import inf.entity.Produto;
import java.util.ArrayList;

public class Vendedor extends Pessoa{
    
    ArrayList <Produto> mercadoria;

    public ArrayList <Produto> getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(ArrayList <Produto> mercadoria) {
        this.mercadoria = mercadoria;
    }
    
    public Vendedor(ArrayList <Produto> mercadoria) {
        this.mercadoria = mercadoria;
    }
    public Vendedor(){
    }

}
