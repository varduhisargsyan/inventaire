package org.sp.librairie.inventaire.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by varduhi on 10/19/2014.
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "Id")

    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "category")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @OrderBy("author")
    private Set<Book> books = new HashSet<Book>();
    @OneToMany(mappedBy = "category")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @OrderBy("orderDate")
    private List<BookRequest> bookRequests=new ArrayList<BookRequest>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public List<BookRequest> getBookRequests() {
        return bookRequests;
    }

    public void setBookRequests(List<BookRequest> bookRequests) {
        this.bookRequests = bookRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (name != null ? !name.equals(category.name) : category.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
