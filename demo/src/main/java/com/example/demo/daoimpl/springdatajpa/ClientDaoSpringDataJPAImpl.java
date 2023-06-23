package com.example.demo.daoimpl.springdatajpa;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.daoimpl.repository.ClientRepository;
import com.example.demo.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ClientDaoSpringDataJPAImpl")
public class ClientDaoSpringDataJPAImpl implements ClientDao {

    private Logger logger = LoggerFactory.getLogger(ClientDaoSpringDataJPAImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client, Long managerId) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }

    @Override
    public Client update(Client client) {
        Client updateClient = clientRepository.save(client);
        return updateClient;
    }

    @Override
    public boolean deleteByLoginName(String loginName) {
        return false;
    }

    @Override
    public boolean deleteById(Long clientId) {
        return false;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }

    @Override
    public List<Client> getClients() {
        return null;
    }

    @Override
    public Client getClientById(Long id) {
        return null;
    }

    @Override
    public Client getClientByLoginName(String loginName) {
        return null;
    }

    @Override
    public List<Client> getClientsByManagerId(Long managerId) {
        return null;
    }

    @Override
    public List<Client> getClientsWithAssociatedProducts() {
        return null;
    }

}
