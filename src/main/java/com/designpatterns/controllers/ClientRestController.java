package com.designpatterns.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.models.Client;
import com.designpatterns.services.ClientService;

@RestController
@RequestMapping("clientes")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<Iterable<Client>> findAll() {
		return ResponseEntity.ok(clientService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client Client) {
		clientService.insert(Client);
		return ResponseEntity.ok(Client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client Client) {
		clientService.update(id, Client);
		return ResponseEntity.ok(Client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}