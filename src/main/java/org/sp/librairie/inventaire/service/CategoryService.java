package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.CategoryDao;
import org.sp.librairie.inventaire.model.Category;

import java.util.List;

/**
 * Created by varduhi on 1/7/2015.
 */
public class CategoryService {
    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    

    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }



    public void removeCategory(Category category) {
        categoryDao.removeCategory(category);

    }


    public void updateCategory(Category category) {

        categoryDao.updateCategory(category);
    }



    public Category getCategory(Integer id) {
        return categoryDao.getCategoryById(id);

    }


   public List<Category> getAllCategories() {
   return categoryDao.getCategories();
    }

    public Category getCategoryWithBooks(Integer id){
        return categoryDao.getCategoryWithBooks(id);
    }
}
