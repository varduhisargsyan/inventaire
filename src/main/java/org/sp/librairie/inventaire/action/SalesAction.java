package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.sp.librairie.inventaire.model.Book;
import org.sp.librairie.inventaire.model.Sales;
import org.sp.librairie.inventaire.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by varduhi on 1/24/2015.
 */
public class SalesAction extends ActionSupport {
    private BookService bookService;
    private int categoryId;
    private Sales sales;
    private Book book;
    private int bookId;


    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public String execute() {
        try {
            if (sales != null && book != null) {
                //redirects to inventaire with sold book category id set
                setCategoryId(book.getCategory().getId());

                sales.setSoldDate(new Date());
                sales.setBook(book);
                book.getSales().add(sales);
                book.setQuantityinstore(book.getQuantityinstore() - sales.getSoldquantityinstore());
                book.setQuantityinstock(book.getQuantityinstock()-sales.getSoldquantityinstock());

                bookService.saleBook(book);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(Action.class);
            return ActionResult.EXCEPTION;
        }
        return ActionResult.LIST;

    }

    public String input() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookId = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.getBookById(bookId);
            return ActionResult.SALE;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Action.class);
            return ActionResult.EXCEPTION;
        }

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public void validate() {
        if(sales.getSoldquantityinstock()<0) {
            addFieldError("sales.soldquantityinstock", getText("text.invalid_soldquantity"));
        }
        if(sales.getSoldquantityinstore()<0) {
            addFieldError("sales.soldquantityinstore", getText("text.invalid_soldquantity"));
        }
        if(sales.getSoldquantityinstore()+sales.getSoldquantityinstock()==0){
            addActionError(getText("text.no_soldquantity"));
        }
        if(sales.getSoldquantityinstock()>book.getQuantityinstock()){
            addFieldError("sales.soldquantityinstock", getText("text.soldquantity_limit"));

        }if (sales.getSoldquantityinstore()>book.getQuantityinstore()){
            addFieldError("sales.soldquantityinstore", getText("text.soldquantity_limit"));
        }

    }
}
