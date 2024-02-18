package com.srvcode.hibernate.repository;

import com.srvcode.hibernate.config.HibernateUtil;
import com.srvcode.hibernate.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class ProductRepository {

    public List<Product> getAllProduct() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from hproducts", Product.class).list();
        }
    }

    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction == null)
                transaction.rollback();
            log.error("Exception occurred whiling saving Product: {}", ex.getMessage());
        }
    }


    public Product findProductById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from hproducts p where p.id = " + id, Product.class).getSingleResult();
        }
    }

    public void updateProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction == null)
                transaction.rollback();
            log.error("Exception occurred whiling updating Product: {}", ex.getMessage());
        }
    }

    public void deleteProductById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Product product = findProductById(id);
            session.delete(product);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction == null)
                transaction.rollback();
            log.error("Exception occurred whiling deleting Product: {}", ex.getMessage());
        }
    }

}
