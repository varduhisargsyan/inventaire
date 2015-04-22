package org.sp.librairie.inventaire.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by varduhi on 3/6/2015.
 */
@Entity
@Table(name = "book_case")
public class BookCase {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "Price")
    private double price;
    @Column(name = "Destinator")
    private String destinator;
    @Column(name = "Insertion_date")
    @Temporal(TemporalType.DATE)
    private Date insertionDate;
    @Column(name = "Type")
    private String type;
    @Column(name = "Item_quantity")
    private int itemQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDestinator() {
        return destinator;
    }

    public void setDestinator(String destinator) {
        this.destinator = destinator;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "BookCase{" +
                "id=" + id +
                ", price=" + price +
                ", destinator='" + destinator + '\'' +
                ", insertionDate=" + insertionDate +
                ", type='" + type + '\'' +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
