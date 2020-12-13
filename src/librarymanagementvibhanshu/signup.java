package librarymanagementvibhanshu;


import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class signup extends JFrame implements ActionListner{
	
	private static final LayoutManager NULL = null;
	private  JPanel content;
	// Creating multiple text fields 
//	private JTextField text_1; private JTextField text_2; private JTextField text_3; private JTextField text_4;
	// two buttons
// 	private JButton button_1, button_2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
	
	
	// Creating a combobox
	private JComboBox combo;
	
	public static void main(String[], args)
	{
		// Make the signup visible
		new signup().setVisible(true);
	}
	
	public signup()
	{
		this.setBounds(600, 250, 606, 406);
		
		content = new JPanel();
		setContentPane(content);
		content.setBackground(Color.white);
		content.setLayout(NULL);
		
		
		// User name object
		JLabel username = new JLabel("User name ");
		username.setForeground(Color.gray);
		content.add(username);
		username.setBounds(99, 86, 92, 26);
		
		// Name object 
		JLabel name = new JLabel("Name ");
		name.setBounds(99, 123, 92, 26);
		content.add(name);
		
		//Password object
		JLabel password = new JLabel("Password ");
		password.setBounds(99, 234, 92, 26);
		content.add(password);
		
		// Answer Object
		JLabel answer = new JLabel("Answer ");
		answer.setBounds(99, 234, 92, 26);
		content.add(answer);
		
		// Combobox 
		combo = new JComboBox();
		DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
				"Your child SuperHero?", "Your childhood Name ?" }));
		combo.setBounds(265, 202, 148, 20);
		content.add(combo);
		
		
		// Need to add a sequrity question
		
        textField = new JTextField();
	textField.setBounds(265, 91, 148, 20);
	content.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 128, 148, 20);
	content.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 165, 148, 20);
	content.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 239, 148, 20);
	content.add(textField_3);

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	content.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	content.add(b2);

	}
	
	
	// The main functioning 
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			// Connection 
			conn con = new conn();
			
			// The button b1
			if(ae.getSource() == b1)
			{
				String sql = "insert into account( username, name, password, sec_q, sec_ans) values (?, ?,?,? ?)";
				PreparedStatement st = con.c.prepareStatement(sql);

				st.setString(1, textField.getText());
		                st.setString(2, textField_1.getText());
				st.setString(3, textField_2.getText());
				st.setString(4, (String) combo.getSelectedItem());
				st.setString(5, textField_3.getText());
				
				int i = st.executeUpdate();
				if (i > 0){
		                    JOptionPane.showMessageDialog(null, "successfully Created");
		                }

		                textField.setText("");
		                textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
		            }
		            if(ae.getSource() == b2){
		                this.setVisible(false);
				new login().setVisible(true);
					
		            }
		        }catch(Exception e){
		            
		        }
	}			
	
}
