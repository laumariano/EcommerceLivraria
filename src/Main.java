import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        visualizarProdutos();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
                opcao = 0;
            }
        } while (opcao != 3);
    }

    private static void exibirMenu() {
        System.out.println("\n===== Menu Principal =====");
        System.out.println("1. Cadastrar produto");
        System.out.println("2. Visualizar produtos");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarProduto() {
        System.out.println("\n===== Cadastro de Produto =====");
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = 0;
        boolean valido = false;
        while (!valido) {
            try {
                preco = Double.parseDouble(scanner.nextLine());
                if (preco > 0) {
                    valido = true;
                } else {
                    System.out.println("Preço inválido. Digite um valor maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido para o preço.");
            }
        }
        System.out.print("Digite o tipo do produto (fisico ou digital): ");
        String tipoProduto = scanner.nextLine().toLowerCase();
        System.out.println("Tipo de produto digitado: " + tipoProduto);
        Produto produto;
        if (tipoProduto.equals("fisico")) {
            System.out.print("Digite a descrição do produto físico: ");
            String descricao = scanner.nextLine();
            produto = new ProdutoFisico(nome, preco, descricao);
        } else if (tipoProduto.equals("digital")) {
            System.out.print("Digite o link de download do produto digital: ");
            String linkDownload = scanner.nextLine();
            produto = new ProdutoDigital(nome, preco, linkDownload);
        } else {
            System.out.println("Tipo de produto inválido: " + tipoProduto);
            return;
        }
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void visualizarProdutos() {
        System.out.println("\n===== Produtos Cadastrados =====");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}

abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public abstract void exibirDetalhes();
}

class ProdutoFisico extends Produto {
    private String descricao;

    public ProdutoFisico(String nome, double preco, String descricao) {
        super(nome, preco);
        this.descricao = descricao;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Descrição: " + descricao);
    }

    @Override
    public String toString() {
        return "Produto Físico: " + nome + ", Preço: " + preco + ", Descrição: " + descricao;
    }
}

class ProdutoDigital extends Produto {
    private String linkDownload;

    public ProdutoDigital(String nome, double preco, String linkDownload) {
        super(nome, preco);
        this.linkDownload = linkDownload;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Link de Download: " + linkDownload);
    }

    @Override
    public String toString() {
        return "Produto Digital: " + nome + ", Preço: " + preco + ", Link de Download: " + linkDownload;
    }
}
