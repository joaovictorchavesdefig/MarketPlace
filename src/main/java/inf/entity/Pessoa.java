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

    private String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    private ArrayList getCartao() {
        return cartao;
    }

    private void setCartao(ArrayList cartao) {
        this.cartao = cartao;
    }

    private ArrayList<Enderecos> getEnderecos() {
        return enderecos;
    }

    private void setEnderecos(ArrayList<Enderecos> enderecos) {
        this.enderecos = enderecos;
    }
}
