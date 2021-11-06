package inf.entity;
import inf.entity.Produto;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    
    private ArrayList <Produto> favoritos;
    private ArrayList <Produto> historico;
    
    public ArrayList <Produto> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList <Produto> favoritos) {
        this.favoritos = favoritos;
    }

    public ArrayList <Produto> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList <Produto> historico) {
        this.historico = historico;
    }

    public Cliente(ArrayList <Produto> favoritos, ArrayList <Produto> historico) {
        this.favoritos = favoritos;
        this.historico = historico;
    }
    public Cliente(){
    }
    
}
