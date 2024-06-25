package com.designpatterns.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designpatterns.models.Address;
import com.designpatterns.models.AddressRepository;
import com.designpatterns.models.Client;
import com.designpatterns.models.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Client> findAll() {
		// Buscar todos os Clients.
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		Optional<Client> Client = clientRepository.findById(id);
		return Client.get();
	}

	@Override
	public void insert(Client Client) {
		salvarClientComCep(Client);
	}

	@Override
	public void update(Long id, Client Client) {
		Optional<Client> clientBd = clientRepository.findById(id);
		if (clientBd.isPresent()) {
			salvarClientComCep(Client);
		}
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	private void salvarClientComCep(Client Client) {
		String cep = Client.getAddress().getCep();
		Address address = addressRepository.findById(cep).orElseGet(() -> {
			Address novoEndereco = viaCepService.findCep(cep);
			addressRepository.save(novoEndereco);
			return novoEndereco;
		});
		Client.setAddress(address);
		clientRepository.save(Client);
	}

}