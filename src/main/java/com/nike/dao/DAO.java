package com.nike.dao;

import com.nike.model.Order;
import com.nike.model.Products;
import com.nike.model.User;

import java.util.List;
import java.util.Set;

public interface DAO {
    void saveProduct();
    void updateProduct(Products stock);
    void deleteProduct(Products stock);
    Set<Products> getProductsList(String category);
    Products getProductById(Integer pr_id);
    void addOrder(Products product, User user);
    List<Order> getOrdersList(User user);
}
