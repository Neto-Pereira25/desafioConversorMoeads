package br.com.conversormoeadas.joseneto.service;

import br.com.conversormoeadas.joseneto.api.CotacaoAPI;

public class ConversorMoedaService {
	private CotacaoAPI cotacaoAPI;

    public ConversorMoedaService(CotacaoAPI cotacaoAPI) {
        this.cotacaoAPI = cotacaoAPI;
    }

    public double converter(String moedaBase, String moedaDestino, double valor) {
        double cotacao = cotacaoAPI.obterCotacao(moedaBase, moedaDestino).getConversionRate();
        
        return valor * cotacao;
    }
}
