Claro! Vamos adicionar explicações, pseudocódigo e instruções de implementação antes de cada classe.

### Estrutura do Projeto

Para seguir a arquitetura MVC, a estrutura do projeto será:

```
src/main/java/com/example/project/
├── controller/
│   └── MovieController.java
├── model/
│   └── DadosSerie.java
├── service/
│   ├── ConsumoApi.java
│   └── ConverteDados.java
└── MainApplication.java
```

### 1. MainApplication.java

#### Explicação
A classe `MainApplication` é a classe principal do Spring Boot. Ela configura e inicia a aplicação. Além disso, implementa a interface `CommandLineRunner` para executar o código de inicialização após a aplicação ser lançada.

#### Pseudocódigo
```
Classe MainApplication
  Atributo: movieController

  Método main
    Inicializa a aplicação Spring Boot

  Método run
    Chama o método promptUser do movieController
```

#### Implementação
```java
package com.example.project;

import com.example.project.controller.MovieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private MovieController movieController;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        movieController.promptUser();
    }
}
```

### 2. MovieController.java

#### Explicação
A classe `MovieController` é responsável por interagir com o usuário e gerenciar a lógica de entrada de dados. Ela solicita ao usuário que insira o título do filme ou série, monta a URL de consulta, consome a API e converte os dados JSON recebidos.

#### Pseudocódigo
```
Classe MovieController
  Atributo: consumoApi
  Atributo: converteDados
  Constante: API_KEY

  Método promptUser
    Solicita ao usuário que insira o título do filme ou série
    Monta a URL de consulta
    Tenta obter dados da API e convertê-los
    Se sucesso, exibe os dados
    Se erro, exibe mensagem de erro
```

#### Implementação
```java
package com.example.project.controller;

import com.example.project.model.DadosSerie;
import com.example.project.service.ConsumoApi;
import com.example.project.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {

    @Autowired
    private ConsumoApi consumoApi;

    @Autowired
    private ConverteDados converteDados;

    private final String API_KEY = "6585022c";

    public void promptUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do filme ou série: ");
        String title = scanner.nextLine();

        String url = String.format("https://www.omdbapi.com/?t=%s&apikey=%s", title.replace(" ", "+"), API_KEY);

        try {
            String json = consumoApi.obterDados(url);
            DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);

            System.out.println("Conteúdo do json: " + json + "\n");
            System.out.println("Conteúdo os dados: " + dados);
        } catch (Exception e) {
            System.err.println("Erro ao obter ou converter os dados: " + e.getMessage());
        }
    }
}
```

### 3. ConsumoApi.java

#### Explicação
A classe `ConsumoApi` é responsável por consumir a API externa. Ela contém um método que faz uma solicitação HTTP GET à URL fornecida e retorna a resposta como uma string JSON.

#### Pseudocódigo
```
Classe ConsumoApi

  Método obterDados(url)
    Cria uma instância de RestTemplate
    Faz uma solicitação HTTP GET à URL fornecida
    Retorna a resposta como string
```

#### Implementação
```java
package com.example.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumoApi {

    public String obterDados(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
```

### 4. ConverteDados.java

#### Explicação
A classe `ConverteDados` é responsável por converter a string JSON recebida em um objeto Java. Ela utiliza a biblioteca Jackson para mapear o JSON para uma instância da classe especificada.

#### Pseudocódigo
```
Classe ConverteDados

  Método obterDados(json, clazz)
    Cria uma instância de ObjectMapper
    Converte a string JSON em um objeto da classe especificada
    Retorna o objeto convertido
```

#### Implementação
```java
package com.example.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConverteDados {

    public <T> T obterDados(String json, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
```

### 5. DadosSerie.java

#### Explicação
A classe `DadosSerie` representa o modelo de dados da série ou filme. Ela contém os campos necessários para armazenar os dados recebidos da API.

#### Pseudocódigo
```
Classe DadosSerie
  Atributos: titulo, ano, etc. (de acordo com os dados recebidos da API)
```

#### Implementação
Aqui, vou assumir alguns atributos comuns que podem estar presentes nos dados da série:

```java
package com.example.project.model;

public class DadosSerie {
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;

    // Getters e Setters

    @Override
    public String toString() {
        return "Title: " + Title + ", Year: " + Year + ", Genre: " + Genre + 
               ", Director: " + Director + ", Actors: " + Actors + ", Plot: " + Plot;
    }
}
```

### Resumo

Seguindo o passo a passo acima, você consegue refatorar o código original de acordo com a arquitetura MVC, além de adicionar um prompt para receber o título do filme ou série do usuário. Cada componente é responsável por uma parte específica da aplicação, promovendo uma melhor organização e manutenibilidade do código.