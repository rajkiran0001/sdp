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
	
        }
	
	
	public void gotoFolder(){
	//System.out.println("Welcome to Your database");    
		System.out.print("\n");
//        System.out.print("1. Create Folder\n");
//        System.out.print("2. Create Event\n");
//        System.out.print("3. Add Event to a Folder\n");
//        System.out.print("4. Delete Folder\n");
//        System.out.print("5. Delete Event\n");
//          System.out.print("2. Exit\n");

         
//      System.out.println("Enter your choice");    
//      int c_choice=keyboard.nextInt();

//        if (c_choice == 1) {

        Scanner name=new Scanner(System.in);    
        System.out.println("Enter you Event Name");    
        String e_name=name.nextLine();
 	   try    
	    {
        connect();
        PreparedStatement stmt1=conn.prepareStatement("insert into event_details(e_name) values(?)");      
        stmt1.setString(1,e_name);        
        stmt1.execute();
        System.out.println("------------------------");    
        	   
        System.out.println("Event name :"+ " "+e_name);		   
        System.out.print("Enter your folder name");
        Scanner keyboard=new Scanner(System.in);
        String f_name = keyboard.nextLine();
        System.out.println("Event name :"+ " "+f_name); 
        

        PreparedStatement stmt2=conn.prepareStatement("insert into folder_names(f_name) values(?)");      
        stmt2.setString(1,f_name);
        stmt2.execute();
        System.out.println("--------------------");  
        System.out.println("Folder Successfully Created");  
        System.out.println("--------------------\n");  
        System.out.println("Folder Names: \n");
        
        ResultSet rs = stmt.executeQuery("select * from folder_names");
        int i=1;
		int a;
        while (rs.next()) {
        	a = i++;
            String folderName = rs.getString("f_name");
            System.out.println( + a + ":" + folderName );

        }
   
        gotoFolder();       
        	
        }               
    catch(Exception e)    
    {System.out.println(e);
    gotoFolder();}    
        }
//        else if (c_choice == 2) {
//        connect();
//      	  
//        }else if(c_choice == 3) {
//        	
//        	System.out.println("Bye..");
//        	
//        }else if(c_choice ==4) {
//        	
//        }
        
//        else {
//        	System.out.println("-------------");
//        	System.out.println("Oops! Enter your choice between 1 and 2");
//        	System.out.println("-------------");
//        	gotoFolder();
//        }

   

}   



