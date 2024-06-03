package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// ignorar propriedades desconhecidas no json
@JsonIgnoreProperties(ignoreUnknown = true)
 // campos do registro com alias para mapeamento json
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("Actors") String elenco,
                         @JsonAlias("Poster") String poster,
                         @JsonAlias("Plot") String sinopse) {

//TODO: Acrescentar :Year, Runtime, Writer, Director, Country, Type, imdbVotes

}
