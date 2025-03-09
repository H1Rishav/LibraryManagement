/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueFrame;

import Entities.Book;
import Entities.Student;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import services.BookService;
import services.StudentService;
import tables.BooksFrame;
import ui.formpanel.BookFormPanel;

/**
 *
 * @author HP
 */
public class IssueBookFrame extends JFrame {

    Book book;
    StudentService studentService;
    BookService bookService;
    JLabel bookAuthor;
    JLabel bookTitle;
    JLabel bookGenre;
    JLabel bookStatus;
    JLabel bookAuthorlb;
    JLabel bookTitlelb;
    JLabel bookGenrelb;
    JLabel bookStatuslb;
    Student student;
    JLabel id1;
    JButton viewStudent;
    JTextField id1txt;
    JButton Issue;
    JButton Back;

    public IssueBookFrame(final int id, final int hello) {

        bookTitle = new JLabel("title");
        bookTitle.setBounds(120, 50, 100, 23);

        bookAuthor = new JLabel("author");
        bookAuthor.setBounds(120, 100, 100, 23);

        bookGenre = new JLabel("genre");
        bookGenre.setBounds(120, 150, 100, 23);

        bookStatus = new JLabel("status");
        bookStatus.setBounds(120, 200, 100, 23);

        bookTitlelb = new JLabel("Title :");
        bookTitlelb.setBounds(70, 50, 100, 23);

        bookAuthorlb = new JLabel("Author :");
        bookAuthorlb.setBounds(70, 100, 100, 23);

        bookGenrelb = new JLabel("Genre :");
        bookGenrelb.setBounds(70, 150, 100, 23);

        bookStatuslb = new JLabel("Status :");
        bookStatuslb.setBounds(70, 200, 100, 23);

        id1 = new JLabel("Student's id");
        id1.setBounds(70, 280, 100, 23);

        id1txt = new JTextField();
        id1txt.setBounds(160, 280, 120, 20);

        viewStudent = new JButton("View");
        viewStudent.setBounds(400, 370, 140, 20);

        Issue = new JButton("Issue");
        Issue.setBounds(80, 370, 140, 20);

        Back = new JButton("Back");
        Back.setBounds(240, 370, 140, 20);

        book = new Book();
        bookService = new BookService();
        book = bookService.findById(hello);

        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
        bookGenre.setText(book.getGenre());
        bookStatus.setText(book.getStatus());

        add(bookTitle);
        add(bookAuthor);
        add(bookGenre);
        add(bookStatus);
        add(bookTitlelb);
        add(bookAuthorlb);
        add(bookGenrelb);
        add(bookStatuslb);
        add(id1);
        add(id1txt);
        add(Issue);
        add(Back);
        add(viewStudent);

        Issue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                student = new Student();
                studentService = new StudentService();
                int id3 = Integer.parseInt(id1txt.getText());
                student = studentService.findById(id3);
                System.out.println(student);
                book.setStatus("Issued");
                System.out.println(book);
                student.getBookList().add(book);
                System.out.println(student.getBookList());
                studentService.update(student);
            }

        });
        viewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id3 = Integer.parseInt(id1txt.getText());
                new IssueStudentFrame(id, hello, id3);
                dispose();
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new BooksFrame(id, 0);
                dispose();
            }
        });
        setTitle("Issuing Book");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);
    }

   
}
