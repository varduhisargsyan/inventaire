package org.sp.librairie.inventaire.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sp.librairie.inventaire.dao.BookRequestDao;
import org.sp.librairie.inventaire.model.BookRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sp.librairie.inventaire.util.STATUS;

import java.util.List;


/**
 * Created by varduhi on 2/20/2015.
 */
@Repository
public class BookRequestDaoImpl implements BookRequestDao {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addRequest(BookRequest bookRequest) throws Exception {
        sessionFactory.getCurrentSession().persist(bookRequest);
    }

    @Override
    @Transactional
    public void updateRequest(BookRequest bookRequest) throws Exception {
        sessionFactory.getCurrentSession().update(bookRequest);

    }

    @Override
    @Transactional
    public void deleteRequest(Integer id) throws Exception {
        BookRequest request = (BookRequest) sessionFactory.getCurrentSession().get(BookRequest.class, id);
        sessionFactory.getCurrentSession().delete(request);


    }

    @Override
    @Transactional
    public void updateStatus(Integer requestId) throws Exception {

        BookRequest request = (BookRequest) sessionFactory.getCurrentSession().get(BookRequest.class, requestId);
        request.setStatus(STATUS.SEEN.getStatusCode());

    }

    @Transactional
    @Override
    public List<BookRequest> getAllBookRequests() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookRequest order by orderDate");
        return query.list();

    }

    @Transactional
    @Override
    public List<BookRequest> getAvailableRequests() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookRequest as  request WHERE request.status=:status order by orderDate");
        query.setParameter("status", STATUS.AVAILABLE.getStatusCode());
        return query.list();


    }

    @Transactional
    @Override
    public List<BookRequest> getPendingRequests() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookRequest as  request WHERE request.status=:status order by orderDate");
        query.setParameter("status", STATUS.PENDING.getStatusCode());
        return query.list();

    }

    @Transactional
    @Override
    public List<BookRequest> getPassiveRequests() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookRequest as  request WHERE request.status=:status order by orderDate");
        query.setParameter("status", STATUS.SEEN.getStatusCode());
        return query.list();
    }

    @Override
    @Transactional
    public List<BookRequest> getBookRequestByStatus(String status) throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookRequest as  request WHERE request.status=:status order by orderDate");
        query.setParameter("status", status);
        return query.list();
    }

    @Transactional
    @Override
    public List<BookRequest> getRequestsByClient(Integer clientId) throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from BookRequest as  request WHERE request.client.id=:id order by orderDate");
        query.setParameter("id", clientId);
        return query.list();
    }

    @Transactional
    @Override
    public BookRequest getBookRequestById(Integer id)  throws Exception{
        return (BookRequest)sessionFactory.getCurrentSession().get(BookRequest.class, id);
    }
}
