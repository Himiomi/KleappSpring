package br.com.pedrodeveloper.springdataexamples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.pedrodeveloper.springdataexamples.entities.Cliente;
import br.com.pedrodeveloper.springdataexamples.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public String getClientes(Model model) {

		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteRepository.findAll();
		model.addAttribute("clientes", clientes);

		return clientes.toString();
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
