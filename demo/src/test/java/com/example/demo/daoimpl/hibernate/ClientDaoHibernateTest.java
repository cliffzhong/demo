package com.example.demo.daoimpl.hibernate;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.daoimpl.hibernate.ClientDaoHibernateImpl;
import com.example.demo.entity.Client;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClientDaoHibernateTest {

    private Logger logger = LoggerFactory.getLogger(ClientDaoHibernateImpl.class);

    private static ClientDaoHibernateImpl client1DaoHibernate;
    private static ClientDao clientDao;

    @BeforeAll
    public static void initAll(){

    }

    @AfterAll
    public static void teardownAll(){

    }

    @BeforeEach
    public void setupEach(){
        client1DaoHibernate = new ClientDaoHibernateImpl();
    }

    @AfterEach
    public void cleanupEach(){
        client1DaoHibernate = null;

    }

    @Test
    public void testSaveClient(){
        Client client = createClientByName("abc", 12);
        Client savedClient = client1DaoHibernate.save(client, 12L);
        assertNotNull(savedClient.getId());
        assertEquals(client.getFirstName(), savedClient.getFirstName());
        assertEquals(client.getLastName(), savedClient.getLastName());
    }

    private Client createClientByName(String abc, long i) {
        Client client = new Client();
        client.setFirstName(abc);
        client.setLastName(abc+"cde");
        client.setLoginName("1223");
        return client;
    }


}
