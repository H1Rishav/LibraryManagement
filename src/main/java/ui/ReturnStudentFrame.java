/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

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
public class ReturnStudentFrame extends JFrame {

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
    JLabel gradelb;

    public ReturnStudentFrame(final int id, final int id1, final int id2) {
        fName = new JLabel("First Name");
        lName = new JLabel("Last Name");
        email = new JLabel("Email");
        grade = new JLabel("Grade");
        Back = new JButton("Back");
        fNamelb = new JLabel("First Name");
        lNamelb = new JLabel("Last Name");
        emaillb = new JLabel("Email");
        gradelb = new JLabel("Grade");
        Back = new JButton("Back");
        student = new Student();
        studentService = new StudentService();
        student = studentService.findById(id2);
        fName.setText(student.getfName());
        lName.setText(student.getlName());
        email.setText(student.getEmail());
        grade.setText(student.getGrade() + "");
        fNamelb.setBounds(40, 50, 100, 23);
        lNamelb.setBounds(40, 100, 100, 23);
        emaillb.setBounds(40, 150, 100, 23);
        gradelb.setBounds(40, 200, 100, 23);

        fName.setBounds(110, 50, 100, 23);
        lName.setBounds(110, 100, 100, 23);
        email.setBounds(110, 150, 100, 23);
        grade.setBounds(110, 200, 100, 23);
        Back.setBounds(100, 250, 100, 23);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ReturnBookFrame(id, id1);
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
        add(gradelb);

        setTitle("Viewing Student");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null);

    }
}
