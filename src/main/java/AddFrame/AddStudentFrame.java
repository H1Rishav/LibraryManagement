package AddFrame;

import Entities.Student;
import services.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tables.StudentsFrame;
import ui.MainFrame;
import ui.formpanel.StudentFormPanel;

public class AddStudentFrame extends JFrame {

    StudentFormPanel studentFormPanel;
    StudentService studentService = new StudentService();

    public AddStudentFrame(int id, int id2) {
        initialize(id, id2);
    }

    private void initialize(final int id, final int id2) {

        studentFormPanel = new StudentFormPanel();
        getContentPane().add(studentFormPanel);

        studentFormPanel.getAddBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (studentFormPanel.getfNameField().getText().isEmpty() || (studentFormPanel.getlNameField().getText().isEmpty()) || (studentFormPanel.getEmailField().getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    Student st = new Student();
                    st.setfName(studentFormPanel.getfNameField().getText());
                    st.setlName(studentFormPanel.getlNameField().getText());
                    st.setEmail(studentFormPanel.getEmailField().getText());
                    st.setGrade(Integer.parseInt(studentFormPanel.getGradeField().getText()));
                    studentService.persist(st);
                    JOptionPane.showMessageDialog(null, "Student added successfully");
                }

            }
        });

        studentFormPanel.getClearBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                studentFormPanel.getfNameField().setText("");
                studentFormPanel.getlNameField().setText("");
                studentFormPanel.getEmailField().setText("");
                studentFormPanel.getGradeField().setText("");
            }
        });
        studentFormPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new StudentsFrame(id, id2);
                dispose();
            }
        });
        setTitle("Add New Student");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }
}
