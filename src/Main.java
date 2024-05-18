import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Visualizar produtos");
            System.out.println("3. Sair");
            opcao = scanner.nextInt();

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
        } while (opcao != 3);
    }

    private static void cadastrarProduto() {

    }

    private static void visualizarProdutos() {

    }
}
