Para refatorar o código conforme a arquitetura MVC (Model-View-Controller) e adicionar um prompt para receber o título do filme, precisamos reorganizar o código para separar claramente as responsabilidades. Vamos seguir um passo a passo:

### 1. Estrutura do Projeto

Primeiro, definimos a estrutura do projeto para seguir a arquitetura MVC:

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

### 2. Model

A classe `DadosSerie` já está definida e permanece a mesma.

### 3. Service

Refatoramos as classes `ConsumoApi` e `ConverteDados` para serem usadas como serviços.

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

### 4. Controller

Criamos um `MovieController` que gerencia a lógica de entrada do usuário e a interação com os serviços.

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

### 5. Main Application

Atualizamos a classe principal para chamar o `MovieController`.

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

### Passo a Passo

1. **Crie a Estrutura do Projeto:**
    - Separe o código em pacotes: `controller`, `model`, `service`.

2. **Refatore os Serviços:**
    - Mova a lógica de consumo da API e conversão de dados para classes de serviço.

3. **Implemente o Controlador:**
    - Adicione a lógica para receber a entrada do usuário e interagir com os serviços.

4. **Atualize a Classe Principal:**
    - Chame o controlador na classe principal para iniciar o prompt do usuário.

### Arquivos Finais

#### MainApplication.java

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

#### MovieController.java

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

#### ConsumoApi.java

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

#### ConverteDados.java

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

### Resumo

Essa refatoração segue a arquitetura MVC, separando claramente a lógica de controle, o serviço e o modelo. Além disso, permite que o usuário insira dinamicamente o título do filme ou série, tornando o código mais modular e testável.