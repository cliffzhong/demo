package com.example.demo.dao.hibernate;

import com.example.demo.entity.Client;

import java.util.List;

//public interface ClientDao {
    //    Student save(Student student);

public interface ClientDao {

//        Client1 save(Client1 client1);
//        Client1 update(Client1 client1);
//        boolean delete(Client1 client1);
//        Client1 getClient1ById(Long id);
//        List<Client1> getClients();
//
//        Client1 getClientAndManagersByXxxId(Long managerId);
//
//
//    }
    Client save(Client client, Long managerId);
    Client update(Client client);
    boolean deleteByLoginName(String loginName);
    boolean deleteById(Long clientId);
    boolean delete(Client client);
    List<Client> getClients();
    Client getClientById(Long id);
    Client getClientByLoginName(String loginName);

    List<Client> getClientsByManagerId (Long managerId);
    //List<Project> getAssociatedProjectsByStudentId(Long studentId);
    //List<Project> getAssociatedProjectsByStudentLoginName(String loginName);

    List<Client> getClientsWithAssociatedProducts();
}
