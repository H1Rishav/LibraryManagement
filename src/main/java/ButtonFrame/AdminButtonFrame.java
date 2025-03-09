/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tables.BooksFrame;
import tables.LibrarianFrame;
import tables.StudentsFrame;
import ui.MainFrame;

/**
 *
 * @author HP
 */
public class AdminButtonFrame extends JFrame {

    JButton Student;
    JButton Librarian;
    JButton Book;
    JButton Back;

    public AdminButtonFrame() {
        setTitle("Admin's First Page");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Librarian = new JButton("Librarian");
        Librarian.setBounds(240, 70, 190, 40);
        add(Librarian);
        Student = new JButton("Student");
        Student.setBounds(240, 150, 190, 40);
        add(Student);
        Book = new JButton("Book");
        Book.setBounds(240, 230, 190, 40);
        add(Book);
        Back = new JButton("Back");
        Back.setBounds(240, 310, 190, 40);
        add(Back);
        Librarian.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                new LibrarianFrame();
                dispose();
            }
        });
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentsFrame(1, 0);
                dispose();
            }
        });
        Book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new BooksFrame(1, 0);
                dispose();
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                dispose();
            }
        });

    }

}
