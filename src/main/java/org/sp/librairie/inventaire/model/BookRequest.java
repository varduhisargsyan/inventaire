package org.sp.librairie.inventaire.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 12/2/2014.
 */
@Entity
@Table(name = "BOOK_REQUEST")
public class BookRequest {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    @Column(name = "Author")
    private String author;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String decsription;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;


    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "Cl_Id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "C_Id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDecsription() {
        return decsription;
    }

    public void setDecsription(String decsription) {
        this.decsription = decsription;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
