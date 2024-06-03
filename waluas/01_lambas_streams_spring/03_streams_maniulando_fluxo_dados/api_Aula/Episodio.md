
# Classe Episodio

A classe `Episodio` representa um episódio de uma série de TV, contendo informações detalhadas sobre o episódio, como temporada, título, número do episódio, avaliação e data de lançamento. Suas responsabilidades incluem:

1. **Armazenamento de Dados**:
    - Armazenar o número da temporada, título do episódio, número do episódio, avaliação (em formato `Double`) e data de lançamento (em formato `LocalDate`).

2. **Construção do Objeto**:
    - Construtor que inicializa os campos da classe usando um objeto `DadosEpisodio`, realizando conversões necessárias para os tipos de dados apropriados (`Double` para avaliação e `LocalDate` para data de lançamento).

3. **Manipulação de Dados**:
    - Métodos `get` e `set` para cada campo, permitindo o acesso e modificação dos dados armazenados.

4. **Tratamento de Exceções**:
    - Tratamento de exceções durante a conversão de tipos para garantir que a avaliação e a data de lançamento sejam corretamente atribuídas ou definidas com valores padrão/null em caso de erro.

5. **Representação em String**:
    - Método `toString` sobrescrito para fornecer uma representação textual completa do objeto `Episodio`, útil para depuração e exibição de informações.

### 1) Diagrama UML e Explicação

```plaintext
+----------------------+
|      Episodio        |
+----------------------+
| - temporada: Integer |
| - titulo: String     |
| - numeroEpisodio: Integer |
| - avaliacao: Double  |
| - dataLancamento: LocalDate |
+----------------------+
| + Episodio(numeroTemporada: Integer, dadosEpisodio: DadosEpisodio) |
| + getTemporada(): Integer |
| + setTemporada(temporada: Integer): void |
| + getTitulo(): String |
| + setTitulo(titulo: String): void |
| + getNumeroEpisodio(): Integer |
| + setNumeroEpisodio(numeroEpisodio: Integer): void |
| + getAvaliacao(): Double |
| + setAvaliacao(avaliacao: Double): void |
| + getDataLancamento(): LocalDate |
| + setDataLancamento(dataLancamento: LocalDate): void |
| + toString(): String |
+----------------------+
```

#### Explicação do Diagrama UML:

- **Classe `Episodio`:**
    - **Atributos privados:**
        - `temporada`: Número da temporada.
        - `titulo`: Título do episódio.
        - `numeroEpisodio`: Número do episódio na temporada.
        - `avaliacao`: Avaliação do episódio.
        - `dataLancamento`: Data de lançamento do episódio.
    - **Construtor:**
        - `Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio)`: Inicializa os atributos da classe a partir dos parâmetros recebidos.
    - **Métodos públicos de acesso e modificação (getters e setters):**
        - Métodos para obter e definir os valores dos atributos.
    - **Método `toString`:**
        - Retorna uma representação em string dos valores dos atributos.

### 2.0) Para implementar

Claro! Vou adicionar os checkboxes em Markdown para cada linha do código. Aqui está:

Claro! Vou reorganizar o código para que você possa clicar de maneira iterativa. Aqui está:

Aqui está a lista com checkboxes adicionados para que você possa marcar à medida que for avançando:

Se você quer criar uma lista de tarefas em um arquivo Markdown, você pode usar a sintaxe de caixas de seleção do Markdown para marcar o progresso. Aqui está como você pode transformar sua lista de tarefas em uma lista de verificação Markdown:


# Lista de Tarefas

- [ ] Define a classe Episodio
- [ ] Declara um campo privado 'temporada' do tipo Integer
- [ ] Declara um campo privado 'titulo' do tipo String
- [ ] Declara um campo privado 'numeroEpisodio' do tipo Integer
- [ ] Declara um campo privado 'avaliacao' do tipo Double
- [ ] Declara um campo privado 'dataLancamento' do tipo LocalDate
- [ ] Construtor que recebe dois parâmetros: 
  - [ ] 'numeroTemporada' e 'dadosEpisodio'
