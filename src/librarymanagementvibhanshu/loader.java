package librarymanagementvibhanshu;

// Importing the packages
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

// Implementing multithreading by 'implements runnable'
/* Multiple inheritance is allowed in JAVA, but not through classes
 interfaces based multiple inheritance is allowed.
*/
public class loader extends JFrame implements Runnable {
	// Reference to the objects 
	private JPanel content;
	private JProgressBar bar;
	
	// Connection object refrence 
	Connection conn;
	int temp;
	
	// Object for thread
	Thread th;
	
	public static void main( String[] args)
	{
		new loader().setVisible(true);
		// Making this class visible
	}
	
	public void setUploading()
	{
		this.setVisible(false);
		th.start();
	}
	
	// Constructor for this class
	public loader()
	{
		// This is necessary to add the heading of the pannel
		super("Loading ...");
		
		// Creating a thread class object
		th = new Thread((Runnable) this);
		
		// Creating a JPanel object for the main layout
		JPanel window = new JLabel("LMS by Vibhanshu Jain");
		window.setForeground(Color.cyan);
		window.setBounds(130, 46, 500, 35);
		content.add(window);
		
		// Creating a new object for progress bar using swing function 
		bar = new JProgressBar();
		bar.setStringPainted(true);
		content.add(bar);
		
		// One more new object is created
		JLabel wait = new JLabel("Please wait ...");
		wait.setForeground(Color.cyan);
		wait.setBounds(200, 165, 150, 20);
		content.add(wait);
		
		JPanel new_panel = new JPanel();
		new_panel.setBackground(Color.cyan);
		new_panel.setBounds(0, 0, 590, 390);
		content.add(new_panel);
		
		
		setUploading();
	}
	
	// Calling the run method
	public void run()
	{
		try
		{
			for( int key = 0 ; key < 200 ; key++)
			{
				key++;
				
				int a = bar.getMaximum();
				int b = bar.getValue();
				
				if( b < a )
				{	
					// Setting the value of bar to increase by one
					bar.setValue( bar.getValue() + 1 );
				}
				
				else 
				{
					 key = 201;
					 setVisible(false);
					 // Calling the home show
					 new home().setVisible(true);
				}
				
				// Sleeping the thread for 50 ms
				Thread.sleep(50);
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
