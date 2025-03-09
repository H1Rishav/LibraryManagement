/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import Entities.Student;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import services.StudentService;
import AddFrame.AddStudentFrame;
import ButtonFrame.AdminButtonFrame;
import ButtonFrame.LibrarianButtonFrame;
import ui.MainFrame;
import UpdateFrame.UpdateStudentFrame;

public class StudentsFrame extends JFrame {

    JTable table;
    TableModel tableModel;
    StudentService studentService;

    public StudentsFrame(final int id,final int id2) {
        studentService = new StudentService();
        List<String> columns = new ArrayList<String>();
        List<Student> students = new ArrayList<Student>();
        students = studentService.findAll();
        List<String[]> values = new ArrayList<String[]>();

        for (Student s : students) {
            values.add(new String[]{s.getId() + "", s.getfName(), s.getlName(), s.getEmail(), s.getGrade() + ""});
        }
        columns.add("ID");
        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Email");
        columns.add("Grade");

        tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());
        table = new JTable(tableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(table.getTableHeader(), BorderLayout.NORTH);

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton backBtn = new JButton("Back");
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backBtn);
        add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentFrame(id,0);
                dispose();
            }

        });
        removeButton.addActionListener(new ActionListener() {
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
                        int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                        studentService.delete(id);
                        new StudentsFrame(id,0);
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
                        int id3 = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                        new UpdateStudentFrame(id,id3);
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

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);
        setTitle("Students");

    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }


}
