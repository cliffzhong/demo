package com.example.demo.service.impl;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.dao.hibernate.ManagerDao;
import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.daoimpl.hibernate.ClientDaoHibernateImpl;
import com.example.demo.dto.ClientDto;
import com.example.demo.dto.ManagerDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Manager;
import com.example.demo.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    @Qualifier("ManagerDaoSpringDataJPAImpl")
    private ManagerDao managerDao;

    @Autowired
    @Qualifier("ClientDaoSpringDataJPAImpl")
    private ClientDao clientDao;

    @Autowired
    @Qualifier("ProductDaoSpringDataJPAImpl")
    private ProductDao productDao;

    @Override
    public ClientDto save(ClientDto clientDto, Long managerId) {
        Client client = clientDto.convertClientDtoToClient();
        Client savedClient = clientDao.save(client,1L);
        ClientDto savedClientDto = savedClient.convertClientToClientDto();
        return savedClientDto;
    }

    @Override
    public ClientDto update(ClientDto managerDto) {
        Client client = managerDto.convertClientDtoToClient();
        Client updatedClient = clientDao.update(client);
        ClientDto updatedClientDto = updatedClient.convertClientToClientDto();
        return updatedClientDto;
    }


    @Override
    public boolean deleteByLoginName(String loginName) {
        return false;
    }

    @Override
    public boolean deleteById(Long clientDtoId) {
        return false;
    }

    @Override
    public boolean delete(ClientDto clientDto) {
        return false;
    }

    @Override
    public List<ClientDto> getClients() {
        return null;
    }

    @Override
    public ClientDto getClientById(Long id) {
        return null;
    }

    @Override
    public ClientDto getClientByLoginName(String loginName) {
        return null;
    }
}
