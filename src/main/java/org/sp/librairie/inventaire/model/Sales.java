package org.sp.librairie.inventaire.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by varduhi on 2/20/2015.
 */

@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "Sprice")
    private double soldPrice;
    @Column(name = "Squantityinstore")
    private int soldquantityinstore;
    @Column(name="Squantityinstock")
    private int soldquantityinstock;
    @Column(name = "Description")
    private String desc;
    @Column(name = "Sdate")
    @Temporal(TemporalType.DATE)
    private Date soldDate;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "B_Id")
    Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getSoldquantityinstore() {
        return soldquantityinstore;
    }

    public void setSoldquantityinstore(int soldquantityinstore) {
        this.soldquantityinstore = soldquantityinstore;
    }

    public int getSoldquantityinstock() {
        return soldquantityinstock;
    }

    public void setSoldquantityinstock(int soldquantityinstock) {
        this.soldquantityinstock = soldquantityinstock;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
