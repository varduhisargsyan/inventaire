package org.sp.librairie.inventaire.dao;

import org.sp.librairie.inventaire.model.Category;

import java.util.List;

/**
 * Created by varduhi on 10/21/2014.
 */
public interface CategoryDao  {
    //GRUD OPERATIONS
    void addCategory(Category category);

    void removeCategory(Category category) ;

    void updateCategory(Category category);

    Category getCategoryById(Integer id);

    List<Category> getCategories();
    Category getCategoryWithBooks(Integer id);




}
