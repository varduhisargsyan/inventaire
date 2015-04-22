package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.BookDao;
import org.sp.librairie.inventaire.model.Book;

import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 1/7/2015.
 */
public class BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) throws Exception {
        bookDao.addBook(book);
    }

    public void updateBook(Book book) throws Exception {
        bookDao.updateBook(book);
    }

    public Book getBookById(Integer id) throws Exception {
        return bookDao.getBookById(id);
    }

    public Book getExistingBook(String author, String title, Integer categoryId, Double price) throws Exception {

        return bookDao.getExistingBook(author, title, categoryId, price);

    }

    public void deleteBook(Integer id) throws Exception {
        bookDao.removeBook(id);
    }

    public void saleBook(Book book) throws Exception {
        bookDao.saleBook(book);
    }

    public Book getBookReports(Integer id) throws Exception {
        return bookDao.getBookReports(id);
    }

    public List<Book> search(String keyword) throws Exception {
        return bookDao.search(keyword);
    }

    public List filteredSearch(String title, String author, Integer categoryId, Date startDate, Date endDate) throws Exception {
        return bookDao.filteredSearch(title, author, categoryId, startDate, endDate);
    }

    public List<Book> getBooksNotAvailableOnStore() throws Exception {
        return bookDao.getBooksNotAvailableOnStore();
    }

    public void sendBookToTheStore(Integer id) throws Exception {
        bookDao.sendBookToTheStore(id);
    }
}
