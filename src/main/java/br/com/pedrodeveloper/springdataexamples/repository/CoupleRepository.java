package br.com.pedrodeveloper.springdataexamples.repository;

import br.com.pedrodeveloper.springdataexamples.model.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {

}
