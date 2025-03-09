package ui;

import ButtonFrame.LibrarianButtonFrame;
import ButtonFrame.AdminButtonFrame;
import Entities.Book;
import Entities.Librarian;
import Entities.Student;
import java.awt.FlowLayout;
import services.StudentService;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.BookService;
import services.LibrarianService;
import tables.BooksFrame;
import tables.LibrarianFrame;
import tables.StudentsFrame;

public class MainFrame extends JFrame {

    JButton admin;
    JButton librarian;
    JButton addnew;
    JLabel usernamelbl;
    JTextField username;
    JLabel passwordlbl;
    JPasswordField password;
    JLabel Background;
    LibrarianService librarianService;

    public MainFrame() {

        librarianService = new LibrarianService();
        librarianService.findAll();
        new StudentService().findAll();
        new BookService().findAll();
        usernamelbl = new JLabel("Username");
        passwordlbl = new JLabel("Password");
        username = new JTextField();
        password = new JPasswordField(20);

        usernamelbl.setBounds(180, 50, 130, 20);
        add(usernamelbl);
        username.setBounds(280, 50, 170, 30);
        add(username);

        passwordlbl.setBounds(180, 140, 130, 20);
        add(passwordlbl);
        password.setBounds(280, 140, 170, 30);
        add(password);

        admin = new JButton("Admin");
        admin.setBounds(285, 220, 150, 30);
        add(admin);
        librarian = new JButton("Librarian");
        librarian.setBounds(285, 280, 150, 30);
        add(librarian);
        addnew = new JButton("Add New");
        addnew.setBounds(285, 340, 150, 30);
        add(addnew);
        ImageIcon back_ground = new ImageIcon("hello.jpg");
        Background = new JLabel("", back_ground, JLabel.CENTER);
        Background.setBounds(0, 0, 700, 500);
        add(Background);

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = password.getPassword();
                String passString = new String(pass);

                Librarian librarian = librarianService.findByEmail(username.getText());
                //   System.out.println(librarian);
                if (username.getText().equals("") || passString.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill in all given fields");
                } else if (!passString.equals(librarian.getPassword()) && !passString.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter your username and password correctly");

                } else if (librarian.getAccess().equalsIgnoreCase("librarian")) {
                    JOptionPane.showMessageDialog(null, "Access denied");
                } else if (librarian.getAccess().equalsIgnoreCase("Admin") && librarian.getPassword().equals(passString)) {
                    new AdminButtonFrame() {
                    };
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error code: 900. your username or password is incorrect");
                }

            }
        });
        librarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = password.getPassword();
                String passString = new String(pass);

                if (username.getText().equals("") || passString.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill in all given fields");
                } else {
                    Librarian librarian = librarianService.findByEmail(username.getText());
                    System.out.println(librarian);
                    if (librarian.getPassword().equals(passString)) {
                        new LibrarianButtonFrame();
                        dispose();
                    } else if (librarian.getAccess().equalsIgnoreCase("admin")) {
                        JOptionPane.showMessageDialog(null, "Access denied");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error code: 900. your username or password is incorrect");
                    }

                }

            }
        });
        addnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setTitle("Login Frame");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }

}
