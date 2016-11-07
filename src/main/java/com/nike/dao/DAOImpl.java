package com.nike.dao;

import com.nike.model.Category;
import com.nike.model.Order;
import com.nike.model.Products;
import com.nike.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public class DAOImpl implements DAO {

    private SessionFactory sessionFactory;

    public DAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void saveProduct() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Products product = new Products();
            product.setTitle("title");
            product.setDescription("description");

            Category category = new Category();
            category.setTitle("title");
            category.setDescription("description");

            Set<Category> catedories = new HashSet<Category>();
            catedories.add(category);

            product.setCategories(catedories);

            session.save(product);

            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void updateProduct(Products stock) {

    }

    @Override
    public void deleteProduct(Products stock) {

    }



    @Override
    public Set<Products> getProductsList(String categoryName) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Set productsList = null;
        try {
            tx = session.beginTransaction();
            List<Category> list = session.createCriteria(Category.class).list();
            for (Category c : list) {
                System.out.println("category" + c.getTitle());
                if (c.getTitle().equals(categoryName)) {
                    productsList  = c.getCategories();
                    return productsList ;
                }
            }
            tx.commit();
        }
        catch (HibernateException e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productsList;
    }

    @Override
    public Products getProductById(Integer pr_id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List<Products> products = session.createQuery("from Products where product_id=?").setParameter(0, pr_id).list();
            System.out.println(products.get(0).getTitle());
            tx.commit();
            return products.get(0);
        } catch(HibernateException e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void addOrder(Products product, User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Order order = new Order();
            order.setProduct_id(product);
            order.setUsername(user);
            Set<Order> orders = new HashSet<>();
            orders.add(order);
            user.setOrders(orders);
            session.save(order);
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public List<Order> getOrdersList(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Order> orders = null;
        List<Order> userOrders = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            orders = session.createQuery("from Order").list();
            for(Order order : orders)
                if(order.getUsername().getUsername().equals(user.getUsername()))
                    userOrders.add(order);
            tx.commit();
        } catch(HibernateException e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userOrders;
    }


}
