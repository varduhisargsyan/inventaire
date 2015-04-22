package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.LotDao;
import org.sp.librairie.inventaire.model.BookCase;

import java.util.List;

/**
 * Created by varduhi on 3/6/2015.
 */
public class LotService {
    private LotDao lotDao;

    public void setLotDao(LotDao lotDao) {
        this.lotDao = lotDao;
    }


    public List<BookCase> getAll() throws Exception {
        return lotDao.getAll();
    }


    public List<BookCase> getByDate() throws Exception {
        return null;
    }


    public void update(BookCase carton) throws Exception {
        lotDao.update(carton);
    }


    public void remove(Integer id) throws Exception {
        lotDao.remove(id);
    }


    public void add(BookCase carton) throws Exception {
        lotDao.add(carton);
    }
    public   BookCase getBookCaseById(Integer id) throws Exception{
        return  lotDao.getBookCaseById(id);
    }
}
