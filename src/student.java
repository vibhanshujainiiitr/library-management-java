import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

/*
 * The main class for all the activities related to the student
 */

public class student extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static student mainframe;
	private JPanel contentPane;
	
	// Launching the application
	public static void main ( String[] args )
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new student();
					mainframe.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		} );
	}
	
	// Now we need to create the frame
	public student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel student = new JLabel("Student Panel");
		student.setFont(new Font("Tahoma", Font.PLAIN, 22));
		student.setForeground(Color.GRAY);
		
		JButton addStudent = new JButton("Add Student");
	    addStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			newStudent.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton delStudent = new JButton("Delete Student");
		delStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			deleteStudent.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton editDetails = new JButton("Edit Student");
		editDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			editStudent.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton schStudent = new JButton("Search Student");
		schStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		schStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchStudent.main(new String[]{});
				mainframe.dispose();
			}
		});
		JButton btnhome = new JButton("Home");
		btnhome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			home.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(student, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(addStudent, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(delStudent, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(editDetails, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(schStudent, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE)
		 ));
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(student, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(addStudent, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(delStudent, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(editDetails, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(schStudent, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
