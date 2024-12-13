package br.com.conversormoeadas.joseneto;

import br.com.conversormoeadas.joseneto.api.CotacaoAPI;
import br.com.conversormoeadas.joseneto.service.ConversorMoedaService;
import br.com.conversormoeadas.joseneto.ui.ConsoleUI;

public class App {

	public static void main(String[] args) {
		ConsoleUI console = new ConsoleUI(new ConversorMoedaService(new CotacaoAPI()));

		console.exibirMenu();
	}

}
