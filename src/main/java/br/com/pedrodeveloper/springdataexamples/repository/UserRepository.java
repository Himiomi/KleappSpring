package br.com.pedrodeveloper.springdataexamples.repository;

import br.com.pedrodeveloper.springdataexamples.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
