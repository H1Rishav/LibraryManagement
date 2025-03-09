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
import tables.StudentsFrame;
import ui.MainFrame;

/**
 *
 * @author HP
 */
public class LibrarianButtonFrame extends JFrame {

    JButton Student;
    JButton Book;
    JButton Back;

    public LibrarianButtonFrame() {

        Student = new JButton("Student");
        Student.setBounds(250, 100, 190, 40);
        add(Student);
        Book = new JButton("Book");
        Book.setBounds(250, 200, 190, 40);
        add(Book);
        Back = new JButton("Back");
        Back.setBounds(250, 300, 190, 40);
        add(Back);
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentsFrame(2, 0);
                dispose();
            }
        });
        Book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new BooksFrame(2, 0);
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
        setTitle("Librarian's First Page");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }

}
