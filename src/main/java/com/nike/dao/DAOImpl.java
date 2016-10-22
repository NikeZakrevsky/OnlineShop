package com.nike.dao;

import com.nike.model.Category;
import com.nike.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
public class DAOImpl implements DAO {

    private SessionFactory sessionFactory;

    public DAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveProduct() {
        Session session = sessionFactory.getCurrentSession();
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
    public Set<Products> getProductsList(String categoryName) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Category> list = session.createCriteria(Category.class).list();
        Optional<Category> c = list.stream().filter(category -> category.getTitle().equals(categoryName)).findFirst();
        c.get().getCategories().forEach(qwe -> System.out.println(qwe.getTitle()));
        Set<Products> list2 = c.get().getCategories();
        session.getTransaction().commit();
        return list2;
    }

    @Override
    public Products getProductById(String stockCode) {
        return null;
    }


}
