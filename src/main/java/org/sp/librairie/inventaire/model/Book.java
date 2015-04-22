package org.sp.librairie.inventaire.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.*;

/**
 * Created by varduhi on 1/25/2015.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "Title")
    private String title;
    @Column(name = "Author")
    private String author;
    @Column(name = "Price")
    private double price;

    @Column(name = "Quantity_store")
    private int quantityinstore;


    @Column(name = "Quantity_stock")
    private int quantityinstock;

    @Formula("Quantity_store + Quantity_stock")
    private int totalquantity;

    @Formula("(Quantity_store + Quantity_stock) * price")
    private double totalprice;
    /*  1:1 and n:1 relations are
      loaded eagerly, if you use annotations whereas XML mappings are lazy
      by default.*/
    @ManyToOne
    @JoinColumn(name = "C_Id")
    private Category category;

    @OneToMany(mappedBy = "book", cascade = javax.persistence.CascadeType.PERSIST)
    @Cascade({CascadeType.DELETE, CascadeType.MERGE})
    @OrderBy("date")
    private Set<Log> logs = new HashSet<Log>();

    @OneToMany(mappedBy = "book")
    @Cascade({CascadeType.DELETE, CascadeType.SAVE_UPDATE})
    @OrderBy("soldDate")
    private Set<Sales> sales = new HashSet<Sales>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityinstore() {
        return quantityinstore;
    }

    public void setQuantityinstore(int quantityinstore) {
        this.quantityinstore = quantityinstore;
    }

    public int getQuantityinstock() {
        return quantityinstock;
    }

    public void setQuantityinstock(int quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    public int getTotalquantity() {
        return totalquantity;
    }

    public double getTotalprice() {
        return totalprice;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (Double.compare(book.price, price) != 0) return false;
        if (!author.equals(book.author)) return false;
        if (!title.equals(book.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title.hashCode();
        result = 31 * result + author.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {

        return "BOOK - ID: " + this.getId() + " TITLE: " + this.getTitle() + " CATEGORY ID: " + this.getCategory() + " AUTHOR: " + this.getAuthor() + " PRICE: " + this.getPrice() + " QUANTITY!: " + this.getTotalquantity();
    }
}