package com.techEazy.techEazy.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.techEazy.techEazy.entity.Client;

@Repository
public class ClientDao {
    @Autowired
    private SessionFactory factory;
    
    public String addClient(Client client) {
        Session session = null;
        Transaction tx = null;
        String msg = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.merge(client);  // Changed to merge
            tx.commit();
            msg = "Client added successfully.";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return msg;
    }


    public String updateClient(Client client) {
        Session session = null;
        Transaction tx = null;
        String msg = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Client existingClient = session.get(Client.class, client.getId());
            existingClient.setName(client.getName());
            session.merge(existingClient);
            tx.commit();
            msg = "Client updated successfully.";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return msg;
    }

    public String deleteClient(Long id) {
        Session session = null;
        Transaction tx = null;
        String msg = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            tx.commit();
            msg = "Client deleted successfully.";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return msg;
    }

    public Client getClientById(Long id) {
        Session session = null;
        Transaction tx = null;
        Client client = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            client = session.get(Client.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return client;
    }

    public List<Client> getAllClients() {
        Session session = null;
        Transaction tx = null;
        List<Client> clients = null;
        String strQuery = "select distinct c from Client c";

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query<Client> query = session.createQuery(strQuery, Client.class);
            clients = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return clients;
    }


    public Client getClientById1(Long id) {
        Session session = null;
        Transaction tx = null;
        Client client = null;
        String strQuery = "from Client where id=:id";  // Querying by 'id', not 'name'

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query<Client> query = session.createQuery(strQuery, Client.class);
            query.setParameter("id", id);  // Correct parameter set for 'id'
            client = query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return client;
    }
}
