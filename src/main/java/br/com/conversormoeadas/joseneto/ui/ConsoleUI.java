package br.com.conversormoeadas.joseneto.ui;

import java.util.Scanner;

import br.com.conversormoeadas.joseneto.service.ConversorMoedaService;

public class ConsoleUI {
	private ConversorMoedaService conversorMoedaService;

	public ConsoleUI(ConversorMoedaService conversorMoedaService) {
		this.conversorMoedaService = conversorMoedaService;
	}

	public void exibirMenu() {
		Scanner scan = new Scanner(System.in);
		String escolha = "";
		while (!escolha.equals("9")) {
			try {
				System.out.println("\n***********************************************************");
				System.out.println("Bem-vindo(a) ao Conversor de Moedas =]\n");
				System.out.println("1) Dólar =>> Peso argentino");
				System.out.println("2) Peso argentino =>> Dólar");
				System.out.println("3) Dólar =>> Real brasileiro");
				System.out.println("4) Real brasileiro =>> Dólar ");
				System.out.println("5) Dólar =>> Peso colombiano");
				System.out.println("6) Peso colombiano =>> Dólar");
				System.out.println("7) Dólar =>> Euro");
				System.out.println("8) Euro =>> Dólar");
				System.out.println("9) Sair");
				System.out.println("Escolha uma opção válida: ");
				System.out.println("***********************************************************\n");
				escolha = scan.nextLine();

				acoesDoSistema(escolha, scan);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				escolha = "";
			}
		}

		if (scan != null) {
			scan.close();
		}
	}

	private void acoesDoSistema(String opcao, Scanner scan) {
		String resultado = "";
		try {
			int opcaoInt = Integer.parseInt(opcao);

			if (opcaoInt < 1 || opcaoInt > 9) {
				throw new IllegalArgumentException("\nVocê não digitou uma opção válida, tente novamente\n");
			}

			if (opcaoInt != 9) {
				System.out.print("\nDigite o valor que deseja converter: ");
				double valor = scan.nextDouble();
				scan.nextLine();

				switch (opcaoInt) {
					case 1: {
						resultado = """
								\nO valor: %.2f [USD] corresponde ao valor final de =>>> %.2f [ARS]
								""".formatted(valor, conversorMoedaService.converter("USD", "ARS", valor));
						break;
					}
					case 2: {
						resultado = """
								\nO valor: %.2f [ARS] corresponde ao valor final de =>>> %.2f [USD]
								""".formatted(valor, conversorMoedaService.converter("ARS", "USD", valor));
						break;
					}
					case 3: {
						resultado = """
								\nO valor: %.2f [USD] corresponde ao valor final de =>>> %.2f [BRL]
								""".formatted(valor, conversorMoedaService.converter("USD", "BRL", valor));
						break;
					}
					case 4: {
						resultado = """
								\nO valor: %.2f [BRL] corresponde ao valor final de =>>> %.2f [USD]
								""".formatted(valor, conversorMoedaService.converter("BRL", "USD", valor));
						break;
					}
					case 5: {
						resultado = """
								\nO valor: %.2f [USD] corresponde ao valor final de =>>> %.2f [COP]
								""".formatted(valor, conversorMoedaService.converter("USD", "COP", valor));
						break;
					}
					case 6: {
						resultado = """
								\nO valor: %.2f [COP] corresponde ao valor final de =>>> %.2f [USD]
								""".formatted(valor, conversorMoedaService.converter("COP", "USD", valor));
						break;
					}
					case 7: {
						resultado = """
								\nO valor: %.2f [USD] corresponde ao valor final de =>>> %.2f [EUR]
								""".formatted(valor, conversorMoedaService.converter("USD", "EUR", valor));
						break;
					}
					case 8: {
						resultado = """
								\nO valor: %.2f [EUR] corresponde ao valor final de =>>> %.2f [USD]
								""".formatted(valor, conversorMoedaService.converter("EUR", "USD", valor));
						break;
					}
				}
				System.out.println(resultado);
				return;
			}
			System.out.println("\nObrigado por usar nosso sistema, até a próxima!!!");
		} catch (NumberFormatException e) {
			throw new NumberFormatException("\nDigite apenas números válidos\n");
		}
	}
}
