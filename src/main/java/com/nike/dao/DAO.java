package com.nike.dao;

import com.nike.model.Products;

public interface DAO {
    void saveProduct();
    void updateProduct(Products stock);
    void deleteProduct(Products stock);
    Products getProductById(String stockCode);
}
