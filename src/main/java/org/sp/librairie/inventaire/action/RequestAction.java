package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.hibernate.annotations.SourceType;
import org.sp.librairie.inventaire.model.BookRequest;
import org.sp.librairie.inventaire.model.Category;
import org.sp.librairie.inventaire.model.Client;
import org.sp.librairie.inventaire.service.BookRequestService;
import org.sp.librairie.inventaire.service.CategoryService;
import org.sp.librairie.inventaire.service.ClientService;
import org.sp.librairie.inventaire.util.STATUS;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 3/4/2015.
 */
public class RequestAction extends ActionSupport implements Preparable {
    private ClientService clientService;
    private BookRequestService bookRequestService;
    private CategoryService categoryService;
    private List<Client> clientList;
    private List<BookRequest> bookRequestList;
    private List<Category> categoryList;
    private List<STATUS> statusList;
    private int clientId;
    private int categoryId;
    private int bookRequestId;
    private BookRequest bookRequest;
    private String requestStatus;
    private String title;


    public String execute() {
        try {
            if (clientId != 0) {
                bookRequestList = bookRequestService.getRequestsByClient(clientId);

            } else if (requestStatus != null) {

                bookRequestList = bookRequestService.getBookRequestByStatus(requestStatus);
            } else {

                requestStatus = STATUS.AVAILABLE.getStatusCode();
                bookRequestList = bookRequestService.getBookRequestByStatus(requestStatus);

            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.EXCEPTION;
        }


    }

    public String add() {
        try {

            categoryList = categoryService.getAllCategories();

            return ActionResult.ADD;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String save() {

        try {

            bookRequest.setOrderDate(new Date());
            bookRequest.setStatus(STATUS.PENDING.getStatusCode());
            bookRequest.getClient().getOrderedBooks().add(bookRequest);
            if (bookRequest.getAuthor().trim().isEmpty()) {
                bookRequest.setAuthor(null);
            }
            if (bookRequest.getTitle().trim().isEmpty()) {
                bookRequest.setTitle(null);
            }
            if (bookRequest.getCategory().getId() == -1) {
                bookRequest.setCategory(null);
            } else {
                bookRequest.getCategory().getBookRequests().add(bookRequest);
            }
            bookRequestService.addRequest(bookRequest);
            clientId = bookRequest.getClient().getId();
            return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }

    }

    public String edit() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookRequestId = Integer.parseInt(request.getParameter("requestId"));
            bookRequest = bookRequestService.getBookRequestById(bookRequestId);

            categoryList = categoryService.getAllCategories();
            clientList = clientService.getAllClients();
            return ActionResult.EDIT;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String update() {
        try {
           if(bookRequest.getCategory().getId()==-1){
               bookRequest.setCategory(null);
           }
            bookRequestService.updateRequest(bookRequest);
            clientId = bookRequest.getClient().getId();

            return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String delete() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookRequestId = Integer.parseInt(request.getParameter("requestId"));
            clientId = Integer.parseInt(request.getParameter("clientId"));
            bookRequestService.deleteRequest(bookRequestId);
                       return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String passivate() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookRequestId = Integer.parseInt(request.getParameter("requestId"));
            bookRequestService.updateStatus(bookRequestId);
            return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public void setRequestService(BookRequestService bookRequestService) {
        this.bookRequestService = bookRequestService;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<BookRequest> getBookRequestList() {
        return bookRequestList;
    }

    public void setBookRequestList(List<BookRequest> bookRequestList) {
        this.bookRequestList = bookRequestList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRequestId() {
        return bookRequestId;
    }

    public void setRequestId(int bookRequestId) {
        this.bookRequestId = bookRequestId;
    }

    public BookRequest getBookRequest() {
        return bookRequest;
    }

    public void setBookRequest(BookRequest bookRequest) {
        this.bookRequest = bookRequest;
    }


    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public List<STATUS> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<STATUS> statusList) {
        statusList.add(STATUS.AVAILABLE);
        statusList.add(STATUS.PENDING);
        statusList.add(STATUS.SEEN);
        this.statusList = statusList;
    }

    @Override
    public void prepare() throws Exception {
        setStatusList(new ArrayList<STATUS>());
        setClientList(clientService.getAllClients());
    }


}
