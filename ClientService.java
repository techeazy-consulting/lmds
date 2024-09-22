package com.techEazy.techEazy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techEazy.techEazy.dao.ClientDao;
import com.techEazy.techEazy.entity.Client;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public String addClient(Client client) {
        return clientDao.addClient(client);
    }

    public String updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    public String deleteClient(Long id) {
        return clientDao.deleteClient(id);
    }

    public Client getClientById(Long id) {
        return clientDao.getClientById(id);
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public Client getClientById1(Long id) {
        return clientDao.getClientById(id);
    }
}
