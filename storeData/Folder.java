package storeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;


import com.mysql.cj.jdbc.DatabaseMetaData;




public class Folder {

    java.sql.Statement stmt = null; 
	 Scanner keyboard=new Scanner(System.in);
	 Connection conn;
//	 String databaseName = "checking";
	public void connect() {
        try{
        	
        Class.forName("com.mysql.cj.jdbc.Driver");      
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/checking","root","root"); 
        stmt = conn.createStatement();
        }catch(Exception e) {
        	{System.out.println(e);}
        }
//		System.out.println("I am from connect");
		
        }
	
	public void gotoFolder(){
	//System.out.println("Welcome to Your database");    
    try    
    {    
        System.out.print("1. Create Folder\n");
        System.out.print("2. Delete Folder\n");
        System.out.print("3. Edit Event\n");
        System.out.print("4. Delete Event\n");
        System.out.print("5. Edit Folder name\n");
        
         
      System.out.println("Enter your choice");    
      int c_choice=keyboard.nextInt();

        if (c_choice == 1) {
        System.out.print("Enter your folder name");
        Scanner keyboard=new Scanner(System.in);
        String f_name = keyboard.nextLine();
        System.out.println("Event name :"+ " "+f_name); 
        connect();
		String query = "CREATE TABLE "+f_name+" (eventname varchar(255 ))"; 
        stmt.executeUpdate(query);
            	
        }
        else if (c_choice == 2) {

			}
//        	String query = "show tables"; 
//        	PreparedStatement stmt2=con.prepareStatement("insert into personal(event_name) values(?)");      
//            stmt2.setString(1,e_name);
//            stmt2.execute();
//
        connect();
        // Get the database metadata

        	  DatabaseMetaData metadata = (DatabaseMetaData) conn.getMetaData();

        	  // Specify the type of object; in this case we want tables

        	  String[] types = {"TABLE"};

        	  ResultSet resultSet = metadata.getTables("checking", null, "%", types);
        	  int i=1;
        	  while (resultSet.next()) {
        		  int a;
        		  a = i++;
        	    String tableName = resultSet.getString(3);

//        	    String tableCatalog = resultSet.getString(1);
//
//        	    String tableSchema = resultSet.getString(2);

        	    System.out.println("Table " + a + ":" + tableName );
        }
    }             
    catch(Exception e)    
    {System.out.println(e);}    
    finally{    
        System.out.println("Successful");    
    }    

}   
} 

