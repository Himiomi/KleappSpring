package br.com.pedrodeveloper.springdataexamples.config;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import br.com.pedrodeveloper.springdataexamples.entities.Cliente;
import br.com.pedrodeveloper.springdataexamples.entities.Produto;
import br.com.pedrodeveloper.springdataexamples.repository.ClienteRepository;
import br.com.pedrodeveloper.springdataexamples.repository.ProdutoRepository;

@Component
public class InitializeData implements ApplicationRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void run(ApplicationArguments args) throws ParseException {
		//Qty of records to add
		Long max = 200l;
		
		Faker faker = new Faker(new Locale("pt-BR"));
		
		for (long i = clienteRepository.count(); i<max; i++) {
			Cliente cliente = new Cliente();
			cliente.setNome(faker.name().fullName());
			clienteRepository.save(cliente);
		}

		//Decimal Format exactly the same as inside the faker
		//it is needed to parse the String to BigDecimal
		//Need to do this because the faker ignores the defined locale, 
		//thus leading to possible parse errors caused by the "," decimal separator
		//Known issue in Java Faker project #433
		DecimalFormat formatter = new DecimalFormat("#0.00");
		formatter.setParseBigDecimal(true);
		
		for (long i = produtoRepository.count(); i<max; i++) {
			Produto produto = new Produto();
			produto.setDescricao(faker.commerce().productName());
			
			BigDecimal price = (BigDecimal) formatter.parse(faker.commerce().price());
			produto.setValor(price);
			produto.setAtivo(faker.bool().bool());
			produtoRepository.save(produto);
		}
    }
}
