/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.formpanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class LibrarianFormPanel extends JPanel {

    JLabel fNamelb;
    JLabel lNamelb;
    JLabel emaillb;
    JLabel contactlb;
    JLabel passwordlb;
    JLabel accesslb;
    JTextField fName;
    JTextField lName;
    JTextField email;
    JTextField contact;
    JTextField password;
    JTextField access;
    JButton addBtn;
    JButton clearBtn;
    JButton backBtn;

    LibrarianFormPanel librarianFormPanel;

    public LibrarianFormPanel() {
        setBounds(0, 0, 700, 500);
        setLayout(null);

        fNamelb = new JLabel("First Name");
        fNamelb.setBounds(190, 30, 140, 30);
        add(fNamelb);
        fName = new JTextField();
        fName.setBounds(290, 30, 160, 25);
        add(fName);
        lNamelb = new JLabel("Last Name");
        lNamelb.setBounds(190, 80, 140, 30);
        add(lNamelb);
        lName = new JTextField();
        lName.setBounds(290, 80, 160, 25);
        add(lName);
        emaillb = new JLabel("Email Id");
        emaillb.setBounds(190, 130, 140, 30);
        add(emaillb);
        email = new JTextField();
        email.setBounds(290, 130, 160, 25);
        add(email);
        contactlb = new JLabel("Contact");
        contactlb.setBounds(190, 180, 140, 30);
        add(contactlb);
        contact = new JTextField();
        contact.setBounds(290, 180, 160, 25);
        add(contact);
        passwordlb = new JLabel("Password");
        passwordlb.setBounds(190, 230, 140, 30);
        add(passwordlb);
        password = new JTextField();
        password.setBounds(290, 230, 160, 25);
        add(password);
        accesslb=new JLabel("Access");
        accesslb.setBounds(190,280,140,30);
        add(accesslb);
        access=new JTextField();
        access.setBounds(290,280,160,25);
        add(access);  
        addBtn = new JButton("Add Lb");
        addBtn.setBounds(230, 340, 200, 23);
        add(addBtn);
        clearBtn = new JButton("Clear Form");
        clearBtn.setBounds(230, 370, 200, 23);
        add(clearBtn);
        backBtn = new JButton("Back");
        backBtn.setBounds(230, 400, 200, 23);
        add(backBtn);

    }

    public JLabel getfNamelb() {
        return fNamelb;
    }

    public void setfNamelb(JLabel fNamelb) {
        this.fNamelb = fNamelb;
    }

    public JLabel getlNamelb() {
        return lNamelb;
    }

    public void setlNamelb(JLabel lNamelb) {
        this.lNamelb = lNamelb;
    }

    public JLabel getEmaillb() {
        return emaillb;
    }

    public void setEmaillb(JLabel emaillb) {
        this.emaillb = emaillb;
    }

    public JLabel getContactlb() {
        return contactlb;
    }

    public void setContactlb(JLabel contactlb) {
        this.contactlb = contactlb;
    }

    public JLabel getPasswordlb() {
        return passwordlb;
    }

    public void setPasswordlb(JLabel passwordlb) {
        this.passwordlb = passwordlb;
    }

    public JTextField getfName() {
        return fName;
    }

    public void setfName(JTextField fName) {
        this.fName = fName;
    }

    public JTextField getlName() {
        return lName;
    }

    public void setlName(JTextField lName) {
        this.lName = lName;
    }

    public JTextField getEmail() {
        return email;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public JTextField getContact() {
        return contact;
    }

    public void setContact(JTextField contact) {
        this.contact = contact;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }

    public void setClearBtn(JButton clearBtn) {
        this.clearBtn = clearBtn;
    }

    public LibrarianFormPanel getLibrarianFormPanel() {
        return librarianFormPanel;
    }

    public void setLibrarianFormPanel(LibrarianFormPanel librarianFormPanel) {
        this.librarianFormPanel = librarianFormPanel;
    }

    public JLabel getAccesslb() {
        return accesslb;
    }

    public void setAccesslb(JLabel accesslb) {
        this.accesslb = accesslb;
    }

    public JTextField getAccess() {
        return access;
    }

    public void setAccess(JTextField access) {
        this.access = access;
    }

}

