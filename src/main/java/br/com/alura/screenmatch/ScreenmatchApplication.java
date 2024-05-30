package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
		
	}

	 @Override
    public void run(String... args) throws Exception  {

		String endereco = "https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c";
		String endereco2 = "https://www.omdbapi.com/?t=matrix&apikey=6585022c";

		ConsumoApi consumoApi = new ConsumoApi();

		var json = consumoApi.obterDados(endereco);
		var json2 = consumoApi.obterDados(endereco2);

		System.out.println("Conteúdo do json: " + json + "\n");
		//System.out.println(json2);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println("Conteúdo os dados: " + dados);

    }


}
