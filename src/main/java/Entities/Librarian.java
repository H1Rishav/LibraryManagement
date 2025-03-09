/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "librarian")
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;
    @Column(name="fName")
    String fName;
    @Column(name="lName")
    String lName;
    @Column(name="contact")
    String contact;
    @Column(name="email")
    String email;
    @Column(name="password")
    String password;
    @Column(name="access")
    String access;

    public Librarian(int id, String fName, String lName, String contact, String email, String password, String access) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public Librarian(String fName, String lName, String contact, String email, String password, String access) {
        this.fName = fName;
        this.lName = lName;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    
    public Librarian() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Librarian{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", contact=" + contact + ", email=" + email + ", password=" + password + ", access=" + access + '}';
    }

   
   
    

}
