# configurando ambiente de teste e testando a classe ApiService


## Para configurar o ambiente de teste para a classe `ApiService`, você pode seguir os seguintes passos:

1. **Adicione as Dependências de Teste:**
    - Certifique-se de que seu projeto inclua as dependências necessárias para JUnit e Mockito (ou outro framework de mock que você escolher).

2. **Configure o Projeto:**
    - Se estiver usando uma IDE como IntelliJ IDEA ou Eclipse, configure o projeto para reconhecer o diretório de testes e as bibliotecas de teste.

3. **Crie o Diretório de Testes:**
    - Crie um diretório separado para os testes, geralmente chamado de `test`, no mesmo nível do diretório `src` do seu projeto.

4. **Escreva os Testes:**
    - Dentro do diretório de testes, crie uma nova classe de teste para a `ApiService`.
    - Escreva métodos de teste que cubram diferentes cenários, como respostas bem-sucedidas e falhas na chamada da API.

5. **Mock de Serviços Externos:**
    - Use Mockito para criar mocks dos serviços externos que a `ApiService` depende, como o cliente HTTP.

6. **Execute os Testes:**
    - Use a funcionalidade de teste da sua IDE ou execute os testes via linha de comando, por exemplo, usando Maven ou Gradle.

7. **Verifique os Resultados:**
    - Após executar os testes, verifique se todos passaram e se os casos de teste cobrem adequadamente o comportamento da `ApiService`.

Aqui está um exemplo de como adicionar as dependências de JUnit e Mockito usando Maven no seu arquivo `pom.xml`:

```xml
<dependencies>
    <!-- Outras dependências do projeto -->

    <!-- JUnit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>3.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

E aqui está um exemplo de como você pode executar os testes usando Maven:

```shell
mvn test
```

Certifique-se de que o ambiente de teste esteja corretamente configurado antes de começar a escrever os testes. Isso inclui ter a versão correta do Java instalada e configurada, bem como qualquer outra ferramenta ou biblioteca necessária para o desenvolvimento e teste do seu projeto. Além disso, é importante manter os testes atualizados à medida que você continua a desenvolver e refatorar sua classe `ApiService`.

## Para testar a classe `ApiService`, você pode seguir os seguintes passos:

1. **Escreva Testes Unitários:**
    - Utilize uma framework de testes como JUnit para escrever testes unitários.
    - Crie métodos de teste que verifiquem se a `ApiService` está retornando os dados corretos para diferentes títulos de filmes.

2. **Mock de Dependências:**
    - Como a `ApiService` depende de uma API externa, você pode usar um framework de mock como Mockito para simular as respostas da API.
    - Isso permite que você teste a `ApiService` sem fazer chamadas reais à API, o que é mais rápido e não depende da disponibilidade da API externa.

3. **Verificação de Exceções:**
    - Teste como a `ApiService` lida com erros, como uma resposta inválida da API ou problemas de conexão.

4. **Testes de Integração:**
    - Além dos testes unitários, você pode escrever testes de integração que realmente façam chamadas à API externa para garantir que a integração está funcionando como esperado.

Aqui está um exemplo básico de como você pode escrever um teste unitário para a classe `ApiService` usando JUnit e Mockito:

```java
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ApiServiceTest {

    @Mock
    private HttpClient httpClient; // Substitua HttpClient pela sua classe de cliente HTTP real

    @InjectMocks
    private ApiService apiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObterDados() throws Exception {
        String titulo = "gilmore girls";
        String jsonEsperado = "{\"Title\":\"Gilmore Girls\",\"Year\":\"2000–2007\",\"...\":\"...\"}";
        
        when(httpClient.get(anyString())).thenReturn(jsonEsperado); // Substitua get pelo método real de chamada HTTP

        String jsonResultado = apiService.obterDados(titulo);

        assertEquals(jsonEsperado, jsonResultado);
    }
}
```

Lembre-se de substituir `HttpClient` pela sua classe de cliente HTTP real e ajustar o método de mock (`get`) para corresponder ao método que você usa para fazer chamadas HTTP na sua `ApiService`. Além disso, você precisará adicionar as dependências corretas para JUnit e Mockito no seu projeto para que o código acima funcione.