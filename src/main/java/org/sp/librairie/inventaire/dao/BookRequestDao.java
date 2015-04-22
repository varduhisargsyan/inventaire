package org.sp.librairie.inventaire.dao;

import org.sp.librairie.inventaire.model.BookRequest;

import java.util.List;

/**
 * Created by varduhi on 2/20/2015.
 */
public interface BookRequestDao {

    void addRequest(BookRequest bookRequest) throws Exception;

    void updateRequest(BookRequest bookRequest) throws Exception;

    void deleteRequest(Integer id) throws Exception;

    void updateStatus(Integer requestId) throws Exception;

    List<BookRequest> getAllBookRequests() throws Exception;
    List<BookRequest> getAvailableRequests() throws Exception;
    List<BookRequest> getPendingRequests() throws Exception;
    List<BookRequest> getPassiveRequests() throws Exception;
    List<BookRequest> getRequestsByClient(Integer clientId) throws Exception;
    BookRequest getBookRequestById(Integer id)  throws Exception;
    List<BookRequest> getBookRequestByStatus(String status) throws Exception;

}
