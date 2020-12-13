import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import com.mysql.*;
import java.sql.*;

/*
 * This class is to issue a book to the user
 */

public class issue extends JFrame {
	
	static issue mainframe;
	private JPanel contentPane;
	private JTextField name_field;
	private JTextField rollNo_field;
	private JTextField bookName_field;
	private JTextField bookId_field;
	private JTextField date_field;
	
	private JTextField issuedbookName;
	/* Confused that whether to add here or not */
	
	// The main application
	public static void main (String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new issue();
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
	public issue()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelissue = new JLabel("Issue Book");
		labelissue.setForeground(Color.GRAY);
		labelissue.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel labelname = new JLabel("Name");
		JLabel labelrollNumber = new JLabel("Roll No.");
		JLabel labelbookName = new JLabel("Book Name");
		JLabel labelbookId = new JLabel("Book Id");
		JLabel labeldate = new JLabel("Date");
		
		name_field = new JTextField();
		name_field.setColumns(20);
		
		rollNo_field =  new JTextField();
		rollNo_field.setColumns(20);
		
		bookName_field = new JTextField();
		bookName_field.setColumns(20);
		
		bookId_field = new JTextField();
		bookId_field.setColumns(20);
		
		date_field = new JTextField();
		date_field.setColumns(20);
		
		JButton btnAddStudent = new JButton("Issue Book");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_field.getText();
				String rollNo = rollNo_field.getText();
				String bookName = bookName_field.getText();
				String bookId = bookId_field.getText();
				String date = date_field.getText();
				/*
				 * Adding the new student to the database
				 */
				int i = 0;
				try
				{
					Connection con = database.getConnection();
					PreparedStatement issueBook = con.prepareStatement("insert into issuedBook(name, rollno, bookName, bookId, date) values(?,?,?,?,?");
					
					issueBook.setString(1, name);
					issueBook.setString(2, rollNo);
					issueBook.setString(3, bookName);
					issueBook.setString(4, bookId);
					issueBook.setString(5, date);
					i = issueBook.executeUpdate();
					con.close();
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(issue.this,"Book is successfully issued !");
					student.main(new String[]{});
					mainframe.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(issue.this,"Sorry, we are not able to process. Please try again !");
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
		GroupLayout mainLayout = new GroupLayout(contentPane);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			home.main(new String[]{});
			mainframe.dispose();
			}
		});
		
		
		mainLayout.setHorizontalGroup(
				mainLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(mainLayout.createSequentialGroup()
						.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(150)
								.addComponent(labelissue))
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(30)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(labelname, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelrollNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelbookName, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addComponent(labelbookId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labeldate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGap(47)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(name_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(rollNo_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(bookName_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(bookId_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(date_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(125, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, mainLayout.createSequentialGroup()
						.addGap(161)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
					.addGroup(mainLayout.createSequentialGroup()
						 .addContainerGap(350, Short.MAX_VALUE)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(100, Short.MAX_VALUE))
			);
			mainLayout.setVerticalGroup(
				mainLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(mainLayout.createSequentialGroup()
						.addComponent(labelissue)
						.addGap(50)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelname)
							.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelrollNumber)
							.addComponent(rollNo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelbookName)
							.addComponent(bookName_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelbookId)
							.addComponent(bookId_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labeldate)
								.addComponent(date_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(60)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGap(0)
						.addComponent(btnHome,  GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
			);
			contentPane.setLayout(mainLayout);
	}
	/*
	 * Public class issue ended here
	 */
	
	
}