package br.com.faculdade.repository;

import br.com.faculdade.exception.EntidadeNaoEncontradaException;
import br.com.faculdade.exception.ValidacaoException;
import br.com.faculdade.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoRepository {
    
    // Uso do HashMap: armazena produtos usando o 'id' (Integer) como chave
    private final Map<Integer, Produto> produtos = new HashMap<>();
    
    // Gerador de IDs automáticos (começa no 1)
    private int contadorId = 1;

    // C - CREATE (Cadastrar)
    public Produto salvar(String nome, double preco) {
        if (nome == null || nome.isBlank()) {
            throw new ValidacaoException("O nome do produto não pode ficar em branco.");
        }
        if (preco <= 0) {
            throw new ValidacaoException("O preço deve ser maior que zero.");
        }

        int id = contadorId++;
        Produto produto = new Produto(id, nome, preco);
        produtos.put(id, produto);
        return produto;
    }

    // R - READ (Listar todos)
    public List<Produto> listarTodos() {
        // Converte os valores do HashMap em um ArrayList para retornar
        return new ArrayList<>(produtos.values());
    }

    // R - READ (Buscar por ID)
    public Produto buscarPorId(int id) throws EntidadeNaoEncontradaException {
        Produto produto = produtos.get(id);
        if (produto == null) {
            throw new EntidadeNaoEncontradaException("Produto com ID " + id + " não foi encontrado.");
        }
        return produto;
    }

    // U - UPDATE (Atualizar)
    public void atualizar(int id, String novoNome, double novoPreco) throws EntidadeNaoEncontradaException {
        Produto produto = buscarPorId(id); // Se não achar, já dispara a exceção
        
        if (novoNome == null || novoNome.isBlank()) {
            throw new ValidacaoException("O nome do produto não pode ficar em branco.");
        }
        if (novoPreco <= 0) {
            throw new ValidacaoException("O preço deve ser maior que zero.");
        }

        produto.setNome(novoNome);
        produto.setPreco(novoPreco);
    }

    // D - DELETE (Remover)
    public void deletar(int id) throws EntidadeNaoEncontradaException {
        buscarPorId(id); // Garante que o item existe antes de apagar
        produtos.remove(id);
    }
}