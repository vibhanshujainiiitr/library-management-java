import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import com.mysql.*;
import java.sql.*;

/*
 *	Return the book 
 */

public class returnBook extends JFrame {
	
	static returnBook mainframe;
	private JPanel contentPane;
	private JTextField rollNo_field;
	private JTextField bookId_field;

	/*
	 * Only needed Roll Number to delete from the database
	 */
	// The main application
	public static void main (String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new returnBook();
					mainframe.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		} );
	}
	
	// The main frame
	public returnBook()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelreturnBook = new JLabel("Return Book");
		labelreturnBook.setForeground(Color.GRAY);
		labelreturnBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel labelrollNumber = new JLabel("Roll No.");
		JLabel labelbookId = new JLabel("Book ID");
				
		rollNo_field =  new JTextField();
		rollNo_field.setColumns(20);
				
		bookId_field = new JTextField();
		bookId_field.setColumns(20);
		
		JButton btnreturnBook = new JButton("Return Book");
		btnreturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollNo = rollNo_field.getText();
				String bookId = bookId_field.getText();
				
				/*
				 * Deleting the book from the database
				 */
				int i = 0;
				try
				{
					Connection con = database.getConnection();
					PreparedStatement book = con.prepareStatement("delete from book where rollNo=? & bookId=?");
					
					book.setString(1, rollNo);
					book.setString(2, bookId);
					i = book.executeUpdate();
					con.close();
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(returnBook.this,"Book Return is saved !");
					student.main(new String[]{});
					mainframe.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(returnBook.this,"Sorry, we are not able to process. Please try again !");
				}
				
				/* 
				 * The action listener event e ended here
				 */
				}
			
			}
			/*
			 * The action listener ended here
			 */
		);
		
		/*
		 * Creating new button for reachinng to home
		 */
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			home.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		GroupLayout mainLayout = new GroupLayout(contentPane);
		
		mainLayout.setHorizontalGroup(
				mainLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(mainLayout.createSequentialGroup()
						.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(150)
								.addComponent(labelreturnBook))
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(30)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(labelrollNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelbookId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGap(47)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(rollNo_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(bookId_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(125, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, mainLayout.createSequentialGroup()
						.addGap(161)
						.addComponent(btnreturnBook, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
					.addGroup(mainLayout.createSequentialGroup()
						 .addContainerGap(350, Short.MAX_VALUE)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(100, Short.MAX_VALUE))
			);						
			mainLayout.setVerticalGroup(
				mainLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(mainLayout.createSequentialGroup()
						.addComponent(labelreturnBook)
						.addGap(50)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelrollNumber)
							.addComponent(rollNo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelbookId)
								.addComponent(bookId_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addComponent(btnreturnBook, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnHome,  GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
			);
			contentPane.setLayout(mainLayout);
	}
	/*
	 * Public class returnBook ended here
	 */
	
	
}