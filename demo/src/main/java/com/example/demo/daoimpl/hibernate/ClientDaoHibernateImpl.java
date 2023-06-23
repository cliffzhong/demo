package com.example.demo.daoimpl.hibernate;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.entity.Client;
import com.example.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ClientDaoHibernateImpl")
public class ClientDaoHibernateImpl implements ClientDao {

    private Logger logger = LoggerFactory.getLogger(ClientDaoHibernateImpl.class);

//    @Override
//    public List<Client> getClient1(){
//        List<Client> clientList = null;
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        try{
//            Query<Client> query= session.createQuery(HQLStatementUtil.HQL_SELECT_ALL_MAJORS);
//
//        }
//    }

    @Override
    public Client save(Client client, Long managerId) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            logger.error("fail to insert a CLient, error={}", e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return client;
    }

    @Override
    public Client update(Client client) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        } catch (Exception e) {
            logger.error("fail to insert a Client, error={}", e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return client;

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
