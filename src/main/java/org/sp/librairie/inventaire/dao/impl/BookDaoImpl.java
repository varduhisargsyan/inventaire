package org.sp.librairie.inventaire.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sp.librairie.inventaire.dao.BookDao;
import org.sp.librairie.inventaire.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sp.librairie.inventaire.util.STATUS;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by varduhi on 9/17/2014.
 */
@Repository
public class BookDaoImpl implements BookDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void addBook(Book book) throws Exception {
        sessionFactory.getCurrentSession().persist(book);
    }


    @Override
    @Transactional
    public void removeBook(Integer id) throws Exception {
        Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
        sessionFactory.getCurrentSession().delete(book);
    }


    @Override
    @Transactional
    public void updateBook(Book book) throws Exception {
                sessionFactory.getCurrentSession().update(book);
    }


    @Override
    @Transactional
    public List search(String keyword) throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from Book  as b" +
                        " where (lower(b.title) LIKE concat(lower(:keyword),'%')) OR (lower(b.author) LIKE concat(lower(:keyword), '%')) ORDER BY b.author"

        );
        query.setParameter("keyword", keyword);
        List result = query.list();
        return result;
    }


    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List filteredSearch(String title, String author, Integer categoryId, Date startDate, Date endDate) throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from Book  as b left outer join b.logs as l" +
                        " where (:title is null OR length(trim(:title))=0 OR lower(b.title) LIKE concat(lower(:title),'%')) AND (:author is null OR length(trim(:author))=0 OR lower(b.author) LIKE concat(lower(:author), '%')) AND (:categoryId is null OR :categoryId=0 OR b.category.id=:categoryId)" +
                        "AND (:startDate is null or l.date >= :startDate) AND (:endDate is null or l.date <= :endDate) ORDER BY b.author"
        );
        query.setParameter("title", title);
        query.setParameter("author", author);
        query.setParameter("categoryId", categoryId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List result = query.list();
        return result;
    }


    @Override
    @Transactional
    public Book getBookById(Integer id) throws Exception {
        return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Transactional
    @Override
    public Book getExistingBook(String author, String title, Integer categoryId, Double price) throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.add(Restrictions.ilike("title", title));
        criteria.add(Restrictions.ilike("author", author));
        criteria.add(Restrictions.eq("category.id", categoryId));
        criteria.add(Restrictions.eq("price", price));
        return (Book) criteria.uniqueResult();

    }

    @Override
    @Transactional
    public Book getBookReports(Integer id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.createAlias("logs", "l", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("sales", "s", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("id", id));
        return (Book) criteria.uniqueResult();


    }


    @Override
    @Transactional
    public void saleBook(Book book) throws Exception {
        try {
            sessionFactory.getCurrentSession().update(book);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    @Override
    @Transactional
    public List<Book> getAllBooks() throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.addOrder(Order.asc("author"));
        List<Book> books = criteria.list();

        return books;
    }

    @Override
    @Transactional
    public List<Book> getAllAvailableBooks() throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.add(Restrictions.gt("totalquantity", 0));
        criteria.addOrder(Order.desc("author"));
        List<Book> books = criteria.list();
        return books;
    }

    @Override
    @Transactional
    public List<Book> getBooksNotAvailableOnStore() throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("quantityinstore", 0));
        criteria.add(Restrictions.gt("quantityinstock", 0));
        criteria.addOrder(Order.asc("author"));
        List<Book> books = criteria.list();
        return books;
    }

    @Transactional
    @Override
    public void sendBookToTheStore(Integer id) throws Exception {
        Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
        if (book.getQuantityinstore() == 0 && book.getQuantityinstock() > 0) {
            book.setQuantityinstore(book.getQuantityinstore() + 1);
            book.setQuantityinstock(book.getQuantityinstock() - 1);
        }
    }
}

