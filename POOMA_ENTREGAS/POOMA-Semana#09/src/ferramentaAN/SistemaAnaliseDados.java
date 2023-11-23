package ferramentaAN;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaAnaliseDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnaliseDados analiseDados = new AnaliseDados();

        while (true) {
            System.out.println("====== Sistema de Análise de Dados ======");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Cadastrar Venda");
            System.out.println("4. Realizar Análise de Dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarCliente(scanner, analiseDados);
                    break;
                case 2:
                    cadastrarProduto(scanner, analiseDados);
                    break;
                case 3:
                    analiseDados.cadastrarVenda(scanner);
                    break;
                case 4:
                    realizarAnaliseDados(analiseDados);
                    break;
                case 0:
                    System.out.println("Saindo do Sistema de Análise de Dados. Até mais!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente(Scanner scanner, AnaliseDados analiseDados) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço do Cliente: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone, endereco);
        analiseDados.cadastrarCliente(cliente);
    }

    private static void cadastrarProduto(Scanner scanner, AnaliseDados analiseDados) {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Categoria do Produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Quantidade em Estoque: ");
        int quantidadeEmEstoque = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Produto produto = new Produto(nome, categoria, preco, quantidadeEmEstoque);
        analiseDados.cadastrarProduto(produto);
    }

    private static void realizarAnaliseDados(AnaliseDados analiseDados) {
        // Implemente aqui as análises de dados desejadas
        // Você pode chamar os métodos da classe AnaliseDados para acessar os dados e realizar as análises
    }
}
