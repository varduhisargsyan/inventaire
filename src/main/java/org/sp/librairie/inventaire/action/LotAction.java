package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.sp.librairie.inventaire.model.BookCase;
import org.sp.librairie.inventaire.service.LotService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 3/6/2015.
 */
public class LotAction extends ActionSupport implements Preparable {
    private LotService lotService;
    private BookCase bookCase;
    private int bookCaseId;
    private List<BookCase> caseList;

    @Override
    public void prepare() throws Exception {
        try {
            caseList = lotService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void setLotService(LotService lotService) {
        this.lotService = lotService;
    }
@SkipValidation
    public String execute() {
        return SUCCESS;
    }
@SkipValidation
    public String add() {
        try {

            return ActionResult.ADD;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String save() {
        try {
            bookCase.setInsertionDate(new Date());
            lotService.add(bookCase);
            return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }
@SkipValidation
    public String edit() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookCaseId = Integer.parseInt(request.getParameter("bookCaseId"));
            bookCase = lotService.getBookCaseById(bookCaseId);
            return ActionResult.EDIT;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }

    public String update() {
        try {
            System.out.println("LOT ACTON UPDATE ");
            System.out.println(bookCase);
            lotService.update(bookCase);
            return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }
@SkipValidation
    public String delete() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            bookCaseId = Integer.parseInt(request.getParameter("bookCaseId"));
            lotService.remove(bookCaseId);
            return ActionResult.LIST;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ActionResult.EXCEPTION;
        }
    }


    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    public int getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(int bookCaseId) {
        this.bookCaseId = bookCaseId;
    }

    public List<BookCase> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<BookCase> caseList) {
        this.caseList = caseList;
    }

    @Override
    public void validate() {
       if (bookCase.getDestinator()==null || bookCase.getDestinator().trim().isEmpty()){
           addFieldError("bookCase.destinator", getText("text.empty_destinator"));
       }if(bookCase.getType()==null || bookCase.getType().trim().isEmpty()){
            addFieldError("bookCase.type", getText("text.empty_type"));
        }
        if(bookCase.getItemQuantity()<=0){
            addFieldError("bookCase.itemQuantity", getText("text.invalid_quantity"));
        }
        if (bookCase.getPrice()<0){
            addFieldError("bookCase.price", getText("text.invalid_price"));
        }
    }
}
