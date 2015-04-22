package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionSupport;
import org.sp.librairie.inventaire.model.Sales;
import org.sp.librairie.inventaire.service.SalesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by varduhi on 12/27/2014.
 */
public class SalesReportAction  extends ActionSupport{
    private String startDate;
    private  String endDate;
    private List<Sales> salesList;
    private SalesService salesService;

    public void setSalesService(SalesService salesService) {
        this.salesService = salesService;
    }

    public String execute(){
        //Get list of  sales by period specified (gets and shows the last sales by default)
        if(startDate==null && endDate==null){
            salesList=salesService.getLastSales();
        }else{
            salesList=salesService.getSalesByDate(parseToDate(getStartDate()), parseToDate(endDate));
        }
        return SUCCESS;
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

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    private Date parseToDate(String dateString){

        Date date = null;
        if(dateString!=null && !dateString.trim().isEmpty()) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = dateFormatter.parse(dateString);
                System.out.println(date);

            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        return date;
    }
}
