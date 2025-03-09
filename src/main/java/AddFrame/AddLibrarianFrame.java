/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddFrame;

import Entities.Book;
import Entities.Librarian;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import services.LibrarianService;
import tables.LibrarianFrame;
import ui.MainFrame;
import ui.formpanel.LibrarianFormPanel;

/**
 *
 * @author HP
 */
public class AddLibrarianFrame extends JFrame {

    LibrarianFormPanel librarianFormPanel;
    LibrarianService librarianService;

    public AddLibrarianFrame() {
        initialize();
    }

    private void initialize() {
        librarianService = new LibrarianService();

        librarianFormPanel = new LibrarianFormPanel();
        librarianFormPanel.setBounds(0, 0, 300, 400);
        add(librarianFormPanel);

        librarianFormPanel.getAddBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (librarianFormPanel.getfName().getText().isEmpty() || (librarianFormPanel.getlName().getText().isEmpty()) || (librarianFormPanel.getEmail().getText().isEmpty()) || (librarianFormPanel.getContact().getText().isEmpty()) || (librarianFormPanel.getPassword().getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    Librarian librarian = new Librarian();
                    librarian.setfName(librarianFormPanel.getfName().getText());
                    librarian.setlName(librarianFormPanel.getlName().getText());
                    librarian.setEmail(librarianFormPanel.getEmail().getText());
                    librarian.setContact(librarianFormPanel.getContact().getText());
                    librarian.setPassword(librarianFormPanel.getPassword().getText());
                    librarian.setAccess(librarianFormPanel.getAccess().getText());

                    librarianService.persist(librarian);
                    JOptionPane.showMessageDialog(null, "Librarian added successfully");
                }

            }

        });

        librarianFormPanel.getClearBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                librarianFormPanel.getfName().setText("");
                librarianFormPanel.getlName().setText("");
                librarianFormPanel.getEmail().setText("");
                librarianFormPanel.getContact().setText("");
                librarianFormPanel.getPassword().setText("");

            }
        });
        librarianFormPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new LibrarianFrame();
                dispose();
            }
        });
        setTitle("Add New Librarian");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }

}
