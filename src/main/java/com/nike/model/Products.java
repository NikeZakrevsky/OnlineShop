package com.nike.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "products", catalog = "mydb")
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long stockId;
    private String title;
    private String description;
    private Set<Category> categories = new HashSet<Category>(0);


    public Products() {
    }

    public Products(String title, String description) {
        this.stockId = stockId;
        this.title = title;
        this.description = description;
    }

    public Products(String title, String description, Set<Category> categories) {
        this.stockId = stockId;
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "products_has_categories", catalog = "mydb",
            joinColumns = { @JoinColumn(name = "products_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "categories_id",nullable = false, updatable = false) })
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}