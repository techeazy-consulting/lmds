package com.techeazy.lmds.service;

import com.techeazy.lmds.model.Client;
import com.techeazy.lmds.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    public Client createClient(Client Client){
        return clientRepository.save(Client);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
