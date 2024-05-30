Para refatorar o código seguindo a arquitetura MVC e torná-lo mais eficiente, você pode seguir os passos abaixo:

1. **Modelo (Model):**
    - Crie uma classe `Filme` para representar os dados do filme.
    - Crie uma classe `ApiService` que será responsável por interagir com a API externa.

2. **Visão (View):**
    - Crie uma classe `View` que será responsável por interagir com o usuário, como receber o título do filme e exibir os resultados.

3. **Controlador (Controller):**
    - Crie uma classe `Controller` que será a ponte entre o `Model` e a `View`. Ela irá processar as entradas do usuário e atualizar a `View`.

4. **Refatoração do código:**
    - Remova as URLs codificadas e substitua-as por uma função que construa a URL com base no título do filme.
    - Use um loop ou uma função que possa lidar com múltiplos títulos de filmes, evitando repetições.

Aqui está um exemplo de como o código refatorado poderia parecer:

```java
public class Filme {
    // Atributos do filme
}

public class ApiService {
    private static final String API_KEY = "6585022c";
    private static final String BASE_URL = "https://www.omdbapi.com/?";

    public String obterDados(String titulo) {
        String endereco = BASE_URL + "t=" + titulo + "&apikey=" + API_KEY;
        // Lógica para consumir a API
        return "json"; // Substitua isso pelo JSON real obtido da API
    }
}

public class View {
    public String receberTitulo() {
        // Lógica para receber o título do filme do usuário
        return "titulo"; // Substitua isso pelo título real
    }

    public void exibirDados(String dados) {
        System.out.println("Conteúdo dos dados: " + dados);
    }
}

public class Controller {
    private ApiService apiService;
    private View view;

    public Controller(ApiService apiService, View view) {
        this.apiService = apiService;
        this.view = view;
    }

    public void buscarFilme() {
        String titulo = view.receberTitulo();
        String json = apiService.obterDados(titulo);
        view.exibirDados(json);
    }
}

public class Main {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        View view = new View();
        Controller controller = new Controller(apiService, view);

        controller.buscarFilme();
    }
}
```

Este exemplo é apenas um esboço e precisará ser completado com a lógica específica para interagir com a API, converter os dados JSON e interagir com o usuário. Lembre-se de testar cada parte do código separadamente para garantir que tudo funcione como esperado.