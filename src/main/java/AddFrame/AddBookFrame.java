package AddFrame;

import Entities.Book;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.BookService;
import ButtonFrame.AdminButtonFrame;
import tables.BooksFrame;
import ui.formpanel.BookFormPanel;

public class AddBookFrame extends JFrame {

    BookFormPanel bookFormPanel;
    BookService bookService = new BookService();

    public AddBookFrame(int id, int id1) {
        initialize(id, id1);
    }

    private void initialize(final int id, final int id1) {

        bookFormPanel = new BookFormPanel();
        getContentPane().add(bookFormPanel);

        bookFormPanel.getAddBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (bookFormPanel.getAuthorField().getText().isEmpty() || (bookFormPanel.getTitleField().getText().isEmpty()) || (bookFormPanel.getGenreField().getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    Book book = new Book();
                    book.setTitle(bookFormPanel.getTitleField().getText());
                    book.setAuthor(bookFormPanel.getAuthorField().getText());
                    book.setGenre(bookFormPanel.getGenreField().getText());
                    book.setStatus("available");
                    bookService.persist(book);
                    JOptionPane.showMessageDialog(null, "Book added successfully");
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
                new BooksFrame(id, 0);
                dispose();
            }
        });

        setTitle("Add New Book");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }
}
