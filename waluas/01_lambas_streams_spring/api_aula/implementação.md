### 1) Explicação Passo a Passo do Funcionamento da Classe `ConsumoApi`

#### Objetivo:
A classe `ConsumoApi` tem como objetivo obter dados de uma API via HTTP, retornando o corpo da resposta como uma string.

#### Passos de Implementação:

1. **Método `obterDados`:**
   - **Parâmetro:** Recebe um parâmetro `endereco` do tipo `String`, que representa o URL da API a ser consumida.
   - **Cliente HTTP:** Cria um cliente HTTP usando `HttpClient.newHttpClient()`.
   - **Requisição HTTP:** Constrói uma requisição HTTP utilizando `HttpRequest.newBuilder()` e define o URI com `URI.create(endereco)`. A requisição é então construída com `build()`.
   - **Inicialização da Resposta:** Declara uma variável `response` do tipo `HttpResponse<String>` e inicializa como `null`.
   - **Envio da Requisição:** Utiliza um bloco `try-catch` para enviar a requisição e obter a resposta. O método `send()` do cliente HTTP é utilizado com `request` e `HttpResponse.BodyHandlers.ofString()` para lidar com o corpo da resposta como uma string.
   - **Tratamento de Exceções:** Captura exceções `IOException` e `InterruptedException`, lançando uma `RuntimeException` em ambos os casos.
   - **Retorno da Resposta:** Extrai o corpo da resposta com `response.body()` e o armazena em uma variável `json`. Retorna a string `json`.

### 2) Pseudocódigo

```plaintext
Classe ConsumoApi

    Método obterDados(endereco: String) : String
        Cria cliente HTTP
        Constrói requisição HTTP com URI fornecido (endereco)
        Declara variável response do tipo HttpResponse<String> como nula

        Tenta:
            Envia a requisição HTTP e obtém a resposta
        Captura IOException:
            Lança RuntimeException
        Captura InterruptedException:
            Lança RuntimeException

        Extrai o corpo da resposta como string (json)
        Retorna json
```

### 3) Diagrama UML

```plaintext
+--------------------------------------+
|             ConsumoApi               |
+--------------------------------------+
| + obterDados(endereco: String) : String |
+--------------------------------------+
```

#### Descrição do Diagrama UML:
- **Classe `ConsumoApi`:**
  - **Método Público:**
    - `obterDados(endereco: String) : String`: Método que recebe um URL, realiza uma requisição HTTP e retorna o corpo da resposta como uma string.

### 1) Explicação Passo a Passo do Funcionamento da Classe `DadosSerie`

#### Objetivo:
A classe `DadosSerie` é uma classe de registro (record class) em Java que serve para armazenar dados de uma série, como título, número total de temporadas e avaliação no IMDb. Ela usa anotações da biblioteca Jackson para mapear os campos JSON aos campos da classe.

#### Passos de Implementação:

1. **Anotação `@JsonIgnoreProperties`:**
   - A anotação `@JsonIgnoreProperties(ignoreUnknown = true)` é utilizada para ignorar quaisquer propriedades desconhecidas no JSON ao desserializar um objeto. Isso permite que o JSON contenha propriedades que não estão definidas na classe `DadosSerie` sem causar erros.

2. **Definição da Classe Record:**
   - A classe `DadosSerie` é definida como uma record class, que é um tipo especial de classe em Java destinada a armazenar dados de forma imutável e fornecer uma sintaxe concisa para criação de classes de dados.
   
3. **Definição dos Campos:**
   - A classe define três campos: `titulo` (String), `totalTemporadas` (Integer) e `avaliacao` (String).
   - Cada campo é anotado com `@JsonAlias` para mapear nomes alternativos no JSON:
     - `@JsonAlias("Title")`: O campo `titulo` será mapeado a partir da propriedade `Title` no JSON.
     - `@JsonAlias("totalSeasons")`: O campo `totalTemporadas` será mapeado a partir da propriedade `totalSeasons` no JSON.
     - `@JsonAlias("imdbRating")`: O campo `avaliacao` será mapeado a partir da propriedade `imdbRating` no JSON.

### 2) Pseudocódigo

```plaintext
// Definição da classe de registro com anotações para mapeamento JSON
Classe DadosSerie {

    // Ignorar propriedades desconhecidas no JSON
    @JsonIgnoreProperties(ignoreUnknown = true)
    
    // Campos do registro com alias para mapeamento JSON
    String titulo;         // @JsonAlias("Title")
    Integer totalTemporadas; // @JsonAlias("totalSeasons")
    String avaliacao;      // @JsonAlias("imdbRating")
    
    //--------------------> para um projeto mair

    // Construtor para inicializar todos os campos
    DadosSerie(String titulo, Integer totalTemporadas, String avaliacao) {
        this.titulo = titulo;
        this.totalTemporadas = totalTemporadas;
        this.avaliacao = avaliacao;
    }
    
    // Métodos getters gerados automaticamente
    String getTitulo() {
        return this.titulo;
    }
    
    Integer getTotalTemporadas() {
        return this.totalTemporadas;
    }
    
    String getAvaliacao() {
        return this.avaliacao;
    }
}

```

