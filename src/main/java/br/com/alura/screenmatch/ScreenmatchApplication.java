package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
		
	}

	 @Override
    public void run(String... args) throws Exception  {

		 Principal principal = new Principal();

		 principal.exibeMenu();

//
//		 List<String> nomes = Arrays.asList("Victor", "Aline",
//				 					"Graziella", "Ana", "Vitor","Yasmin", "Iasmin", "Jaque");
//
//		 nomes.stream()
//				 .sorted()
//				 .limit(nomes.size()/2)
//				 .filter(n -> n.startsWith("A"))
//				 .map(n-> n.toUpperCase())
//				 .forEach(System.out::println);
    }


}
