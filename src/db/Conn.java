
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    
public class Conn{
    Connection con = null;
    
    public static Connection conDB()throws SQLException
    {  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "root",""); 
            
             return con; 
        }catch(ClassNotFoundException | SQLException e){ 
            return null;
        }  
    }  
}  