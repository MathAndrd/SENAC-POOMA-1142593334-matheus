package ferramentaAN;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnaliseDados {


	    private List<Cliente> clientes;
	    private List<Produto> produtos;
	    private List<Venda> vendas;

	    public AnaliseDados() {
	        clientes = new ArrayList<>();
	        produtos = new ArrayList<>();
	        vendas = new ArrayList<>();
	    }

	    // Métodos de cadastro

	    public void cadastrarCliente(Cliente cliente) {
	        if (cliente.validaCliente()) {
	            clientes.add(cliente);
	            System.out.println("Cliente cadastrado com sucesso!");
	        }
	    }

	    public void cadastrarProduto(Produto produto) {
	        if (produto.validarProduto(produto)) {
	            produtos.add(produto);
	            System.out.println("Produto cadastrado com sucesso!");
	        }
	    }

	    void cadastrarVenda(Scanner scanner) {
	        System.out.print("Data da Venda (AAAA-MM-DD): ");
	        LocalDate dataDaVenda = LocalDate.parse(scanner.nextLine());

	        System.out.println("Selecione um cliente:");
	        for (int i = 0; i < clientes.size(); i++) {
	            System.out.println(i + ". " + clientes.get(i).getNome());
	        }

	        int escolhaCliente = scanner.nextInt();
	        scanner.nextLine();

	        if (escolhaCliente >= 0 && escolhaCliente < clientes.size()) {
	            Cliente clienteEscolhido = clientes.get(escolhaCliente);

	            List<Produto> produtosEscolhidos = new ArrayList<>();
	            while (true) {
	                System.out.println("Selecione um produto (ou -1 para terminar):");
	                for (int i = 0; i < produtos.size(); i++) {
	                    System.out.println(i + ". " + produtos.get(i).getNome());
	                }

	                int escolhaProduto = scanner.nextInt();
	                scanner.nextLine();

	                if (escolhaProduto == -1) {
	                    break;
	                }

	                if (escolhaProduto >= 0 && escolhaProduto < produtos.size()) {
	                    produtosEscolhidos.add(produtos.get(escolhaProduto));
	                } else {
	                    System.out.println("Escolha de produto inválida. Tente novamente.");
	                }
	            }

	            System.out.print("Valor Total da Venda: ");
	            double valorTotal = scanner.nextDouble();
	            scanner.nextLine();

	            Venda venda = new Venda();
	            venda.setDataDaVenda(dataDaVenda);
	            venda.setCliente(clienteEscolhido);
	            venda.setProdutos(produtosEscolhidos);
	            venda.setValorTotal(valorTotal);

	            if (venda.validarVenda()) {
	                vendas.add(venda);
	                System.out.println("Venda cadastrada com sucesso!");
	            }
	        } else {
	            System.out.println("Escolha de cliente inválida. A venda será cancelada.");
	        }
	    }

	    // Métodos de análise de dados podem ser adicionados aqui

    // Método para realizar análise descritiva
    public void analisarDescritiva(List<Double> dados) {
        double media = calcularMedia(dados);
        double mediana = calcularMediana(dados);
        double desvioPadrao = calcularDesvioPadrao(dados, media);

        exibirResultadoDescritiva(media, mediana, desvioPadrao);
    }

    // Método para realizar análise de tendências e séries temporais
    public void analisarTendencias(List<Double> dados) {
        // Implemente a análise de tendências e séries temporais, se necessário.
    }

    // Método para realizar análise de correlação e regressão
    public void analisarCorrelacaoRegressao(List<Double> x, List<Double> y) {
        double coeficienteCorrelacao = calcularCoeficienteCorrelacao(x, y);

        exibirResultadoCorrelacaoRegressao(coeficienteCorrelacao);
    }

    private double calcularMedia(List<Double> dados) {
        double soma = 0.0;
        for (Double valor : dados) {
            soma += valor;
        }
        return soma / dados.size();
    }

    private double calcularMediana(List<Double> dados) {
         Collections.sort(dados);
        int meio = dados.size() / 2;
        return dados.get(meio);
        
    }

    private double calcularDesvioPadrao(List<Double> dados, double media) {
        double somaDosQuadrados = 0.0;
        for (Double valor : dados) {
            somaDosQuadrados += Math.pow(valor - media, 2);
        }
        return Math.sqrt(somaDosQuadrados / dados.size());
    }

    private double calcularCoeficienteCorrelacao(List<Double> x, List<Double> y) {
        // Implemente o cálculo do coeficiente de correlação, por exemplo, o coeficiente de Pearson.
        // Consulte uma biblioteca de análise de dados para cálculos mais avançados.
        return 0.0;
    }

    private void exibirResultadoDescritiva(double media, double mediana, double desvioPadrao) {
        System.out.println("Resultados da Análise Descritiva:");
        System.out.println("Média: " + media);
        System.out.println("Mediana: " + mediana);
        System.out.println("Desvio Padrão: " + desvioPadrao);
    }

    private void exibirResultadoCorrelacaoRegressao(double coeficienteCorrelacao) {
        System.out.println("Resultado da Análise de Correlação e Regressão:");
        System.out.println("Coeficiente de Correlação: " + coeficienteCorrelacao);
    }
    
    
}
