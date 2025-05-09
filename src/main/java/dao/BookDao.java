package dao;

import java.util.List;

import Entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class BookDao implements BookDaoInterface<Book, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public BookDao() {
    }

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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Book.class);
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

    public void persist(Book entity) {
        getCurrentSession().save(entity);
    }

    public void update(Book entity) {
        getCurrentSession().update(entity);
    }

    public Book findById(Integer id) {
        Book book = (Book) getCurrentSession().get(Book.class, id);
        return book;
    }



    public void delete(Book entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        return books;
    }

    public void deleteAll() {
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }
}