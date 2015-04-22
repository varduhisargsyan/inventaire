package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.SalesDao;
import org.sp.librairie.inventaire.model.Sales;

import java.util.Date;
import java.util.List;


/**
 * Created by varduhi on 1/7/2015.
 */
public class SalesService {
    private SalesDao salesDao;

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

  public   List<Sales> getLastSales(){
        return salesDao.getLastSales();
    }

  public   List<Sales> getSalesByDate(Date startDate, Date endDate){
        return salesDao.getSalesByDate(startDate, endDate);
    }


}
