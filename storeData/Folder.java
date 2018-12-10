package storeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
//import com.mysql.cj.jdbc.DatabaseMetaData;
//import com.mysql.cj.xdevapi.Statement;

public class Folder {

    java.sql.Statement stmt = null; 
	 Scanner keyboard=new Scanner(System.in);
	 Connection conn;
	 String folderName;
	 Scanner name=new Scanner(System.in);
     int eventNumber;
	public void connect() {
        try{
        	
        Class.forName("com.mysql.cj.jdbc.Driver");      
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/checking","root","root"); 
        stmt = conn.createStatement();
     
        }catch(Exception e) {
        	{System.out.println(e);}
        }
	
        }

        public void gotoFolder(){
        	
        try {	
        connect();

//                if(eventNumber == 1){
                ResultSet rs = stmt.executeQuery("select * from folder_names");
                System.out.println("Folder name	--> Event name ");
                while (rs.next()) {
                    String folderName = rs.getString("f_name");
                    String eventName = rs.getString("e_folder");
                    System.out.println(folderName + " --> " +eventName );
                }
        		System.out.println("Enter the event name to delete" );
        		String delete_event = name.nextLine();  
//        		Statement stmt = conn.createStatement();
        		PreparedStatement stmt=conn.prepareStatement("DELETE FROM folder_names WHERE e_folder=?");
        	      stmt.setString(1, delete_event);
        	      stmt.executeUpdate();
        		//                stmt.executeUpdate("DELETE FROM folder_names WHERE e_folder='+flydelete_event+'");
            	System.out.println("successful");
//            }     
                    	
        }               
    catch(Exception e)    
    {System.out.println(e);
    gotoFolder();}    
        }

} 



