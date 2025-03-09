package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fname")
    private String fName;
    @Column(name="lName")
    private String lName;
    @Column(name="email")
    private String email;
   @Column(name="class")
    int grade;
   
    @OneToMany(fetch=FetchType.EAGER)
    private List<Book> bookList=new ArrayList<Book>();
    
    public Student(String fName, String lName, String email, List<Book> bookList) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.bookList = bookList;
    }

    public Student(int id, String fName, String lName, String email, int grade) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.grade = grade;
    }

    
    
    public Student(String fName, String lName, String email, int grade) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.grade = grade;
    }


    public Student(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", grade=" + grade + ", bookList=" + bookList + '}';
    }

    
}
