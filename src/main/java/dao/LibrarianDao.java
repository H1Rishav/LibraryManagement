/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entities.Librarian;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class LibrarianDao implements LibrarianDaoInterface<Librarian,Integer> {
    
    private Session currentSession;
    private Transaction currentTransaction;
    public LibrarianDao(){}
    
     public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Librarian.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                                                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Librarian entity) {
        getCurrentSession().save(entity);
    }

    public void update(Librarian entity) {
        getCurrentSession().update(entity);
    }

    public Librarian findById(Integer id) {
        Librarian librarian = (Librarian) getCurrentSession().get(Librarian.class, id);
        return librarian;
    }
    
    public Librarian findByEmail(String email){
        Librarian librarian = (Librarian)getCurrentSession().createQuery("select l from Librarian l where l.email = :email").setParameter("email", email).getSingleResult();        
        return librarian;
    }


    public void delete(Librarian entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Librarian> findAll() {
        List<Librarian> librarian = (List<Librarian>) getCurrentSession().createQuery("from Librarian").list();
        return librarian;
    }

    public void deleteAll() {
        List<Librarian> entityList = findAll();
        for (Librarian entity : entityList) {
            delete(entity);
        }
    }
}
