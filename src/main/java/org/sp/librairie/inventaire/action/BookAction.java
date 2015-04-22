package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.exception.ConstraintViolationException;
import org.sp.librairie.inventaire.model.Book;
import org.sp.librairie.inventaire.model.Category;
import org.sp.librairie.inventaire.service.BookService;
import org.sp.librairie.inventaire.service.CategoryService;
import org.springframework.dao.DataIntegrityViolationException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by varduhi on 2/6/2015.
 */
public class BookAction extends ActionSupport implements Preparable {

    private int bookId;

    private int categoryId;

    private Book book;
    private BookService bookService;
    private CategoryService categoryService;
    private List<Category> categoryList;


    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void prepare() throws Exception {
        categoryList = categoryService.getAllCategories();
    }

    @SkipValidation
    public String add() {

        return ActionResult.ADD;
    }


    public String save() {

        try {
            book.setAuthor(book.getAuthor().toUpperCase());
            bookService.addBook(book);
            setCategoryId(book.getCategory().getId());
            return ActionResult.LIST;
        } catch (Exception ex) {
            if (ex instanceof ConstraintViolationException) {
                try {
                    book = bookService.getExistingBook(book.getAuthor(), book.getTitle(), book.getCategory().getId(), book.getPrice());
                    return ActionResult.RENDER_DUPLICATE;
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println(book);
                    return ActionResult.EXCEPTION;
                }
            }
            ex.printStackTrace();
            System.out.println(Action.class);
            return ActionResult.EXCEPTION;
        }

    }
@SkipValidation
    public String editDuplicate() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookId = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.getBookById(bookId);
            return ActionResult.EDIT_DUPLICATE;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Action.class);
            return ActionResult.EXCEPTION;
        }

    }

    @SkipValidation
    public String edit() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookId = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.getBookById(bookId);
            return ActionResult.EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Action.class);
            return ActionResult.EXCEPTION;
        }

    }

    public String update() {
        try {
            book.setAuthor(book.getAuthor().toUpperCase());
            bookService.updateBook(book);
            setCategoryId(book.getCategory().getId());
            return ActionResult.LIST;
        } catch (Exception ex) {
            if (ex instanceof DataIntegrityViolationException) {
                try {
                    bookService.deleteBook(book.getId());
                    book = bookService.getExistingBook(book.getAuthor(), book.getTitle(), book.getCategory().getId(), book.getPrice());
                    return ActionResult.RENDER_DUPLICATE;
                } catch (Exception e) {
                    e.printStackTrace();
                    return ActionResult.EXCEPTION;
                }


            }
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    @SkipValidation
    public String prepareDelete(){
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookId = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.getBookById(bookId);
            return ActionResult.DELETE;
        }catch (Exception e){
            return ActionResult.EXCEPTION;
        }
    }
@SkipValidation
    public String delete() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookId = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.getBookById(bookId);
            setCategoryId(book.getCategory().getId());
            bookService.deleteBook(bookId);
            return ActionResult.LIST;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Action.class);
            return ActionResult.EXCEPTION;
        }

    }

@SkipValidation
    public String show() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookId = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.getBookReports(bookId);
            return ActionResult.SHOW;
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    @Override
    public void validate() {
        if(book.getAuthor().trim().isEmpty()){
          addFieldError("book.author", getText("text.empty_author"));
        }
        if(book.getTitle().trim().isEmpty()){
            addFieldError("book.title", getText("text.empty_title"));
        }
        if(book.getPrice()<=0){
            addFieldError("book.price", getText("text.min_price"));
        }
        if(book.getQuantityinstore()<0){
            addFieldError("book.quantityinstore", getText("text.invalid_quantity"));
        }
        if(book.getQuantityinstock()<0){
            addFieldError("book.quantityinstock", getText("text.invalid_quantity"));
        }
        if((book.getQuantityinstock()+book.getQuantityinstore())==0){
            addActionError(getText("text.min_quantity"));
        }
    }
}
