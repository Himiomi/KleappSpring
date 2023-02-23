package br.com.pedrodeveloper.springdataexamples.repository;

import br.com.pedrodeveloper.springdataexamples.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

}
