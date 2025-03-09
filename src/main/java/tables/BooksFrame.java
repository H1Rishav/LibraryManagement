/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import Entities.Book;
import Entities.Student;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import services.BookService;
import services.StudentService;
import AddFrame.AddBookFrame;
import AddFrame.AddStudentFrame;
import ButtonFrame.AdminButtonFrame;
import IssueFrame.IssueBookFrame;
import ButtonFrame.LibrarianButtonFrame;
import ui.MainFrame;
import ui.ReturnBookFrame;
import UpdateFrame.UpdateBookFrame;
import UpdateFrame.UpdateStudentFrame;

/**
 *
 * @author HP
 */
public class BooksFrame extends JFrame {

    JTable table;
    TableModel tableModel;
    BookService bookService;
    Book book;

    public BooksFrame(final int id,final int id1) {
        bookService = new BookService();
        List<String> columns = new ArrayList<String>();
        List<Book> books = new ArrayList<Book>();
        books = bookService.findAll();
        List<String[]> values = new ArrayList<String[]>();

        for (Book book : books) {
            values.add(new String[]{book.getIsbn() + "", book.getTitle(), book.getAuthor(), book.getGenre(), book.getStatus()});
        }
        columns.add("ISBN");
        columns.add("Book Name");
        columns.add("Author");
        columns.add("Genre");
        columns.add("Status");

        tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());
        table = new JTable(tableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(table.getTableHeader(), BorderLayout.NORTH);

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton backBtn = new JButton("Back");
        JButton issueBtn = new JButton("Issue");
        JButton returnBtn = new JButton("Return");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backBtn);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(issueBtn);
        buttonPanel.add(returnBtn);
        add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookFrame(id,id1);
                dispose();
            }

        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow < 0) {
                        JOptionPane.showMessageDialog(null, "NON ROW SELECTED");

                    } else {
                        int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                        bookService.delete(id);
                        new BooksFrame(id,0);
                        dispose();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow < 0) {
                        JOptionPane.showMessageDialog(null,
                                "NON_ROW_SELECTED",
                                "ALERT_TILE",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        int hello = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                        new UpdateBookFrame(id,hello);
                        dispose();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id == 1) {
                    AdminButtonFrame adminButtonFrame = new AdminButtonFrame();
                    adminButtonFrame.setVisible(true);
                    dispose();
                }
                if (id == 2) {
                    LibrarianButtonFrame librarianButtonFrame = new LibrarianButtonFrame();
                    librarianButtonFrame.setVisible(true);
                    dispose();
                }
            }
        });
        issueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow2=0;
                selectedRow2 = table.getSelectedRow();
                String status = tableModel.getValueAt(selectedRow2, 4).toString();

                if (selectedRow2 < 0) {
                    JOptionPane.showMessageDialog(null,
                            "NON ROW SELECTED");

                } else if (status.equalsIgnoreCase("issued")) {
                    JOptionPane.showMessageDialog(null,
                            "BOOK NOT AVAILABLE");
                } else {
                    int id2 = Integer.parseInt(tableModel.getValueAt(selectedRow2, 0).toString());
                    new IssueBookFrame(id,id2);
                    dispose();
                }

            }

        });
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow < 0) {
                        JOptionPane.showMessageDialog(null, "NON_ROW_SELECTED");
                    }
                    int selectedRow2 = table.getSelectedRow();
                    String status = tableModel.getValueAt(selectedRow2, 4).toString();
                    if (status.equalsIgnoreCase("available")) {
                        JOptionPane.showMessageDialog(null, "The book has not been issued");
                    } else {
                        int id2 = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                        new ReturnBookFrame(id,id2);
                        dispose();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);
        setTitle("Books");

    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public BooksFrame() {
    }

}
