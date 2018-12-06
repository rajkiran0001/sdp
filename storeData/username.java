package storeData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;
public class username {

	Scanner input = new Scanner(System.in);
	String username;
	String password;
	
	public void user() {
		  Class.forName("com.mysql.cj.jdbc.Driver");      

	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/checking","root","root");    
	    Statement st= con.createStatement();
	    String stmt = "select * from login";
	    ResultSet rs = con.executeStatement(stmt);
	    while(rs.next()) {
	    	String dbuser = rs.getString("username");
	    	String pass = rs.getString("password");
	    }
	        
		System.out.println("Enter username");
		    username = input.next();
		
		System.out.println("Enter password");
		    password = input.next();
		    

		    
	if (username.equals(dbuser)&&(password.equals(pass))) {
		System.out.println("you have logged in successfully");
		
	
	}
		
		
		
	}
	
	
}
