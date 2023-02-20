package br.com.pedrodeveloper.springdataexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrodeveloper.springdataexamples.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
