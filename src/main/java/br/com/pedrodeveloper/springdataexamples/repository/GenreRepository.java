package br.com.pedrodeveloper.springdataexamples.repository;

import br.com.pedrodeveloper.springdataexamples.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
