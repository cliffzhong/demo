package com.example.demo.daoimpl.springdatajpa;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.dao.hibernate.ManagerDao;
import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.daoimpl.hibernate.ClientDaoHibernateImpl;
import com.example.demo.entity.Manager;
import org.hibernate.type.TrueFalseType;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
@SpringBootTest
public class ManagerDaoSpringDataJPATest {

    private Logger logger = LoggerFactory.getLogger(ManagerDaoSpringDataJPATest.class);

    @Autowired
    @Qualifier("ManagerDaoSpringDataJPAImpl")
    private ManagerDao managerDao;

    @Autowired
    @Qualifier("ClientDaoSpringDataJPAImpl")
    private ClientDao clientDao;

    @Autowired
    @Qualifier("ProductDaoSpringDataJPAImpl")
    private ProductDao productDao;

    @BeforeAll
    public static void setupAll() {
        // Perform setup actions before running any test methods
    }

    @AfterAll
    public static void cleanupAll() {
        // Perform cleanup actions after running all test methods
    }

    @BeforeEach
    public void setupEach() {
        // Perform setup actions before each test method
    }

    @AfterEach
    public void cleanupEach() {
        // Perform cleanup actions after each test method
    }

    @Test
    public void getManagersTest() {
        List<Manager> managerList = managerDao.getManagers();
        assertEquals(11, managerList.size());
    }

    @Test
    public void deleteByIdTest() {
        boolean flag = managerDao.deleteById(11L);
        assertTrue(flag);
    }

}
