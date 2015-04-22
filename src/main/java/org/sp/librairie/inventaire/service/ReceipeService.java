package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.ReceipeDao;
import org.sp.librairie.inventaire.model.Log;

import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 2/20/2015.
 */
public class ReceipeService {
    private ReceipeDao receipeDao;

    public void setReceipeDao(ReceipeDao receipeDao) {
        this.receipeDao = receipeDao;
    }

    public List<Log> getLastRecieved() {
        return receipeDao.getLastRecieved();
    }

    public List<Log> getRecievedByDate(Date startDate, Date endDate) {
        return receipeDao.getRecievedByDate(startDate, endDate);
    }

}
