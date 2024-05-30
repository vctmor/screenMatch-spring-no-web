package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private final String  ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private final Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private String json;
    private DadosSerie dados;
    private String nomeSerie;

    public void exibeMenu(){

        System.out.println("Digite o nome da série");

        nomeSerie = leitura.nextLine();

        // faz requisição à API para obter dados da série
        json = consumo.obterDados(ENDERECO + nomeSerie
                .replace(" ", "+") + API_KEY);

        dados = conversor.obterDados(json,DadosSerie.class);

        System.out.println(dados);


    }
}
