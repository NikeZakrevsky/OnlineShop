package com.nike.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories", catalog = "mydb")
public class Category {
    private int id;
    private String title;
    private String description;
    private Set<Products> categories = new HashSet<Products>(0);

    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Category(String title, String description, Set<Products> categories) {
        this.title = title;
        this.description = description;
        this.categories = categories;
    }



    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    public Set<Products> getCategories() {
        return categories;
    }

    public void setCategories(Set<Products> categories) {
        this.categories = categories;
    }
}
