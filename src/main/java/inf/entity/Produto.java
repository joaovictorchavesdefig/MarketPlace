package inf.entity;

public class Produto {
    private String nome;
    private int id;
    private double preco;
    private int armazem; //Número do local do produto Ex: 1,2,3...
    private String descricao;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getArmazem() {
        return armazem;
    }

    public void setArmazem(int armazem) {
        this.armazem = armazem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto(String nome, int id, double preco, int armazem, String descricao) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.armazem = armazem;
        this.descricao = descricao;
    }
    public Produto(){
    }

}
