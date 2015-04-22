package org.sp.librairie.inventaire.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sp.librairie.inventaire.dao.ClientDao;
import org.sp.librairie.inventaire.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by varduhi on 9/17/2014.
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }
// GRUD OPERATIONS
    @Transactional
    @Override
    public void addClient(Client client) throws Exception{
        sessionFactory.getCurrentSession().save(client);

    }
    @Transactional
    @Override
    public void removeClient(Client client) throws Exception {
        sessionFactory.getCurrentSession().delete(client);
    }
    @Transactional
    @Override
    public void updateClient(Client client)throws Exception {
        sessionFactory.getCurrentSession().update(client);
    }
    @Transactional
    @Override
    public Client getClientById(Integer id) throws Exception{
        Client client=(Client)sessionFactory.getCurrentSession().get(Client.class, id);
        return client;
    }
    // END GRUD OPERATIONS

    // SEARCH OPERATIONS
    @Transactional
    @Override
    public List<Client> getAllClients() throws Exception{
        Query query=sessionFactory.getCurrentSession().createQuery("FROM Client  order by fname");
        List<Client> clients=( List<Client>)query.list();
        return clients;
    }
    @Transactional
    @Override
    public List<Client> searchClientByName(String name) throws Exception{
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Client.class);
        criteria.add(Restrictions.or(Restrictions.like("fName", name+"%"), Restrictions.like("lName", name+"%")));
       List<Client> clients=( List<Client>)criteria.list();

        return clients;
    }
    // END SEARCH OPERATIONS

    //NEED TO ADD BOOKS TO CLIENT
}
