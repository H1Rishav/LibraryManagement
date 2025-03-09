/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateFrame;

import ButtonFrame.AdminButtonFrame;
import ButtonFrame.LibrarianButtonFrame;
import Entities.Book;
import Entities.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import services.BookService;
import services.StudentService;
import tables.BooksFrame;
import ui.formpanel.BookFormPanel;
import ui.formpanel.StudentFormPanel;

/**
 *
 * @author HP
 */
public class UpdateBookFrame extends JFrame {

    BookFormPanel bookFormPanel;
    BookService bookService;
    Book book;

    public UpdateBookFrame(int id, int id2) {
        initialize(id, id2);
    }

    private void initialize(final int id, final int id2) {
        bookService = new BookService();
        book = bookService.findById(id2);

        bookFormPanel = new BookFormPanel();
        add(bookFormPanel);
        bookFormPanel.getAuthorField().setText(book.getAuthor());
        bookFormPanel.getTitleField().setText(book.getTitle());
        bookFormPanel.getGenreField().setText(book.getGenre());

        bookFormPanel.getAddBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (bookFormPanel.getAuthorField().getText().isEmpty() || bookFormPanel.getTitleField().getText().isEmpty() || bookFormPanel.getGenreField().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    book.setTitle(bookFormPanel.getTitleField().getText());
                    book.setAuthor(bookFormPanel.getAuthorField().getText());
                    book.setGenre(bookFormPanel.getGenreField().getText());
                    bookService.update(book);
                    JOptionPane.showMessageDialog(null, "Book updated successfully");
                }

            }
        });

        bookFormPanel.getClearBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bookFormPanel.getTitleField().setText("");
                bookFormPanel.getAuthorField().setText("");
                bookFormPanel.getGenreField().setText("");
            }
        });
        bookFormPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id == 1) {
                    new BooksFrame(id, 0);
                    dispose();
                } else {
                    new LibrarianButtonFrame();
                    dispose();
                }
            }
        });

        setTitle("Updating Book ");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }

}
