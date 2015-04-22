package org.sp.librairie.inventaire.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sp.librairie.inventaire.dao.SalesDao;
import org.sp.librairie.inventaire.model.Sales;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 12/6/2014.
 */
@Repository
public class SalesDaoImpl implements SalesDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    @Override
    public List<Sales> getSalesReportByBook(Integer bookId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Sales.class);
        criteria.add(Restrictions.eq("B_Id", bookId));
        criteria.addOrder(Order.desc("soldDate"));
        List<Sales> sales = criteria.list();
        return sales;
    }

    @Transactional
    @Override
    public List<Sales> getSalesByDate(Date startDate, Date endDate) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Sales as s WHERE (:startDate is null or s.soldDate>=:startDate) AND (:endDate is null or s.soldDate<=:endDate) order by s.soldDate");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<Sales> sales = query.list();
        return sales;
    }

    @Transactional
    @Override
    public List<Sales> getLastSales() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Sales as s WHERE  s.soldDate=(select max(sales.soldDate)from Sales  as sales) order by book.author");
        List<Sales> sales = query.list();
        return sales;
    }


}
