import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import com.mysql.*;
import java.sql.*;

/*
 * This class is to edit the details of a student. To edit the details user is needed to enter the Name as well as roll no of the student.
 */

public class editStudent extends JFrame {
	
	static editStudent mainframe;
	private JPanel contentPane;
	private JTextField name_field;
	private JTextField rollNo_field;
	private JTextField studentClass_field;
	private JTextField section_field;
	private JTextField contact_field;
	
	// The main application
	public static void main (String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					mainframe = new editStudent();
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
	public editStudent()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labeleditStudent = new JLabel("Edit Student");
		labeleditStudent.setForeground(Color.GRAY);
		labeleditStudent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel labelname = new JLabel("Name");
		JLabel labelrollNumber = new JLabel("Roll No.");
		JLabel labelclass = new JLabel("Class (New) ");
		JLabel labelsection = new JLabel("Section (New) ");
		JLabel labelcontact = new JLabel("Contact (New) ");
		
		name_field = new JTextField();
		name_field.setColumns(20);
		
		rollNo_field =  new JTextField();
		rollNo_field.setColumns(20);
		
		studentClass_field = new JTextField();
		studentClass_field.setColumns(20);
		
		section_field = new JTextField();
		section_field.setColumns(20);
		
		contact_field = new JTextField();
		contact_field.setColumns(20);
		
		JButton btnAddStudent = new JButton("Edit");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_field.getText();
				String rollNo = rollNo_field.getText();
				String studentClass = studentClass_field.getText();
				String section = section_field.getText();
				String contact = contact_field.getText();
				
				/*  We can also use type casting to convert the contact to store as integer numbers
				 *  But in our case we can also save the mail ID too
				 */
				
				/*
				 * Editing the new student to the database
				 */
				int i = 0;
				try
				{
					Connection con = database.getConnection();
					PreparedStatement student = con.prepareStatement("update student set studentClass=?, section=?, contact=? where rollNo=? & name=?");
					
					student.setString(1, studentClass);
					student.setString(2, section);
					student.setString(3, contact);
					student.setString(4, rollNo);
					student.setString(5, name);
					i = student.executeUpdate();
					con.close();
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(editStudent.this,"Student details updated !");
					student.main(new String[]{});
					mainframe.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(editStudent.this,"Sorry, we are not able to update. Please try again !");
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
								.addComponent(labeleditStudent))
							.addGroup(mainLayout.createSequentialGroup()
								.addGap(30)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(labelname, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelrollNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelclass, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addComponent(labelsection, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelcontact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGap(47)
								.addGroup(mainLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(name_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(rollNo_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(studentClass_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(section_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
									.addComponent(contact_field, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
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
						.addComponent(labeleditStudent)
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
							.addComponent(labelclass)
							.addComponent(studentClass_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelsection)
							.addComponent(section_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(mainLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelcontact)
								.addComponent(contact_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(60)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGap(0)
						.addComponent(btnHome,  GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
			);
			contentPane.setLayout(mainLayout);
	}
	/*
	 * Public class editStudent ended here
	 */
	
	
}