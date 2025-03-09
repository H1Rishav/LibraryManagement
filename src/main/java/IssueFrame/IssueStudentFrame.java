/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueFrame;

import Entities.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import services.StudentService;

/**
 *
 * @author HP
 */
public class IssueStudentFrame extends JFrame {

    StudentService studentService;
    Student student;
    JLabel fName;
    JLabel lName;
    JLabel email;
    JLabel grade;
    JButton Back;

    JLabel fNamelb;
    JLabel lNamelb;
    JLabel emaillb;
    JLabel gradel;
   

    public IssueStudentFrame(final int id, final int id2, final int id3) {
        fName = new JLabel("First Name");
        lName = new JLabel("Last Name");
        email = new JLabel("Email");
        grade = new JLabel("Grade");
        Back = new JButton("Back");
        fNamelb = new JLabel("First Name:");
        lNamelb = new JLabel("Last Name:");
        emaillb = new JLabel("Email Id:");
        gradel = new JLabel("Grade:");
        Back = new JButton("Back");
        student = new Student();
        studentService = new StudentService();
        student = studentService.findById(id3);
        fName.setText(student.getfName());
        lName.setText(student.getlName());
        email.setText(student.getEmail());
        grade.setText("67");
//grade.setText(student.getGrade()+"");
        fNamelb.setBounds(70, 70, 140, 23);
        lNamelb.setBounds(70, 120, 140, 23);
        emaillb.setBounds(70, 170, 140, 23);
        gradel.setBounds(70, 200, 140, 23);

        fName.setBounds(160, 70, 140, 23);
        lName.setBounds(160, 120, 140, 23);
        email.setBounds(160, 170, 140, 23);
        grade.setBounds(160, 220, 140, 23);

        Back.setBounds(100, 290, 100, 23);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new IssueBookFrame(id, id2);
                dispose();

            }
        });
        add(fName);
        add(lName);
        add(email);
        add(grade);
        add(Back);
        add(fNamelb);
        add(lNamelb);
        add(emaillb);
        add(gradel);

        setTitle("Viewing Student");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }
}
