package org.sp.librairie.inventaire.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.sp.librairie.inventaire.model.Book;

/**
 * Created by varduhi on 9/11/2014.
 */
public interface BookDao {


    void addBook(Book book) throws Exception;

    void removeBook(Integer id) throws Exception;

    void updateBook(Book book) throws Exception;

    List<Book> search(String keyword) throws Exception;

    List<Book> filteredSearch(String title, String author, Integer categoryId, Date startDate, Date endDate) throws Exception;

    Book getBookById(Integer id) throws Exception;

    Book getBookReports(Integer id) throws Exception;

    void saleBook(Book book) throws Exception;

    Book getExistingBook(String author, String title, Integer categoryId, Double price) throws Exception;

    List<Book> getAllAvailableBooks() throws Exception;

    List<Book> getBooksNotAvailableOnStore() throws Exception;
    void sendBookToTheStore(Integer id)throws Exception;

    List<Book> getAllBooks() throws Exception;




}
