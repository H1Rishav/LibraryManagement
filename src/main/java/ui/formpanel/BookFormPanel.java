/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.formpanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookFormPanel extends JPanel {
    private JTextField titleField;
    private JTextField authorField;
    private JTextField genreField;
    private JButton addBtn;
    private JButton clearBtn;
    private JButton backBtn;
    public BookFormPanel() {
        setBounds(0, 0, 700, 500);
        setLayout(null);

        JLabel lblTitle = new JLabel("Book's Name");
        lblTitle.setBounds(190, 70, 140, 30);
        add(lblTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setBounds(190, 120, 140, 30);
        add(lblAuthor);

        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setBounds(190, 170, 140, 30);
        add(lblGenre);

        titleField = new JTextField();
        titleField.setBounds(290, 70, 160, 25);
        add(titleField);
        titleField.setColumns(10);

        authorField = new JTextField();
        authorField.setBounds(290, 120, 160, 25);
        add(authorField);
        authorField.setColumns(10);

        genreField = new JTextField();
        genreField.setBounds(290, 170, 160, 25);
        add(genreField);
        genreField.setColumns(10);

        addBtn = new JButton("Add Book");
        addBtn.setBounds(220, 260, 200, 23);
        add(addBtn);
        
        clearBtn=new JButton("Clear Form");
        clearBtn.setBounds(220, 300, 200, 23);
        add(clearBtn);
        backBtn=new JButton("Back");
        backBtn.setBounds(220,340,200,23);
        add(backBtn);
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
    }

    public JTextField getAuthorField() {
        return authorField;
    }

    public void setAuthorField(JTextField authorField) {
        this.authorField = authorField;
    }

    public JTextField getGenreField() {
        return genreField;
    }

    public void setGenreField(JTextField genreField) {
        this.genreField = genreField;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }

    public void setClearBtn(JButton clearBtn) {
        this.clearBtn = clearBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }
    
    



}
