package org.sp.librairie.inventaire.service;

import org.sp.librairie.inventaire.dao.ClientDao;
import org.sp.librairie.inventaire.model.Client;

import java.util.List;

/**
 * Created by varduhi on 1/7/2015.
 */
public class ClientService {
    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) throws Exception {
        this.clientDao = clientDao;
    }
    public  void addClient(Client client)throws Exception{
        clientDao.addClient(client);
    }
    public void removeClient(Client client)throws Exception{
        clientDao.removeClient(client);
    }
    public  void updateClient(Client client)throws Exception{
        clientDao.updateClient(client);
    }
    public List<Client> getAllClients()throws Exception{
       return clientDao.getAllClients();
    }
    public Client getClientById(Integer id) throws Exception{
       return clientDao.getClientById(id);

    }
}