- [ ] Inicializa o campo 'temporada' com o valor de 'numeroTemporada'
- [ ] Inicializa o campo 'titulo' com o valor retornado pelo método 'titulo' de 'dadosEpisodio'
- [ ] Inicializa o campo 'numeroEpisodio' com o valor retornado pelo método 'numero' de 'dadosEpisodio'
- [ ] Início de um bloco de tratamento de exceção para conversão de string para Double
- [ ] Converte a string retornada pelo método 'avaliacao' de 'dadosEpisodio' para Double e inicializa o campo 'avaliacao'
- [ ] Captura a exceção 'NumberFormatException' caso a conversão falhe
- [ ] Define 'avaliacao' como 0.0 em caso de exceção
- [ ] Início de um bloco de tratamento de exceção para conversão de string para LocalDate
- [ ] Converte a string retornada pelo método 'dataLancamento' de 'dadosEpisodio' para LocalDate e inicializa o campo 'dataLancamento'
- [ ] Captura a exceção 'DateTimeParseException' caso a conversão falhe
- [ ] Define 'dataLancamento' como null em caso de exceção
- [ ] Método público que retorna o valor do campo 'temporada'
- [ ] Método público que define o valor do campo 'temporada'
- [ ] Método público que retorna o valor do campo 'titulo'
- [ ] Método público que define o valor do campo 'titulo'
- [ ] Método público que retorna o valor do campo 'numeroEpisodio'
- [ ] Método público que define o valor do campo 'numeroEpisodio'
- [ ] Método público que retorna o valor do campo 'avaliacao'
- [ ] Método público que define o valor do campo 'avaliacao'
- [ ] Método público que retorna o valor do campo 'dataLancamento'
- [ ] Método público que define o valor do campo 'dataLancamento'
- [ ] Anotação que indica que o método sobrescreve um método da superclasse
- [ ] Método que retorna uma representação em string do objeto
- [ ] Concatena os valores dos campos e os retorna como uma string



```plaintext
// Define a classe Episodio

// Declara um campo privado 'temporada' do tipo Integer

// Declara um campo privado 'titulo' do tipo String

// Declara um campo privado 'numeroEpisodio' do tipo Integer

// Declara um campo privado 'avaliacao' do tipo Double

// Declara um campo privado 'dataLancamento' do tipo LocalDate

// Construtor que recebe dois parâmetros: 
// 'numeroTemporada' e 'dadosEpisodio'

// Inicializa o campo 'temporada' com o valor de 'numeroTemporada'

// Inicializa o campo 'titulo' com o valor retornado pelo método 'titulo' de 'dadosEpisodio'

// Inicializa o campo 'numeroEpisodio' com o valor retornado pelo método 'numero' de 'dadosEpisodio'

// Início de um bloco de tratamento de exceção para conversão de string para Double

// Converte a string retornada pelo método 'avaliacao' de 'dadosEpisodio' para Double e inicializa o campo 'avaliacao'

// Captura a exceção 'NumberFormatException' caso a conversão falhe

// Define 'avaliacao' como 0.0 em caso de exceção

// Início de um bloco de tratamento de exceção para conversão de string para LocalDate

// Converte a string retornada pelo método 'dataLancamento' de 'dadosEpisodio' para LocalDate e inicializa o campo 'dataLancamento'

// Captura a exceção 'DateTimeParseException' caso a conversão falhe

// Define 'dataLancamento' como null em caso de exceção

// Método público que retorna o valor do campo 'temporada'

// Método público que define o valor do campo 'temporada'

// Método público que retorna o valor do campo 'titulo'

// Método público que define o valor do campo 'titulo'

// Método público que retorna o valor do campo 'numeroEpisodio'

// Método público que define o valor do campo 'numeroEpisodio'

// Método público que retorna o valor do campo 'avaliacao'

// Método público que define o valor do campo 'avaliacao'

// Método público que retorna o valor do campo 'dataLancamento'

// Método público que define o valor do campo 'dataLancamento'

// Anotação que indica que o método sobrescreve um método da superclasse

// Método que retorna uma representação em string do objeto

// Concatena os valores dos campos e os retorna como uma string
```


