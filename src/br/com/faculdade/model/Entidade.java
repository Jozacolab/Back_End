package br.com.faculdade.model;

// 'abstract' significa que essa classe serve apenas de molde e não pode ser instanciada diretamente
public abstract class Entidade {
    
    // Atributo privado: guarda o identificador único da entidade
    private int id;

    // Construtor: método chamado na criação do objeto para definir o ID inicial
    public Entidade(int id) {
        this.id = id;
    }

    // Getter: método para ler/obter o valor do ID
    public int getId() {
        return id;
    }

    // Setter: método para alterar o valor do ID
    public void setId(int id) {
        this.id = id;
    }

    // Método Abstrato (Polimorfismo):
    // Obriga qualquer classe filha (ex: Produto ou Usuario) a definir como vai exibir seus dados
    public abstract String getExibicaoDetalhada();
}