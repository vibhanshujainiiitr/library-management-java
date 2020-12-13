import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

/*
 * The main class for all the activities on the books 
 */

public class record extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static record mainframe;
	private JPanel contentPane;
	
	// Launching the application
	public static void main ( String[] args )
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new record();
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
	public record() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel record = new JLabel("Book Records");
		record.setFont(new Font("Tahoma", Font.PLAIN, 22));
		record.setForeground(Color.GRAY);
		
		JButton newBook = new JButton("New Book");
	    newBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			newbook.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton deleteBook = new JButton("Delete Book");
		deleteBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			deletebook.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		JButton searchBook = new JButton("Search Book");
	    searchBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * issuedbooks.main(new String[]{});
				 * mainframe.dispose();
				 */
				JOptionPane.showMessageDialog(record.this,"This section is under development !");	
				}
		});
		
		JButton allBooks = new JButton("All Book");
	    allBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		allBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*
			 * allbooks.main(new String[]{});
			 * mainframe.dispose();
			 */
			JOptionPane.showMessageDialog(record.this,"This section is under development !");	
			}
		});
		
		JButton issuedBooks = new JButton("Issued Books");
		issuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		issuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*
			 * issuedbooks.main(new String[]{});
			 * mainframe.dispose();
			 */
			JOptionPane.showMessageDialog(record.this,"This section is under development !");	
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
		
		
		GroupLayout mainlayout = new GroupLayout(contentPane);
		mainlayout.setHorizontalGroup(
			mainlayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(mainlayout.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(record, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(Alignment.LEADING, mainlayout.createSequentialGroup()
					.addGap(134)
					.addGroup(mainlayout.createParallelGroup(Alignment.LEADING)
						.addComponent(newBook, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteBook, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBook, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(allBooks, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(issuedBooks, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE)
		 ));
		mainlayout.setVerticalGroup(
			mainlayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainlayout.createSequentialGroup()
					.addComponent(record, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(newBook, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(deleteBook, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(searchBook, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(allBooks, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(issuedBooks, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(mainlayout);
	}
	
}
