package storeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.mysql.cj.jdbc.DatabaseMetaData;

public class Folder {

    java.sql.Statement stmt = null; 
	 Scanner keyboard=new Scanner(System.in);
	 Connection conn;
	 String folderName;
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
	
//	public void tableNames() {
//        try {
//		ResultSet rs = stmt.executeQuery("select * from folder_names");
//        while (rs.next()) {
//            folderName = rs.getString("fnames");          
//        }
//        }catch(Exception e) {
//        	System.out.println(e);
//        }
//	}
	
	public void gotoFolder(){
	//System.out.println("Welcome to Your database");    
		System.out.print("\n");
        System.out.print("1. Create Folder\n");
        System.out.print("2. Create Event\n");
        System.out.print("3. Add Event to a Folder\n");
        System.out.print("4. Delete Folder\n");
        System.out.print("5. Delete Event\n");
        System.out.print("6. Exit\n");
//        System.out.print("4. Delete Event\n");
//        System.out.print("5. Edit Folder name\n");
        
         
      System.out.println("Enter your choice");    
      int c_choice=keyboard.nextInt();

        if (c_choice == 1) {
        	   try    
        	    {
        System.out.print("Enter your folder name");
        Scanner keyboard=new Scanner(System.in);
        String f_name = keyboard.nextLine();
        System.out.println("Event name :"+ " "+f_name); 
        connect();
//		String query = "CREATE TABLE "+f_name+" (eventname varchar(255 ))"; 
//      stmt.executeUpdate(query);
        PreparedStatement stmt1=conn.prepareStatement("insert into folder_names(fnames) values(?)");      
        stmt1.setString(1,f_name);
        stmt1.execute();
        System.out.println("--------------------");  
        System.out.println("Folder Successfully Created");  
        System.out.println("--------------------\n");  
        System.out.println("Folder Names: \n");
        
        ResultSet rs = stmt.executeQuery("select * from folder_names");
        int i=1;
		int a;
        while (rs.next()) {
        	a = i++;
            String folderName = rs.getString("fnames");
            System.out.println( + a + ":" + folderName );
//            System.out.println(folderName + "\t");
        }
//        tableNames();
//        System.out.println(folderName + "\t");
        

//        System.out.println("Enter you Event Name");    
//        String e_name=keyboard.nextLine();     
        gotoFolder();       
        	
        }               
    catch(Exception e)    
    {System.out.println(e);
    gotoFolder();}    
        }
        else if (c_choice == 2) {
        connect();
        // Get the database metadata
//        	  DatabaseMetaData metadata = (DatabaseMetaData) conn.getMetaData();
//        	  // Specify the type of object; in this case we want tables
//        	  String[] types = {"TABLE"};
//
//        	  ResultSet resultSet = metadata.getTables("checking", null, "%", types);
//        	  int i=1;
//       		  int a;  
//       		  String tableName;
//        	  while (resultSet.next()) {
//        		a = i++;
//        		tableName = resultSet.getString(3);
////        	    String tableCatalog = resultSet.getString(1);
////        	    String tableSchema = resultSet.getString(2);
//        	    System.out.println("Table " + a + ":" + tableName );   
//            	PreparedStatement stmt1=conn.prepareStatement("insert into table_names(tnames) values(?)");      
//                stmt1.setString(1,tableName);
//                stmt1.execute();
//        	  }
//        	  System.out.println("Enter the table name to delete");
//        	  Scanner keyboard=new Scanner(System.in);
//        	  String f_name = keyboard.nextLine();

        	  
        }else if(c_choice == 3) {
        	
        	System.out.println("Bye..");
        	
        }else if(c_choice ==4) {
        	
        }
        
        else {
        	System.out.println("-------------");
        	System.out.println("Oops! Enter your choice between 1 and 2");
        	System.out.println("-------------");
        	gotoFolder();
        }

   

}   
} 

