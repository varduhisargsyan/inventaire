package org.sp.librairie.inventaire.dao;

import org.sp.librairie.inventaire.model.Sales;

import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 12/6/2014.
 */
public interface SalesDao {

    List<Sales> getLastSales();

    List<Sales> getSalesByDate(Date startDate, Date endDate);

    public List<Sales> getSalesReportByBook(Integer bookId);
}
