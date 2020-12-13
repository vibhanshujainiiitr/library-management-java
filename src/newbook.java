import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import com.mysql.*;
import java.sql.*;

/*
 * Create a new book
 */

public class newbook extends JFrame {
	
	static newbook mainframe;
	private JPanel contentPane;
	private JTextField name_field;
	private JTextField Id_field;
	private JTextField address_field;
	private JTextField edition_field;
	private JTextField remark_field;
	
	
	// The main application
	public static void main (String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new newbook();
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
	public newbook()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelnewbook = new JLabel("Add new book");
		labelnewbook.setForeground(Color.GRAY);
		labelnewbook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel labelname = new JLabel("Name");
		JLabel labelbookId = new JLabel("Book ID");
		JLabel labeladdress = new JLabel("Address");
		JLabel labeledition = new JLabel("Edition");
		JLabel labelremark = new JLabel("Remark");
		
		name_field = new JTextField();
		name_field.setColumns(20);
		
		Id_field =  new JTextField();
		Id_field.setColumns(20);
		
		address_field = new JTextField();
		address_field.setColumns(20);
		
		edition_field = new JTextField();
		edition_field.setColumns(20);
		
		remark_field = new JTextField();
		remark_field.setColumns(20);
		
		JButton btnAddBook = new JButton("Add book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_field.getText();
				String Id = Id_field.getText();
				String address = address_field.getText();
				String edition = edition_field.getText();
				String remark = remark_field.getText();
				
				/*
				 * Adding the new book to the database
				 */
				int i = 0;
				try
				{
					Connection con = database.getConnection();
					PreparedStatement book = con.prepareStatement("insert into book(name, bookId, address, edition, remark) values(?,?,?,?,?");
					
					book.setString(1, name);
					book.setString(2, Id);
					book.setString(3, address);
					book.setString(4, edition);
					book.setString(5, remark);
					i = book.executeUpdate();
					con.close();
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(newbook.this,"New book is added to the records");
					home.main(new String[]{});
					mainframe.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(newbook.this,"Sorry, we are not able to please. Please try again !");
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
								.addComponent(labelnewbook))
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(30)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(labelname, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelbookId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labeladdress, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addComponent(labeledition, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelremark, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGap(47)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(name_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(Id_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(address_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(edition_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(remark_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(125, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, mainLayout.createSequentialGroup()
						.addGap(161)
						.addComponent(btnAddBook, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
					.addGroup(mainLayout.createSequentialGroup()
						 .addContainerGap(350, Short.MAX_VALUE)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(100, Short.MAX_VALUE))
			);
			mainLayout.setVerticalGroup(
				mainLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(mainLayout.createSequentialGroup()
						.addComponent(labelnewbook)
						.addGap(50)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelname)
							.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelbookId)
							.addComponent(Id_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labeladdress)
							.addComponent(address_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labeledition)
							.addComponent(edition_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelremark)
								.addComponent(remark_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(60)
						.addComponent(btnAddBook, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGap(0)
						.addComponent(btnHome,  GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
			);
			contentPane.setLayout(mainLayout);
	}
	/*
	 * Public class newbook ended here
	 */
	
	
}