package org.sp.librairie.inventaire.dao;

import org.sp.librairie.inventaire.model.Client;

import java.util.List;

/**
 * Created by varduhi on 9/11/2014.
 */
public interface ClientDao {
    //GRUD OPERATIONS
    void addClient(Client client) throws Exception;

    void removeClient(Client client) throws Exception;

    void updateClient(Client client) throws Exception;

    Client getClientById(Integer id) throws Exception;

    List<Client> getAllClients() throws Exception;

    //Search Operations
   List<Client> searchClientByName(String name) throws Exception;
}
