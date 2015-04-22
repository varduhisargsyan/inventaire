package org.sp.librairie.inventaire.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sp.librairie.inventaire.dao.ReceipeDao;
import org.sp.librairie.inventaire.model.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import org.sp.librairie.inventaire.util.STATUS;
/**
 * Created by varduhi on 2/20/2015.
 */
@Repository
public class ReceipeDaoImpl implements ReceipeDao {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    @Override
    public List<Log> getLastRecieved() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Log l where  l.operation=:status  AND l.date=(select max (log.date) from Log as log) ORDER BY l.book.author");
        query.setParameter("status", STATUS.ADD.getStatusCode());
        List<Log> results = query.list();

      return results;
    }

    @Override
    @Transactional
    public List<Log> getRecievedByDate(Date startDate, Date endDate) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Log l WHERE l.operation=:status AND  (:startDate is null or l.date>=:startDate) AND (:endDate is null or l.date<=:endDate) ORDER BY l.date");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        query.setParameter("status", STATUS.ADD.getStatusCode());

        List<Log> results = query.list();
        return results;
    }

    public List<Log> getReceiptsReportsByBook(Integer bookId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Log as l  where l.operation=:status AND l.book.id=:bookId  ORDER BY l.date");
        query.setParameter("bookId", bookId);
        query.setParameter("status", STATUS.ADD.getStatusCode());
        List<Log> results = query.list();
        return results;
    }
}
