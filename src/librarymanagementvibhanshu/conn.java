/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementvibhanshu;

/**
 *
 * @author the_looser
 */

import java.sql.*;
// This class is used for creating connection JDBC
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class conn {
    Connection c;
    Statement s;
    
    public conn()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        
        // Creating connection 
        c = DriverManager.getConnection("jdbc:mysql:///library","root","mahavir99@");
        
        // We can run the queries with the help of this statequeries
        s = c.createStatement();
        }
        
        
        catch( Exception e)
        {
               System.out.println(e);
        }    
    }
}
