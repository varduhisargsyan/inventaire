package org.sp.librairie.inventaire.dao;

import org.sp.librairie.inventaire.model.BookCase;

import java.util.List;

/**
 * Created by varduhi on 3/6/2015.
 */
public interface LotDao {
    List<BookCase> getAll() throws Exception;

    List<BookCase> getByDate() throws Exception;

    void update(BookCase carton) throws Exception;

    void remove(Integer id) throws Exception;

    void add(BookCase carton) throws Exception;
    BookCase getBookCaseById(Integer id) throws Exception;


}
