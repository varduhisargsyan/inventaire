package org.sp.librairie.inventaire.dao;

import org.sp.librairie.inventaire.model.Log;

import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 2/20/2015.
 */
public interface ReceipeDao {

    List<Log> getLastRecieved();
    List<Log> getRecievedByDate(Date startDate, Date  endDate);

    List<Log> getReceiptsReportsByBook(Integer bookId);
}
