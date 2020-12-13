/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementvibhanshu;


// import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// The project is mostly based on swings package
/**
 *
 * @author the_looser
 */
public class login extends JFrame implements ActionListener {
    
    // Creating the objects
    
    // JPanel is live division in HTML
    private JPanel panel;
    // Text field object is created
    private JTextField textField;
    // Password field object created 
    private JPasswordField passwordField;
    // Creating the button objects
    private JButton b1, b2, b3;
    
    public login()
    {
        // For setting the background colors
        setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 600, 400);
        // For placing the elements in the screen
        
        // Creating a object for panel
        panel = new JPanel();
        panel.setBackground( new Color (176, 224, 230));  // Background color
        setContentPane(panel);
        // Passing the panel object 
        panel.setLayout(null);
        
        
        // Creating the label for the data fields
        JLabel label_1 = new JLabel("Username : ");
        label_1.setBounds(124, 89, 95, 24);
        panel.add(label_1);
        
        JLabel label_2 = new JLabel("Password : ");
        label_2.setBounds(124, 124, 95, 24);
        panel.add(label_2);
        
        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);
	
        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        // Making the object of the button
        b1 = new JButton("Login");
        b1.addActionListener(this);
                
        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(new Color(250, 250, 210));
        b1.setBounds(149, 181, 113, 39);
        panel.add(b1);
		
        b2 = new JButton("SignUp");
        b2.addActionListener(this);
	
        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(289, 181, 113, 39);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
	
        b3.setForeground(new Color(205, 92, 92));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(199, 231, 179, 39);
        panel.add(b3);

        JLabel l5 = new JLabel("Trouble in Login?");
        // Changing the font & size of the text
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setForeground(new Color(255, 0, 0));
        l5.setBounds(70, 240, 130, 20);
        panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(176, 224, 230));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
	
    }
    
    public void actionPerformed(ActionEvent ae)
    {	
    	
    	// If the fist button is pressed
    	if(ae.getSource() == b1)
    	{
    		Boolean current = false;
    		
    		try
    		{
    			conn con = new conn();
    			
    			// SQL Query
    			String sql = "select * from accont where username=? and password=?";
    			PreparedStatement st = con.c.prepareStatement(sql);
    			
    			// Now we need to replace the question mark in the previous code
    			st.setString(1, textField.getText());
    			st.setString(2, textField.getText());
    			
    			// Result of the query
    			ResultSet result = st.executeQuery();
    			// It will result in the result object from the database. It jumps from row to row.
    			
    			if(result.next())
    			{
    				this.setVisible(false);
    				// Making this frame as not visible
    				new loader().setVisible(true);
    				// Making this frame as visible
    				
    			}
    			else 
    			{	
    				// JOptionPane  is object
    				JOptionPane.showMessageDialog(null, "Invalid login !");
    			}
    		}
    		
    		
    		catch (Exception e2)
    		{
    			e2.printStackTrace();
    		}
    	}
    	
    	
    	// If the button 2 is pressed by the user, then we need to display the signup pannel
    	if(ae.getSource() == b2)
    	{
    		this.setVisible(false);
    		
    		// Creating a object of signup class
    		Signup signup = new Signup();
    		signup.setVisible(true);
    		// Making the signup visible
    	}
    	
    	// If the third button is pressed by the user, then we need to display the forgot password class
    	if(ae.getSource() == b3)
    	{
    		this.setVisible(false);
    		
    		// Creating a object of forgot class
    		Forgot forgot = new Forgot();
    		forgot.setVisible(true);
    	}
    }
    
    public static void main(String[] args)
    {	
    	// Making the main class as visible
    	new login().setVisible(true);
    }
  
}
