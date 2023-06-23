package com.example.demo.daoimpl.hibernate;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.dao.hibernate.ManagerDao;
import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.entity.Manager;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManagerDaoHibernateTest {

    private Logger logger = LoggerFactory.getLogger(ManagerDaoHibernateTest.class);

    private static ManagerDaoHibernateImpl clientManager1DaoHibernate;
    private static ManagerDao managerDao;
    private static ClientDao clientDao;
    private static ProductDao productDao;

    @BeforeAll
    public static void initAll(){
        managerDao = new ManagerDaoHibernateImpl();
        clientDao = new ClientDaoHibernateImpl();
        productDao = new ProductDaoHibernateImpl();

    }

    @AfterAll
    public static void teardownAll(){
        managerDao = null;
        clientDao = null;
        productDao = null;

    }

    @BeforeEach
    public void setupEach(){
//        clientManager1DaoHibernate = new ManagerDaoHibernateImpl();
    }

    @AfterEach
    public void cleanupEach(){
//        clientManager1DaoHibernate = null;

    }

    @Test
    @Transactional
    public void testSaveManager(){
        Manager manager = createManagerByName("ddc");
        Manager savedManager = managerDao.save(manager);
        assertNotNull(savedManager.getId());
        assertEquals(manager.getId(), savedManager.getId());
        assertEquals(manager.getDescription(), savedManager.getDescription());
        assertEquals(manager.getName(), savedManager.getName());
    }
    private Manager createManagerByName(String name) {
        Manager manager = new Manager();
        manager.setName(name);
        manager.setDescription(name + "edc");
        return manager;
    }


    @Test
    public void getManagersTest(){
        List<Manager> managerList = managerDao.getManagers();
        assertEquals(12,managerList.size());
    }

    @Test
    public void getManagerAndClientAndProductWithManagerIdTest(){
        Manager retrievedManager = managerDao.getManagerAndClientAndProductWithManagerId((long)2);
        assertEquals(2,retrievedManager.getClientList().size());

    }



}
