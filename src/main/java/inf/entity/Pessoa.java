package inf.entity;
import inf.entity.Enderecos;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;
    private String nasc; //data de nascimento
    private ArrayList cartao;
    private ArrayList <Enderecos> enderecos;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public ArrayList getCartao() {
        return cartao;
    }

    public void setCartao(ArrayList cartao) {
        this.cartao = cartao;
    }

    public ArrayList<Enderecos> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Enderecos> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa(String nome, String cpf, String nasc, ArrayList cartao, ArrayList<Enderecos> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.nasc = nasc;
        this.cartao = cartao;
        this.enderecos = enderecos;
    }
    public Pessoa(){
    }

}
