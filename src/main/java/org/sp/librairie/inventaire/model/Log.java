package org.sp.librairie.inventaire.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by varduhi on 2/10/2015.
 */
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;
    @Column(name = "Transaction_date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Operation_type")
    private String operation;
    @ManyToOne
   @JoinColumn(name = "B_Id")
    private Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "LOG -  ID : "+ this.getId()+ " DATE: "+this.getDate()+ " OPERATION: "+this.getOperation()+ "BOOK ID:  "+ this.getBook().getId();
    }
}
