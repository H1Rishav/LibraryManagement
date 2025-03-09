/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Entities.Book;
import Entities.Student;
import IssueFrame.IssueStudentFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import services.BookService;
import services.StudentService;
import tables.BooksFrame;

/**
 *
 * @author HP
 */
public class ReturnBookFrame extends JFrame {

    JTextField studentId;
    JButton Ok;
    JLabel studentIdlbl;
    JLabel bookName;
    JLabel bookAuthor;
    JLabel bookGenre;
    JLabel bookNamelb;
    JLabel bookAuthorlb;
    JLabel bookGenrelb;
    Book book;
    BookService bookService;
    JButton Back;
    JButton viewStudent;
    Student student;
    StudentService studentService;

    public ReturnBookFrame(final int id, final int id2) {
        book = new Book();
        bookService = new BookService();
        book = bookService.findById(id2);
        studentId = new JTextField();
        studentId.setBounds(150, 50, 100, 23);
        studentIdlbl = new JLabel("Student's Id");
        studentIdlbl.setBounds(50, 50, 100, 23);
        bookName = new JLabel(book.getTitle());
        bookName.setBounds(110, 150, 100, 23);
        bookNamelb = new JLabel("Title:");
        bookNamelb.setBounds(50, 150, 100, 23);
        bookAuthor = new JLabel(book.getAuthor());
        bookAuthor.setBounds(110, 200, 100, 23);
        bookAuthorlb = new JLabel("Author");
        bookAuthorlb.setBounds(50, 200, 100, 23);
        bookGenre = new JLabel(book.getGenre());
        bookGenre.setBounds(110, 250, 100, 23);
        bookGenrelb = new JLabel("Genre");
        bookGenrelb.setBounds(50, 250, 100, 23);
        Ok = new JButton("OK");
        Ok.setBounds(140, 140, 120, 20);
        Back = new JButton("Back");
        Back.setBounds(140, 280, 120, 20);
        viewStudent = new JButton("View");
        viewStudent.setBounds(140, 320, 120, 20);
        viewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id3 = Integer.parseInt(studentId.getText());
                new ReturnStudentFrame(id, id2, id3);
                dispose();
            }
        });
        Ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id2 = Integer.parseInt(studentId.getText());
                student = new Student();
                studentService = new StudentService();
                student = studentService.findById(id2);
                System.out.println(student);
                //bookService = new BookService();
                //book = bookService.findById(id);
                List<Book> books = new ArrayList<Book>();
                /*for (Book b : student.getBookList()) {
                    if (b.getIsbn() == id) {
                        b.setStatus("Available");
                        bookService.update(b);
                    }
                }*/

                for (Book b : student.getBookList()) {
                    if (b.getIsbn() != id) {
                        books.add(b);
                    } else {
                        b.setStatus("Available");
                        bookService.update(b);
                    }
                }
                student.setBookList(books);
                studentService.update(student);

            }

        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BooksFrame(id, 0);
                dispose();
            }
        });

        add(studentId);
        add(studentIdlbl);
        add(Ok);
        add(bookName);
        add(bookAuthor);
        add(bookGenre);
        add(bookNamelb);
        add(bookAuthorlb);
        add(bookGenrelb);
        add(Back);
        add(viewStudent);

        setTitle("Returning Book ");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);
    }

}
