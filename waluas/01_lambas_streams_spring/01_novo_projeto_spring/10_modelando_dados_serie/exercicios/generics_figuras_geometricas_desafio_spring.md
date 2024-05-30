

Entendi! Vamos criar um exercício que evolui ao longo das etapas:Etapa 1 (Fácil):Crie duas classes, Retangulo e Circulo, cada uma com um método calcularArea que retorna a área do retângulo ou círculo.Etapa 2 (Intermediário):Perceba que os métodos calcularArea das classes Retangulo e Circulo são muito similares. Crie uma classe genérica chamada FormaGeometrica com um método genérico calcularArea que recebe como parâmetro a forma geométrica e retorna a área.Etapa 3 (Difícil):Crie uma interface genérica chamada Calculavel que define um método calcularArea. Faça com que as classes Retangulo e Circulo implementem essa interface.Desafio (Muito difícil):Utilize o Spring Boot para criar uma aplicação que implemente as classes e interfaces desenvolvidas nas etapas anteriores. Configure a aplicação para receber requisições HTTP e calcular a área de um retângulo ou círculo, utilizando os métodos genéricos e interfaces.

public class Retangulo {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public double calcularArea() {
        return altura * largura;
    }
}

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}