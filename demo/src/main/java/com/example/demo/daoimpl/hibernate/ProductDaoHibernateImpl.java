package com.example.demo.daoimpl.hibernate;

import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductDaoHibernateImpl")
public class ProductDaoHibernateImpl implements ProductDao {

    private Logger logger = LoggerFactory.getLogger(ProductDaoHibernateImpl.class);

    @Override
    public Product save(Product product) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        }catch(Exception e){
            logger.error("fail to insert a Manager, error={}", e.getMessage());
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }

        return product;
    }

    @Override
    public Product update(Product product) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
        }catch(Exception e){
            logger.error("fail to insert a Manager, error={}", e.getMessage());
            if(transaction != null)
                transaction.rollback();
        }finally {
            session.close();
        }

        return product;
    }

    @Override
    public boolean deleteByName(String product1Name) {
        return false;
    }

    @Override
    public boolean deleteById(Long productId) {
        return false;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product getProductByName(String projectName) {
        return null;
    }

    @Override
    public List<Product> getProductsWithAssociatedClients() {
        return null;
    }

    @Override
    public Product getProductsWithAssociatedClientsById(Long productId) {
        return null;
    }

    @Override
    public Product getProductsWithAssociatedClientsByName(String productName) {
        return null;
    }
}
