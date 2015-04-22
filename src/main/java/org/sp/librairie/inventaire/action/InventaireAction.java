package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.sp.librairie.inventaire.model.Book;
import org.sp.librairie.inventaire.model.Category;
import org.sp.librairie.inventaire.service.CategoryService;


import java.util.List;
import java.util.Set;

/**
 * Created by varduhi on 1/25/2015.
 */
public class InventaireAction extends ActionSupport implements Preparable{

    private List<Category> categoryList;
    private CategoryService categoryService;
    private Category category;
    private Set<Book> books;
    private int categoryId;


    public String execute() {
        if(categoryId!=0) {
            category=categoryService.getCategoryWithBooks(categoryId);
            books=category.getBooks();
        }
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        categoryList = categoryService.getAllCategories();
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

