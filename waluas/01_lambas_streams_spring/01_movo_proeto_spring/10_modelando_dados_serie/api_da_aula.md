
Para iniciar, crie o projeto Spring utilizando o site do [Spring Initializr](https://start.spring.io/) utilizando o Maven como gerenciador de dependências. Faça o download do projeto, descompacte-o e abra no IntelliJ. Aproveite para já criar os pacotes model e service.

No pacote service, crie a classe ConsumoAPI, com o método que irá retornar o json com o corpo da resposta obtida.

ConsumoApi.java:

```java
package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
```
Como precisaremos desserializar o JSON, inclua a dependência do Jackson no arquivo pom.xml:
```xml
<dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version>
        </dependency>
```
Agora com a dependência adicionada, dentro do pacote model, é necessário criar o record DadosSerie para modelar os dados que desejamos representar na aplicação:

DadosSerie.java:
```java
package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
}
```

Precisaremos desserializar os dados do JSON, representando-os como um objeto do tipo DadosSerie. Para isso, no pacote service vamos criar a interface IConverteDados e a classe ConverteDados que irá implementar o método descrito na mesma.

IConverteDados.java:
```java
package br.com.alura.screenmatch.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
```
ConverteDados.java:
```java
package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
```
Na classe principal do projeto, ScreenmatchApplication, faça a implementação da CommandLineRunner, sobrescrevendo o método run.

ScreenmatchApplication.java:
```java
package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
        System.out.println(json);
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);
    }
}

```