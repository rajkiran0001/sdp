package storeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;



public class Folder {

    java.sql.Statement stmt = null; 
	 Scanner keyboard=new Scanner(System.in);
	public void connect() {
        try{
        	
        Class.forName("com.mysql.cj.jdbc.Driver");      
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/checking","root","root"); 
        stmt = con.createStatement();
        }catch(Exception e) {
        	{System.out.println(e);}
        }
//		System.out.println("I am from connect");
		
        }
	
	public void gotoFolder(){
	//System.out.println("Welcome to Your database");    
    try    
    {    
//    	connect();
//        Scanner keyboard=new Scanner(System.in);    
//        System.out.println("Enter you Event Name");    
//        String e_name=keyboard.nextLine();     
//        System.out.println("------------------------");    
//   
//        System.out.println("Event name :"+ " "+e_name);    
//
//     
//              
        /*System.out.print("Enter the folder number: ");
        System.out.print("1. Family");
        System.out.print("2. Personal");*/
        System.out.print("1. Create Folder\n");
        System.out.print("2. Edit Folder name\n");
        System.out.print("3. Edit Event\n");
        System.out.print("4. Delete Event\n");
        System.out.print("5. Delete Folder\n");
        
         
      System.out.println("Enter your choice");    
      int c_choise=keyboard.nextInt();
        
//        Scanner in = new Scanner(System.in);
//     
//        int eventNumber;
//
//        eventNumber = in.nextInt();
//
        if (c_choise == 1) {
        System.out.print("Enter your folder name");
        Scanner keyboard=new Scanner(System.in);
        String f_name = keyboard.nextLine();
        System.out.println("Event name :"+ " "+f_name); 
        connect();

//        Class.forName("com.mysql.cj.jdbc.Driver");      
//
//        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/checking","root","root");
        
        //String eventname = null;
		String query = "CREATE TABLE "+f_name+" (eventname varchar(255 ))"; 
        stmt.executeUpdate(query);
        
        /*PreparedStatement stmt1=con.prepareStatement("insert into family(event_name) values(?)");      
        stmt1.setString(1,e_name);
        stmt1.execute();*/
        	
        }
//        else if (eventNumber == 2) {
//
//        	PreparedStatement stmt2=con.prepareStatement("insert into personal(event_name) values(?)");      
//            stmt2.setString(1,e_name);
//            stmt2.execute();
//
//        }
                 
    }    
    catch(Exception e)    
    {System.out.println(e);}    
    finally{    
        System.out.println("Successful");    
    }    

    
} 
}
