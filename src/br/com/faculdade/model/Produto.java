package br.com.faculdade.model;

// 'extends Entidade' significa que Produto herda todos os campos e comportamentos de Entidade
public class Produto extends Entidade {
    
    // Atributos próprios da classe Produto
    private String nome;
    private double preco;

    // Construtor do Produto
    public Produto(int id, String nome, double preco) {
        super(id); // 'super(id)' envia o ID para o construtor da classe pai (Entidade)
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters dos atributos de Produto
    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public double getPreco() { 
        return preco; 
    }

    public void setPreco(double preco) { 
        this.preco = preco; 
    }

    // @Override indica Polimorfismo: sobrescrevemos o método abstrato definido na Entidade
    @Override
    public String getExibicaoDetalhada() {
        return String.format("ID: %d | Produto: %s | Preço: R$ %.2f", getId(), nome, preco);
    }
}