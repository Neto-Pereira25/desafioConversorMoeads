package br.com.conversormoeadas.joseneto.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import br.com.conversormoeadas.joseneto.model.Moeda;
import io.github.cdimascio.dotenv.Dotenv;

public class CotacaoAPI {
	private Dotenv dotenv = Dotenv.load();
	
	private final String URL_API = "https://v6.exchangerate-api.com/v6/";
	private final String KEY = dotenv.get("KEY");

	public Moeda obterCotacao(String moedaBase, String moedaDestino) {
		Moeda resultado = null;
		try {
			URI endpoint = URI.create(URL_API + KEY + "/pair/" + moedaBase + "/" + moedaDestino);

			HttpRequest request = HttpRequest.newBuilder().uri(endpoint).build();

			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			resultado = new Gson().fromJson(response.body(), Moeda.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
