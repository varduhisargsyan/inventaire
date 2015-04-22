package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.sp.librairie.inventaire.model.Category;
import org.sp.librairie.inventaire.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by varduhi on 1/14/2015.
 */
public class CategoryAction extends ActionSupport implements Preparable {

    private Category category;
    private List<Category> categoryList;
    private CategoryService categoryService;
    private int id;

    @Override
    public void prepare() throws Exception {
        categoryList = categoryService.getAllCategories();
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @SkipValidation
    public String execute() {

        return SUCCESS;
    }

    @SkipValidation
    public String add() {
        return ActionResult.ADD;
    }


    public String save() {
        categoryService.addCategory(category);
        return ActionResult.LIST;
    }

    @SkipValidation
    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        category = categoryService.getCategory(Integer.parseInt(request.getParameter("id")));
        return ActionResult.EDIT;
    }

    public String update() {
        categoryService.updateCategory(category);
        return ActionResult.LIST;
    }

    @SkipValidation
    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        category = categoryService.getCategory(Integer.parseInt(request.getParameter("id")));
        categoryService.removeCategory(category);
        return ActionResult.LIST;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void validate() {
        if (category.getName().trim().isEmpty()) {
            addFieldError("category.name", getText("text.empty_cat"));
        }
    }
}
