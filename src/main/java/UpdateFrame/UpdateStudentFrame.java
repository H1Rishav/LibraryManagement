/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateFrame;

import ButtonFrame.AdminButtonFrame;
import ButtonFrame.LibrarianButtonFrame;
import Entities.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import services.StudentService;
import tables.StudentsFrame;
import ui.formpanel.StudentFormPanel;

/**
 *
 * @author HP
 */
public class UpdateStudentFrame extends JFrame {

    StudentFormPanel studentFormPanel;
    StudentService studentService;
    Student st;

    public UpdateStudentFrame(int id, int id2) {
        initialize(id, id2);
    }

    private void initialize(final int id, final int id2) {
        studentService = new StudentService();
        st = studentService.findById(id2);
        

        studentFormPanel = new StudentFormPanel();
        add(studentFormPanel);
        studentFormPanel.getfNameField().setText(st.getfName());
        studentFormPanel.getlNameField().setText(st.getlName());
        studentFormPanel.getEmailField().setText(st.getEmail());
        studentFormPanel.getGradeField().setText(st.getGrade()+"");

        studentFormPanel.getAddBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (studentFormPanel.getfNameField().getText().isEmpty() || (studentFormPanel.getlNameField().getText().isEmpty()) || (studentFormPanel.getEmailField().getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    st.setfName(studentFormPanel.getfNameField().getText());
                    st.setlName(studentFormPanel.getlNameField().getText());
                    st.setEmail(studentFormPanel.getEmailField().getText());
                    st.setGrade(Integer.parseInt(studentFormPanel.getGradeField().getText()));

                    studentService.update(st);
                    JOptionPane.showMessageDialog(null, "Student updated successfully");

                }

            }
        });

        studentFormPanel.getClearBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                studentFormPanel.getfNameField().setText("");
                studentFormPanel.getlNameField().setText("");
                studentFormPanel.getEmailField().setText("");
            }
        });
        studentFormPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentsFrame(id, 0);
                dispose();
            }
        });
        setTitle("Updating Student");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }
}
