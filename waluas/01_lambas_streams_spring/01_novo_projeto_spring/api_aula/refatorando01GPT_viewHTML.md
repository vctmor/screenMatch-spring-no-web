Refatorar o código acima para seguir a arquitetura MVC (Model-View-Controller) implica dividir a lógica em três partes distintas:

1. **Model (Modelo):** Representa os dados e a lógica de negócios.
2. **View (Visão):** Trata da interface com o usuário.
3. **Controller (Controlador):** Gerencia a entrada do usuário e atualiza o modelo e a visão.

### Passo a Passo para a Refatoração

#### Passo 1: Definir o Modelo
Primeiro, crie uma classe para representar o modelo dos dados da série.

```java
public class DadosSerie {
    private String title;
    private String year;
    private String genre;
    // outros atributos...

    // getters e setters...
}
```

#### Passo 2: Criar a Classe de Serviço para Consumo da API
Crie uma classe de serviço que encapsula a lógica de consumo da API e a conversão dos dados.

```java
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SerieService {

    private static final String API_KEY = "6585022c";
    private static final String BASE_URL = "https://www.omdbapi.com/?t=%s&apikey=" + API_KEY;

    private final RestTemplate restTemplate;
    private final ConverteDados conversor;

    public SerieService(RestTemplate restTemplate, ConverteDados conversor) {
        this.restTemplate = restTemplate;
        this.conversor = conversor;
    }

    public DadosSerie obterDadosSerie(String nomeSerie) {
        String url = String.format(BASE_URL, nomeSerie.replace(" ", "+"));
        String json = restTemplate.getForObject(url, String.class);
        return conversor.obterDados(json, DadosSerie.class);
    }
}
```

#### Passo 3: Criar o Controlador
Crie um controlador para gerenciar as solicitações do usuário e interagir com a camada de serviço.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/buscar")
    public String buscarSerie(@RequestParam(name = "nome") String nome, Model model) {
        DadosSerie dadosSerie = serieService.obterDadosSerie(nome);
        model.addAttribute("dadosSerie", dadosSerie);
        return "resultado";
    }
}
```

#### Passo 4: Criar a View
Crie uma página HTML para o formulário de entrada e para exibir os resultados. Usaremos Thymeleaf como motor de templates.

**index.html (Formulário de Entrada):**

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Buscar Série</title>
</head>
<body>
    <h1>Buscar Série</h1>
    <form action="/buscar" method="get">
        <label for="nome">Nome da Série:</label>
        <input type="text" id="nome" name="nome">
        <button type="submit">Buscar</button>
    </form>
</body>
</html>
```

**resultado.html (Exibição dos Resultados):**

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Resultado da Busca</title>
</head>
<body>
    <h1>Resultado da Busca</h1>
    <div th:if="${dadosSerie != null}">
        <p><strong>Título:</strong> <span th:text="${dadosSerie.title}"></span></p>
        <p><strong>Ano:</strong> <span th:text="${dadosSerie.year}"></span></p>
        <p><strong>Gênero:</strong> <span th:text="${dadosSerie.genre}"></span></p>
        <!-- outros atributos... -->
    </div>
    <div th:if="${dadosSerie == null}">
        <p>Série não encontrada.</p>
    </div>
</body>
</html>
```

#### Passo 5: Configurar o RestTemplate
Adicione a configuração do `RestTemplate` em sua classe de configuração Spring.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

#### Passo 6: Ajustar a Classe Principal
Certifique-se de que a sua classe principal do Spring Boot esteja configurada corretamente.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### Conclusão
Com essa refatoração, o seu código agora segue a arquitetura MVC, separando claramente as responsabilidades e melhorando a organização e manutenção do código. A lógica de consumo de API e conversão de dados está encapsulada no serviço, a entrada do usuário é tratada pelo controlador, e a interface com o usuário é gerenciada pelas views.