### 2.1) Comentário Linha a Linha

```java
public class Episodio { 
    // Define a classe Episodio

    private Integer temporada; 
    // Declara um campo privado 'temporada' do tipo Integer

    private String titulo; 
    // Declara um campo privado 'titulo' do tipo String

    private Integer numeroEpisodio; 
    // Declara um campo privado 'numeroEpisodio' do tipo Integer

    private Double avaliacao; 
    // Declara um campo privado 'avaliacao' do tipo Double

    private LocalDate dataLancamento; 
    // Declara um campo privado 'dataLancamento' do tipo LocalDate

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) { 
        // Construtor que recebe dois parâmetros: 'numeroTemporada' e 'dadosEpisodio'

        this.temporada = numeroTemporada; 
        // Inicializa o campo 'temporada' com o valor de 'numeroTemporada'

        this.titulo = dadosEpisodio.titulo(); 
        // Inicializa o campo 'titulo' com o valor retornado pelo método 'titulo' de 'dadosEpisodio'

        this.numeroEpisodio = dadosEpisodio.numero(); 
        // Inicializa o campo 'numeroEpisodio' com o valor retornado pelo método 'numero' de 'dadosEpisodio'

        try { 
            // Início de um bloco de tratamento de exceção para conversão de string para Double

            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao()); 
            // Converte a string retornada pelo método 'avaliacao' de 'dadosEpisodio' para Double e inicializa o campo 'avaliacao'

        } catch (NumberFormatException ex) { 
            // Captura a exceção 'NumberFormatException' caso a conversão falhe

            this.avaliacao = 0.0; 
            // Define 'avaliacao' como 0.0 em caso de exceção
        }

        try { 
            // Início de um bloco de tratamento de exceção para conversão de string para LocalDate

            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento()); 
            // Converte a string retornada pelo método 'dataLancamento' de 'dadosEpisodio' para LocalDate e inicializa o campo 'dataLancamento'

        } catch (DateTimeParseException ex) { 
            // Captura a exceção 'DateTimeParseException' caso a conversão falhe

            this.dataLancamento = null; 
            // Define 'dataLancamento' como null em caso de exceção
        }
    }

    public Integer getTemporada() { 
        // Método público que retorna o valor do campo 'temporada'
        return temporada; 
    }

    public void setTemporada(Integer temporada) { 
        // Método público que define o valor do campo 'temporada'
        this.temporada = temporada; 
    }

    public String getTitulo() { 
        // Método público que retorna o valor do campo 'titulo'
        return titulo; 
    }

    public void setTitulo(String titulo) { 
        // Método público que define o valor do campo 'titulo'
        this.titulo = titulo; 
    }

    public Integer getNumeroEpisodio() { 
        // Método público que retorna o valor do campo 'numeroEpisodio'
        return numeroEpisodio; 
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) { 
        // Método público que define o valor do campo 'numeroEpisodio'
        this.numeroEpisodio = numeroEpisodio; 
    }

    public Double getAvaliacao() { 
        // Método público que retorna o valor do campo 'avaliacao'
        return avaliacao; 
    }

    public void setAvaliacao(Double avaliacao) { 
        // Método público que define o valor do campo 'avaliacao'
        this.avaliacao = avaliacao; 
    }

    public LocalDate getDataLancamento() { 
        // Método público que retorna o valor do campo 'dataLancamento'
        return dataLancamento; 
    }

    public void setDataLancamento(LocalDate dataLancamento) { 
        // Método público que define o valor do campo 'dataLancamento'
        this.dataLancamento = dataLancamento; 
    }

    @Override 
    // Anotação que indica que o método sobrescreve um método da superclasse

    public String toString() { 
        // Método que retorna uma representação em string do objeto
        return "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento; 
                // Concatena os valores dos campos e os retorna como uma string
    }
}
```