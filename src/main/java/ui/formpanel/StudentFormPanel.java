/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.formpanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class StudentFormPanel extends JPanel {
    private JTextField fNameField;
    private JTextField lNameField;
    private JTextField emailField;
    private JTextField gradeField;
    private JButton addBtn;
    private JButton clearBtn;
    private JButton backBtn;
    public StudentFormPanel() {
        setBounds(0, 0, 700, 500);
        setLayout(null);

        JLabel lblfName = new JLabel("First Name");
        lblfName.setBounds(190, 50, 140, 30);
        add(lblfName);

        JLabel lbllName = new JLabel("Last Name");
        lbllName.setBounds(190, 100, 140, 30);
        add(lbllName);

        JLabel lblEmailId = new JLabel("Email Id");
        lblEmailId.setBounds(190, 200, 140, 30);
        add(lblEmailId);
        JLabel lblGrade=new JLabel("Grade");
        lblGrade.setBounds(190,150,140,30);
        add(lblGrade);
        fNameField = new JTextField();
        fNameField.setBounds(290, 50, 160, 25);
        add(fNameField);
       // fNameField.setColumns(10);

        lNameField = new JTextField();
        lNameField.setBounds(290, 100, 160, 25);
        add(lNameField);
       // lNameField.setColumns(10);
        
        gradeField=new JTextField();
        gradeField.setBounds(290,150,160,25);
        add(gradeField);

        emailField = new JTextField();
        emailField.setBounds(290, 200, 160, 25);
        add(emailField);
      //  emailField.setColumns(10);

        addBtn = new JButton("Add Student");
        addBtn.setBounds(220, 250, 200, 23);
        add(addBtn);
        
        clearBtn = new JButton("Clear Form");
        clearBtn.setBounds(220, 290, 200, 23);
        add(clearBtn);
        
        backBtn=new JButton("Back");
        backBtn.setBounds(220,330,200,23);
        add(backBtn);
    }

    public JTextField getfNameField() {
        return fNameField;
    }

    public void setfNameField(JTextField fNameField) {
        this.fNameField = fNameField;
    }

    public JTextField getlNameField() {
        return lNameField;
    }

    public void setlNameField(JTextField lNameField) {
        this.lNameField = lNameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getGradeField() {
        return gradeField;
    }

    public void setGradeField(JTextField gradeField) {
        this.gradeField = gradeField;
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
