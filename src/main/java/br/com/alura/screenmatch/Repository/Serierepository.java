package br.com.alura.screenmatch.Repository;

import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Serierepository extends JpaRepository<Serie, Long> {


}
