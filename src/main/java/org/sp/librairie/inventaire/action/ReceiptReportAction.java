package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionSupport;
import org.sp.librairie.inventaire.model.Log;
import org.sp.librairie.inventaire.service.ReceipeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 12/27/2014.
 */
public class ReceiptReportAction extends ActionSupport {
    private ReceipeService receipeService;
    private List<Log> recievedBooks;
    private String startDate;
    private String endDate;


    public void setReceipeService(ReceipeService receipeService) {
        this.receipeService = receipeService;
    }


    public List<Log> getRecievedBooks() {
        return recievedBooks;
    }

    public void setRecievedBooks(List<Log> recievedBooks) {
        this.recievedBooks = recievedBooks;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String execute() {
        //Get list of receipts by period specified (gets and shows the last reciepts  by default)
        if (startDate == null && endDate == null) {
            recievedBooks = receipeService.getLastRecieved();
        } else {
            recievedBooks = receipeService.getRecievedByDate(parseToDate(getStartDate()), parseToDate(getEndDate()));
        }
        return SUCCESS;
    }

    private Date parseToDate(String dateString) {
        Date date = null;
        if (dateString != null && !dateString.trim().isEmpty()) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = dateFormatter.parse(dateString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        return date;
    }
}
