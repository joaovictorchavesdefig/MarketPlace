package inf.entity;

public class Produto {
    private String nome;
    private int id;
    private float preco;
    private int armazem; //Número do local do produto Ex: 1,2,3...
    private String descricao;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    private int getArmazem() {
        return armazem;
    }

    private void setArmazem(int armazem) {
        this.armazem = armazem;
    }

    private String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto(String nome, int id, float preco, int armazem, String descricao) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.armazem = armazem;
        this.descricao = descricao;
    }
    public Produto(){
    }

}
