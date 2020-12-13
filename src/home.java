/*
 * The home page of the application 
 */

import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class home extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static home mainframe;
	private JPanel contentPane;
	
	// Launching the application
	public static void main ( String[] args )
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel home = new JLabel("Library Management System");
		home.setFont(new Font("Tahoma", Font.PLAIN, 22));
		home.setForeground(Color.GRAY);
		
		JButton studentPanel = new JButton("Student Panel");
	    studentPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		studentPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			student.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton issueBook = new JButton("Issue Book");
		issueBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			issue.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton btnreturnBook = new JButton("Return Book");
		btnreturnBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnreturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			returnBook.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton bookRecord = new JButton("Book Record");
		bookRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				record.main(new String[]{});
				mainframe.dispose();
			}
		});
		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainframe.dispose();
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(home, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(studentPanel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnreturnBook, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookRecord, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(exit, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE)
		 ));
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(home, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(studentPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnreturnBook, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(bookRecord, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(exit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
