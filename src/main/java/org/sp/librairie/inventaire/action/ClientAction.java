package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.sp.librairie.inventaire.model.Client;
import org.sp.librairie.inventaire.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by varduhi on 1/12/2015.
 */

public class ClientAction extends ActionSupport implements Preparable {
    private ClientService clientService;
    List<Client> clientList;

    private Client client;
    private int id;


    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @SkipValidation
    public String execute() {
        return SUCCESS;
    }

    @SkipValidation
    //Prepare web page for save new client -next save
    public String add() {
        return ActionResult.ADD;
    }


    // Commit insert- next list
    public String save() {
        try {
            clientService.addClient(client);
            return ActionResult.LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.EXCEPTION;
        }

    }

    //prepare web page for update -next update
    @SkipValidation
    public String edit() {
        try {
            HttpServletRequest servletRequest = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            client = clientService.getClientById(Integer.parseInt(servletRequest.getParameter("id")));
            return ActionResult.EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.LIST;

        }

    }

    //Commit update -next list
    public String update() {
        try {
            clientService.updateClient(client);
            return ActionResult.LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.EXCEPTION;
        }

    }
@SkipValidation
    public String delete() {
        try {
            HttpServletRequest servletRequest = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            client = clientService.getClientById(Integer.parseInt(servletRequest.getParameter("id")));
            clientService.removeClient(client);
            return ActionResult.LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.EXCEPTION;
        }


    }

    @Override
    public void prepare() throws Exception {
        clientList = clientService.getAllClients();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

