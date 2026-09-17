package br.com.faculdade;

import br.com.faculdade.exception.EntidadeNaoEncontradaException;
import br.com.faculdade.exception.ValidacaoException;
import br.com.faculdade.model.Produto;
import br.com.faculdade.repository.ProdutoRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoRepository repository = new ProdutoRepository();
        boolean executando = true;

        System.out.println("=======================================");
        System.out.println("   SISTEMA DE GERENCIAMENTO DE PRODUTOS");
        System.out.println("=======================================");

        while (executando) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Todos os Produtos");
            System.out.println("3. Buscar Produto por ID");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Excluir Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer de texto do teclado

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço do produto: ");
                        double preco = scanner.nextDouble();
                        Produto novo = repository.salvar(nome, preco);
                        System.out.println("✅ Cadastrado com sucesso: " + novo.getExibicaoDetalhada());
                        break;

                    case 2:
                        List<Produto> lista = repository.listarTodos();
                        if (lista.isEmpty()) {
                            System.out.println("⚠️ Nenhum produto cadastrado.");
                        } else {
                            System.out.println("\n--- PRODUTOS CADASTRADOS ---");
                            for (Produto p : lista) {
                                System.out.println(p.getExibicaoDetalhada());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Digite o ID do produto: ");
                        int idBusca = scanner.nextInt();
                        Produto buscado = repository.buscarPorId(idBusca);
                        System.out.println("🔍 Encontrado: " + buscado.getExibicaoDetalhada());
                        break;

                    case 4:
                        System.out.print("ID do produto para atualizar: ");
                        int idUpd = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo preço: ");
                        double novoPreco = scanner.nextDouble();
                        repository.atualizar(idUpd, novoNome, novoPreco);
                        System.out.println("✅ Produto atualizado!");
                        break;

                    case 5:
                        System.out.print("ID do produto para excluir: ");
                        int idDel = scanner.nextInt();
                        repository.deletar(idDel);
                        System.out.println("🗑️ Produto excluído com sucesso!");
                        break;

                    case 0:
                        executando = false;
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("❌ Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Erro: Digite apenas números válidos.");
                scanner.nextLine(); // Limpa a entrada incorreta
            } catch (EntidadeNaoEncontradaException | ValidacaoException e) {
                System.out.println("⚠️ AVISO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❌ Erro inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }
}