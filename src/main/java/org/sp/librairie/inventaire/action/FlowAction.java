package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionSupport;
import org.sp.librairie.inventaire.model.Book;
import org.sp.librairie.inventaire.service.BookService;

import java.util.List;

/**
 * Created by varduhi on 3/24/2015.
 */
public class FlowAction extends ActionSupport {
    private BookService bookService;
    private List<Book> availableBooks;
    private int bookId;

    public String execute() {
        try {
            if (bookId != 0) {
                bookService.sendBookToTheStore(bookId);
                return ActionResult.LIST;
            }
            availableBooks = bookService.getBooksNotAvailableOnStore();
            return SUCCESS;
        }catch (Exception ex){
            return ActionResult.EXCEPTION;
        }
    }


    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
