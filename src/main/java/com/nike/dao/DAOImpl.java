package com.nike.dao;

import com.nike.model.Category;
import com.nike.model.Products;
import com.nike.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    public Set<Products> getProductsList(String categoryName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
