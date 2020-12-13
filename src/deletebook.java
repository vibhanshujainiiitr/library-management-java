import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import com.mysql.*;
import java.sql.*;

/*
 * To delete the book from the database. The admin is need to enter just the book ID for that.
 */
public class deletebook extends JFrame {
	
	static deletebook mainframe;
	private JPanel contentPane;
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
					mainframe = new deletebook();
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
	public deletebook()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labeldeletebook = new JLabel("Delete book");
		labeldeletebook.setForeground(Color.GRAY);
		labeldeletebook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel labelrollNumber = new JLabel("Book ID");
				
		bookId_field =  new JTextField();
		bookId_field.setColumns(20);
				
		JButton btndeletebook = new JButton("Delete book");
		btndeletebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookId = bookId_field.getText();
				
				/*
				 * Deleting the new book to the database
				 */
				int i = 0;
				try
				{
					Connection con = database.getConnection();
					PreparedStatement book = con.prepareStatement("delete from book where bookId=?");
					
					book.setString(1, bookId);
					i = book.executeUpdate();
					con.close();
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(deletebook.this,"The books is deleted from the records");
					book.main(new String[]{});
					mainframe.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(deletebook.this,"Sorry, we are not able to please. Please try again !");
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
								.addComponent(labeldeletebook))
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(30)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(labelrollNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGap(47)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(bookId_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(125, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, mainLayout.createSequentialGroup()
						.addGap(161)
						.addComponent(btndeletebook, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
					.addGroup(mainLayout.createSequentialGroup()
						 .addContainerGap(350, Short.MAX_VALUE)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(100, Short.MAX_VALUE))
			);						
			mainLayout.setVerticalGroup(
				mainLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(mainLayout.createSequentialGroup()
						.addComponent(labeldeletebook)
						.addGap(50)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelrollNumber)
							.addComponent(bookId_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addComponent(btndeletebook, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnHome,  GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
			);
			contentPane.setLayout(mainLayout);
	}
	/*
	 * Public class deletebook ended here
	 */
	
	
}