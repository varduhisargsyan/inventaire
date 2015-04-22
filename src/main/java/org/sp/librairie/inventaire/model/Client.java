package org.sp.librairie.inventaire.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by varduhi on 9/11/2014.
 */
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    @Column(name = "FName")
    private String fname;
    @Column(name = "LName")
    private String lname;
    @Column(name = "NMob")
    private String nmob;
    @Column(name = "NFix")
    private String nfix;
    @Column(name = "Address")
    private String address;
    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "client")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<BookRequest> orderedBooks = new ArrayList<BookRequest>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNmob() {
        return nmob;
    }

    public void setNmob(String nmob) {
        this.nmob = nmob;
    }

    public String getNfix() {
        return nfix;
    }

    public void setNfix(String nfix) {
        this.nfix = nfix;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookRequest> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<BookRequest> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }


}
