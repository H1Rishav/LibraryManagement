/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Librarian;
import dao.LibrarianDao;
import java.util.List;

/**
 *
 * @author HP
 */
public class LibrarianService {
    private static LibrarianDao librarianDao;
    public LibrarianService(){
    librarianDao=new LibrarianDao();
    }
    
     public void persist(Librarian entity) {
         System.out.println(entity);
        librarianDao.openCurrentSessionwithTransaction();
        librarianDao.persist(entity);
        librarianDao.closeCurrentSessionwithTransaction();
    }

    public void update(Librarian entity) {
        librarianDao.openCurrentSessionwithTransaction();
        librarianDao.update(entity);
        librarianDao.closeCurrentSessionwithTransaction();
    }

    public Librarian findById(int id) {
        librarianDao.openCurrentSession();
        Librarian librarian= librarianDao.findById(id);
        librarianDao.closeCurrentSession();
        return librarian;
    }
    public void delete(int id) {
        librarianDao.openCurrentSessionwithTransaction();
        Librarian librarian = librarianDao.findById(id);
        librarianDao.delete(librarian);
        librarianDao.closeCurrentSessionwithTransaction();
    }

    public List<Librarian> findAll() {
        librarianDao.openCurrentSession();
        List<Librarian> librarians = librarianDao.findAll();
        librarianDao.closeCurrentSession();
        return librarians;
    }

    public void deleteAll() {
        librarianDao.openCurrentSession();
        librarianDao.deleteAll();
        librarianDao.closeCurrentSession();
    }

    public LibrarianDao librarianDao() {
        return librarianDao;
    }
    
    public Librarian findByEmail(String email){
        librarianDao.openCurrentSessionwithTransaction();
        Librarian librarian = librarianDao.findByEmail(email);
        librarianDao.closeCurrentSessionwithTransaction();
        return librarian;
    }
}
