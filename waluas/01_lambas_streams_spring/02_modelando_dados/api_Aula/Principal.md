### 1) Explicação Didática

A classe `Principal` é um programa em Java que interage com uma API de dados de séries (OMDB API) para obter informações sobre uma série específica e suas temporadas e episódios.

#### Componentes da Classe:

1. **Atributos:**
    - `Scanner leitura`: Um objeto `Scanner` para ler a entrada do usuário a partir do console.
    - `ConsumoApi consumo`: Um objeto da classe `ConsumoApi`, usado para fazer requisições HTTP e obter dados da API.
    - `ConverteDados conversor`: Um objeto da classe `ConverteDados`, usado para converter o JSON retornado pela API em objetos Java.
    - `ENDERECO`: Uma constante que contém a URL base da API.
    - `API_KEY`: Uma constante que contém a chave da API necessária para autenticação.

2. **Método `exibeMenu()`:**
    - Exibe um menu solicitando ao usuário que insira o nome de uma série.
    - Lê o nome da série digitado pelo usuário.
    - Faz uma requisição à API para obter dados da série e converte o JSON retornado em um objeto `DadosSerie`.
    - Imprime as informações da série.
    - Cria uma lista para armazenar os dados das temporadas.
    - Faz uma requisição à API para cada temporada da série, convertendo o JSON retornado em objetos `DadosTemporada` e adicionando-os à lista de temporadas.
    - Imprime as informações de cada temporada.
    - Itera sobre cada temporada e cada episódio dentro de cada temporada, imprimindo os títulos dos episódios.

### 2) Diagrama UML

```plaintext
+-------------------------------+
|          Principal            |
|-------------------------------|
| - leitura: Scanner            |
| - consumo: ConsumoApi         |
| - conversor: ConverteDados    |
| - ENDERECO: String            |
| - API_KEY: String             |
|-------------------------------|
| + exibeMenu(): void           |
+-------------------------------+
```

#### Explicação do Diagrama UML:

- **Classe `Principal`:**
    - Contém cinco atributos privados (`leitura`, `consumo`, `conversor`, `ENDERECO`, `API_KEY`).
    - Contém um método público `exibeMenu()` que realiza a lógica principal do programa.

### 3) Pseudocódigo Comentado

```plaintext
// Classe Principal
class Principal {

    // Inicializa um Scanner para ler entrada do usuário
    leitura = criar Scanner(System.in)

    // Inicializa um objeto ConsumoApi para fazer requisições à API
    consumo = criar ConsumoApi()

    // Inicializa um objeto ConverteDados para converter JSON em objetos Java
    conversor = criar ConverteDados()

    // Define a URL base da API
    ENDERECO = "https://www.omdbapi.com/?t="

    // Define a chave da API para autenticação
    API_KEY = "&apikey=6585022c"

    // Método que exibe o menu e executa a lógica principal
    metodo exibeMenu() {
        // Exibe mensagem pedindo o nome da série
        imprimir "Digite o nome da série para busca"

        // Lê o nome da série digitado pelo usuário
        nomeSerie = leitura.nextLine()

        // Faz requisição à API para obter dados da série
        json = consumo.obterDados(ENDERECO + substituirEspacos(nomeSerie) + API_KEY)

        // Converte o JSON retornado em um objeto DadosSerie
        dados = conversor.obterDados(json, DadosSerie.class)

        // Imprime os dados da série
        imprimir dados

        // Cria uma lista para armazenar os dados das temporadas
        temporadas = criar ArrayList<DadosTemporada>()

        // Para cada temporada da série
        para i de 1 até dados.totalTemporadas() {
            // Faz requisição à API para obter dados da temporada
            json = consumo.obterDados(ENDERECO + substituirEspacos(nomeSerie) + "&season=" + i + API_KEY)

            // Converte o JSON retornado em um objeto DadosTemporada
            dadosTemporada = conversor.obterDados(json, DadosTemporada.class)

            // Adiciona os dados da temporada à lista
            temporadas.adicionar(dadosTemporada)
        }

        // Imprime os dados de cada temporada
        temporadas.paraCada(imprimir)

        // Itera sobre cada temporada e imprime os títulos dos episódios
        temporadas.paraCada(temporada -> {
            temporada.episodios().paraCada(episodio -> {
                imprimir episodio.titulo()
            })
        })
    }

    // Substitui espaços por "+"
    metodo substituirEspacos(texto) {
        retornar texto.replace(" ", "+")
    }
}
```

Neste pseudocódigo, tentamos manter a estrutura do programa, incluindo a leitura da entrada do usuário, a realização de requisições à API, a conversão do JSON em objetos Java e a impressão das informações resultantes.