### 3) Diagrama UML

```plaintext
+---------------------------------------+
|              DadosSerie               |
|---------------------------------------|
| - titulo: String                      |
| - totalTemporadas: Integer            |
| - avaliacao: String                   |
+---------------------------------------+
| + DadosSerie(titulo: String,          |
|              totalTemporadas: Integer,|
|              avaliacao: String)       |
| + getTitulo() : String                |
| + getTotalTemporadas() : Integer      |
| + getAvaliacao() : String             |
+---------------------------------------+
<<record>>
```

#### Descrição do Diagrama UML:
- **Classe `DadosSerie`:**
  - **Campos Privados:**
    - `titulo`: Armazena o título da série (mapeado a partir de "Title" no JSON).
    - `totalTemporadas`: Armazena o total de temporadas da série (mapeado a partir de "totalSeasons" no JSON).
    - `avaliacao`: Armazena a avaliação da série no IMDb (mapeado a partir de "imdbRating" no JSON).
  - **Métodos:**
    - `DadosSerie(titulo: String, totalTemporadas: Integer, avaliacao: String)`: Construtor para inicializar os campos.
    - Métodos getters gerados automaticamente para cada campo.

Este diagrama UML e pseudocódigo fornecem uma visão clara da estrutura e funcionamento da classe `DadosSerie` e como os campos JSON são mapeados para os campos da classe através das anotações Jackson.

### 1) Explicação Passo a Passo do Funcionamento de Cada Classe

#### a) `IConverteDados`

- **Definição da Interface:**
  - A interface `IConverteDados` define um contrato para classes que implementarão a conversão de dados JSON para objetos Java.
  
- **Método `obterDados`:**
  - O método genérico `<T> T obterDados(String json, Class<T> classe)` é declarado. 
  - Este método aceita dois parâmetros:
    - `json`: Uma string contendo dados em formato JSON.
    - `classe`: A classe para a qual os dados JSON devem ser convertidos.
  - O método retorna um objeto do tipo `T`.

#### b) `ConverteDados`

- **Implementação da Interface `IConverteDados`:**
  - A classe `ConverteDados` implementa a interface `IConverteDados`.

- **Campo `mapper`:**
  - Um objeto `ObjectMapper` da biblioteca Jackson é instanciado. Ele é usado para realizar a conversão de dados JSON para objetos Java.

- **Método `obterDados`:**
  - O método `obterDados` é implementado conforme definido na interface.
  - Utiliza o `ObjectMapper` para converter o JSON em um objeto da classe especificada.
  - Em caso de exceção (`JsonProcessingException`), a exceção é capturada e lançada como uma `RuntimeException`.

### 2) Pseudocódigo

```plaintext
# Definição da interface IConverteDados
interface IConverteDados {
    # Método genérico para obter dados
    obterDados(json, classe);
}

# Definição da classe ConverteDados que implementa IConverteDados
class ConverteDados {
    
    # Instanciação do ObjectMapper
    var mapper = new ObjectMapper();
    
    # Implementação do método obterDados
    function obterDados(json, classe) {
        try {
            # Converte JSON para objeto da classe especificada
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            # Lança exceção em caso de erro
            throw new RuntimeException(e);
        }
    }
}
```

### 3) Diagrama UML das Classes em Conjunto

```plaintext
+--------------------------+             +----------------------------+
|    <<interface>>         |             |         ConverteDados      |
|    IConverteDados        |             |----------------------------|
|--------------------------|<----        | - mapper: ObjectMapper     |
| + obterDados(json: String,             |----------------------------|
|   classe: Class<T>): T                 | + obterDados(json: String, |
|--------------------------|             |   classe: Class<T>): T     |
+--------------------------+             +----------------------------+
```

#### Descrição do Diagrama UML:

- **IConverteDados:**
  - Interface com um método genérico `obterDados` que converte uma string JSON para um objeto da classe especificada.
  
- **ConverteDados:**
  - Classe que implementa a interface `IConverteDados`.
  - Contém um campo `mapper` do tipo `ObjectMapper`.
  - Implementa o método `obterDados`, utilizando o `ObjectMapper` para converter JSON em objetos Java.