package com.nike.dao;

import com.nike.model.Products;

import java.util.List;
import java.util.Set;

public interface DAO {
    void saveProduct();
    void updateProduct(Products stock);
    void deleteProduct(Products stock);
    Set<Products> getProductsList(String category);
    Products getProductById(String stockCode);
}
