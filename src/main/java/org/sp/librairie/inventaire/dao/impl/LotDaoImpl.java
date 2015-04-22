package org.sp.librairie.inventaire.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sp.librairie.inventaire.dao.LotDao;
import org.sp.librairie.inventaire.model.BookCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by varduhi on 3/6/2015.
 */
public class LotDaoImpl implements LotDao {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings(value = "unchecked")
    @Transactional
    @Override
    public List<BookCase> getAll() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookCase");
        return query.list();
    }

    @Transactional
    @Override
    public List<BookCase> getByDate() throws Exception {
        return null;
    }

    @Transactional
    @Override
    public void update(BookCase carton) throws  Exception {
        sessionFactory.getCurrentSession().update(carton);
    }

    @Transactional
    @Override
    public void remove(Integer id) throws Exception {
        BookCase bookCase = (BookCase) sessionFactory.getCurrentSession().get(BookCase.class, id);
        sessionFactory.getCurrentSession().delete(bookCase);
    }

    @Transactional
    @Override
    public void add(BookCase carton) throws Exception {
        sessionFactory.getCurrentSession().persist(carton);
    }
    @Transactional
    @Override
    public   BookCase getBookCaseById(Integer id) throws Exception{
        return (BookCase)sessionFactory.getCurrentSession().get(BookCase.class, id);
    }
}
