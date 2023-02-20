package br.com.pedrodeveloper.springdataexamples.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.pedrodeveloper.springdataexamples.entities.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{

}
