package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.BookRequestDao;
import org.sp.librairie.inventaire.model.BookRequest;

import java.util.List;

/**
 * Created by varduhi on 2/20/2015.
 */
public class BookRequestService {
    private BookRequestDao requestDao;

    public void setRequestDao(BookRequestDao requestDao) {
        this.requestDao = requestDao;
    }

   public void addRequest(BookRequest bookRequest) throws Exception{
       requestDao.addRequest(bookRequest);
   }

    public void updateRequest(BookRequest bookRequest) throws Exception{requestDao.updateRequest(bookRequest);}

    public  void deleteRequest(Integer id) throws Exception{requestDao.deleteRequest(id);}

    public void updateStatus(Integer requestId) throws Exception{requestDao.updateStatus(requestId);}

    public List<BookRequest> getAllBookRequests() throws Exception{return  requestDao.getAllBookRequests();}
    public List<BookRequest> getAvailableRequests() throws Exception{return  requestDao.getAvailableRequests();};
    public  List<BookRequest> getPendingRequests() throws Exception{return  requestDao.getPendingRequests();};
    public  List<BookRequest> getPassiveRequests() throws Exception{return  requestDao.getPassiveRequests();};
    public List<BookRequest> getRequestsByClient(Integer clientId) throws Exception{return  requestDao.getRequestsByClient(clientId);};
    public BookRequest getBookRequestById(Integer id)  throws Exception{return  requestDao.getBookRequestById(id);}
   public List<BookRequest> getBookRequestByStatus(String status) throws Exception{return  requestDao.getBookRequestByStatus(status);};

}
