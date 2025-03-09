/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import Entities.Librarian;
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
import services.LibrarianService;
import javax.swing.table.TableModel;
import AddFrame.AddLibrarianFrame;
import ButtonFrame.AdminButtonFrame;
import UpdateFrame.UpdateLibrarianFrame;
import ui.MainFrame;

/**
 *
 * @author HP
 */
public class LibrarianFrame extends JFrame {

    JTable table;
    TableModel tableModel;
    LibrarianService librarianService;

    public LibrarianFrame() {
        librarianService = new LibrarianService();
        List<String> columns = new ArrayList<String>();
        List<Librarian> librarians = new ArrayList<Librarian>();
        librarians = librarianService.findAll();
        List<String[]> values = new ArrayList<String[]>();

        for (Librarian librarian : librarians) {
            values.add(new String[]{librarian.getId() + "", librarian.getfName(), librarian.getlName(), librarian.getEmail(), librarian.getContact(), librarian.getPassword(),librarian.getAccess()});
        }
        columns.add("Id");
        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Email");
        columns.add("Contact");
        columns.add("Password");
        columns.add("Access");

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
        buttonPanel.add(backBtn);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddLibrarianFrame();
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
                        librarianService.delete(id);
                        new LibrarianFrame();
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
                        int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                        new UpdateLibrarianFrame(id);
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
                AdminButtonFrame adminButtonFrame = new AdminButtonFrame();
                adminButtonFrame.setVisible(true);
                dispose();
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);
        setTitle("Librarian");

    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

}
