import java.sql.*;
import com.mysql.*;

/*
 * This class is to create connection
 */

public class database {
	public static Connection getConnection(){
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "vibhanshu", "Vibhanshu99@");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		return con;
	}
}
