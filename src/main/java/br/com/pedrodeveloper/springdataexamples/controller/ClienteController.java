package br.com.pedrodeveloper.springdataexamples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pedrodeveloper.springdataexamples.entities.Cliente;
import br.com.pedrodeveloper.springdataexamples.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public String getClientes(Model model) {
		
		Page<Cliente> clientes = new PageImpl<>(clienteRepository.findAll());
		model.addAttribute("clientes", clientes);
		
		return "clientes";
	}
	
	@GetMapping("/clientes/{id}")
	public String getMovieById(@PathVariable(required = true) Integer id, Model model) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if (cliente == null)
			throw new IllegalArgumentException("Cliente Id not found.");

		model.addAttribute("cliente", cliente);
		
		return "clientes-detail";
	}
	
	@PostMapping("/movies")
	public Cliente addMovie(@RequestBody Cliente movie) {
		return clienteRepository.save(movie);
	}
	
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(required = true) Integer id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if (cliente == null)
			throw new IllegalArgumentException("Cliente Id not found.");
		
		clienteRepository.delete(cliente);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
