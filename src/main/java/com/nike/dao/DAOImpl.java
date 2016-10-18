package com.nike.dao;

import com.nike.model.Category;
import com.nike.model.Products;
import com.nike.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class DAOImpl implements DAO {

    @Override
    public void saveProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
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

        session.getTransaction().commit();
        System.out.println("Done");
    }

    @Override
    public void updateProduct(Products stock) {

    }

    @Override
    public void deleteProduct(Products stock) {

    }

    @Override
    public Products getProductById(String stockCode) {
        return null;
    }
}
