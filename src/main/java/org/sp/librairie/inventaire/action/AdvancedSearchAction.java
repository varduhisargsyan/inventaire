package org.sp.librairie.inventaire.action;

import com.lowagie.text.pdf.PdfName;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.sp.librairie.inventaire.model.Book;
import org.sp.librairie.inventaire.model.Category;

import org.sp.librairie.inventaire.model.Log;
import org.sp.librairie.inventaire.service.BookService;
import org.sp.librairie.inventaire.service.CategoryService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by varduhi on 12/29/2014.
 */
public class AdvancedSearchAction extends ActionSupport implements Preparable {
    private String startDate;
    private String endDate;
    private String author;
    private String title;
    private Integer categoryId;
    private List<Category> categories;
    private BookService bookService;
    private CategoryService categoryService;
    private List<Book> searchResults;

    @Override
    public void prepare() throws Exception {
        categories = categoryService.getAllCategories();
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public String execute() {
        try {
            searchResults = bookService.filteredSearch(title, author, categoryId, parseToDate(startDate), parseToDate(endDate));
            return SUCCESS;

        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String input() {
        return INPUT;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Book> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Book> searchResults) {
        this.searchResults = searchResults;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    private Date parseToDate(String dateString) {
        Date date = null;
        if (dateString != null && !dateString.trim().isEmpty()) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = dateFormatter.parse(dateString);
                System.out.println(date);

            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        return date;
    }

    @Override
    public void validate() {
        if ((author == null || author.trim().isEmpty()) && (title == null || title.trim().isEmpty()) &&
                ( startDate == null || startDate.trim().isEmpty()) && (endDate == null || endDate.trim().isEmpty()) &&
                (categoryId == 0)) {
            addActionError(getText("text.empty_advanced"));
        }
    }
}

