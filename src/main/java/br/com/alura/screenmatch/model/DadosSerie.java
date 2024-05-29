package br.com.alura.screenmatch.model;

// ignorar propriedades desconhecidas no json
@JsonIgnoreProperties(ignoreUnknow = true) 
 // campos do registro com alias para mapeamento json
public record DadosSerie(@JsonAlias("title") String titulo, 
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imbRating") String avaliacao) {

   

}
