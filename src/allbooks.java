import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;


public class allbooks extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static allbooks mainframe;
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
	
	public allbooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 400, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
	}
}
