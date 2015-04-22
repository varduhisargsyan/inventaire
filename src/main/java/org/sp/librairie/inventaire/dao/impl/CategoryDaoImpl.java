package org.sp.librairie.inventaire.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sp.librairie.inventaire.dao.CategoryDao;
import org.sp.librairie.inventaire.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 10/21/2014.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
//GRUD OPERATIONS

    @Override
    @Transactional
    public void addCategory(Category category) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
        criteria.add(Restrictions.ilike("name", category.getName()));
        Category cat = (Category) criteria.uniqueResult();
        if (cat != null) {
            System.out.println("Ce Categorie existe");
            return;
        }
        sessionFactory.getCurrentSession().persist(category);
    }


    @Override
    @Transactional
    public void removeCategory(Category category) {
        sessionFactory.getCurrentSession().delete(category);

    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        sessionFactory.getCurrentSession().saveOrUpdate(category);
    }
    //END GRUD OPERATIONS

    @Override
    @Transactional
    public Category getCategoryById(Integer id) {
        Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
        return category;
    }
    @Override
    @Transactional
    public List<Category> getCategories() {
       Query query= sessionFactory.getCurrentSession().createQuery("From Category ORDER BY name");
        List<Category> categories = (List<Category>) query.list();

        return categories;
    }

    @Override
    @Transactional
public Category getCategoryWithBooks(Integer id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setFetchMode("books", FetchMode.JOIN);
        Category category = (Category) criteria.uniqueResult();
        return category;
    }

}


