package services;

import Entities.Student;
import dao.StudentDao;

import java.util.List;

public class StudentService {
    public static StudentDao sDao;

    public StudentService() {
        sDao=new StudentDao();
    }

    public void persist(Student entity) {
        sDao.openCurrentSessionwithTransaction();
        sDao.persist(entity);
        sDao.closeCurrentSessionwithTransaction();
    }


    public void update(Student entity) {
        sDao.openCurrentSessionwithTransaction();
        sDao.update(entity);
        sDao.closeCurrentSessionwithTransaction();
    }

    public Student findById(int id) {
        sDao.openCurrentSession();
        System.out.println(id);
        Student student = sDao.findById(id);
        sDao.closeCurrentSession();
        return student;
    }

    public void delete(int id) {
        sDao.openCurrentSessionwithTransaction();
        Student student = sDao.findById(id);
        sDao.delete(student);
        sDao.closeCurrentSessionwithTransaction();
    }

    public List<Student> findAll() {
        sDao.openCurrentSession();
        List<Student> students = sDao.findAll();
        sDao.closeCurrentSession();
        return students;
    }

    public void deleteAll() {
        sDao.openCurrentSessionwithTransaction();
        sDao.deleteAll();
        sDao.closeCurrentSessionwithTransaction();
    }

    public StudentDao sDao() {
        return sDao;
    }
    
    
}
