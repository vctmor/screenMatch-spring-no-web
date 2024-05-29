package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco){
        
        //cria cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        //constroi requisicao HTTP com URI fornecida()
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();

        //declara variavel response do tipo HttpResponse<String>
        HttpResponse<String> response = null;

        try {
            // envia requsição http e obtem a resposta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        //Extrai o corpo da resposta com string (json)
        String json = response.body();
        
        return json;}
    
}
