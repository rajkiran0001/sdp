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
	 Scanner name=new Scanner(System.in);
     Scanner in = new Scanner(System.in);
     int eventNumber;
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
	
	
	public void gotoinsertEvent(){
		System.out.print("\n");
            
        System.out.println("Enter you Event Name");    
        String e_name=name.nextLine();
        System.out.print("Enter the folder number: ");
        System.out.print("1. Family");
        System.out.print("2. Personal");
        System.out.print("3. Business");
        System.out.print("4. Entertainment");
        System.out.print("5. Exit");

 	   try    
	    {
        connect();
 

        eventNumber = in.nextInt();
        if (eventNumber == 1) {
        	PreparedStatement stmt1=conn.prepareStatement("insert into family(event_name) values(?)");      
        stmt1.setString(1,e_name);
        stmt1.execute();
        gotoFolder();
        }
        else if (eventNumber == 2) {
        	PreparedStatement stmt2=conn.prepareStatement("insert into personal(event_name) values(?)");      
            stmt2.setString(1,e_name);
            stmt2.execute();
            gotoFolder();
        }
        else if (eventNumber == 3) {
        	PreparedStatement stmt3=conn.prepareStatement("insert into business(event_name) values(?)");      
            stmt3.setString(1,e_name);
            stmt3.execute();
            gotoFolder();
        }
        else if (eventNumber == 4) {
        	PreparedStatement stmt4=conn.prepareStatement("insert into entertainment(event_name) values(?)");      
            stmt4.setString(1,e_name);
            stmt4.execute();
            gotoFolder();
        }else if(eventNumber == 5){
        	System.out.println("Bye..");
//        	gotoFolder();
        }
        
	    }catch(Exception e)    
 	    {System.out.println(e);
 	    gotoinsertEvent();}    
 }
//        ---------------------------------------------------------
        public void gotoFolder(){
//        String e_name=name.nextLine();
            System.out.println("--------------------");  
            System.out.println("Successfully done");  
            System.out.println("--------------------\n");
        try {	
//        PreparedStatement stmt1=conn.prepareStatement("insert into event_names(e_name) values(?)");      
//        stmt1.setString(1,e_name);        
//        stmt1.execute();
//        System.out.println("------------------------");    
//        System.out.println("Event name :"+ " "+e_name);		
//        
        System.out.println("1.Create your own Folder");
        System.out.println("2. Exit");
        eventNumber = in.nextInt();
        if(eventNumber == 1) {
        System.out.print("Enter your folder name");
        Scanner keyboard=new Scanner(System.in);
        String fo_name = keyboard.nextLine();
        System.out.println("Folder name :"+ " "+fo_name); 
        
//        if (fo_name.equals(folderName)){
//    		System.out.println("folder is in the database");
//
//    	}else {
            PreparedStatement stmt2=conn.prepareStatement("insert into folder_names(f_name) values(?)");      
            stmt2.setString(1,fo_name);
            stmt2.execute();
            System.out.println("YOUR FOLDER(S)");
            ResultSet rs = stmt.executeQuery("select * from folder_names");
            int i=1;
    		int a;
            while (rs.next()) {
            	a = i++;
                String folderName = rs.getString("f_name");
                System.out.println( + a + ": " + folderName );
            }
            
            System.out.println("--------------------");  
            System.out.println("Folder Successfully Created");  
            System.out.println("--------------------\n");
            
                
            } else if(eventNumber == 2){
            	System.out.println(" bye..");
//            	gotoinsertEvent(); 
            }
//    	}
    	
//	    String stmtf = "select * from folder_names";
////	    ResultSet rsf = conn.executeQuery(stmtf);
//	    ResultSet rsf = conn.createStatement().executeQuery(stmtf);
//	    while(rsf.next()) {
//	    	String fo_name = rs.getString("f_name");
////	    	String pass = rs.getString("password");
//	    	System.out.println("ffffffffffffffffffffff"+ " "+fo_name);
//	    }
        
        
 
//        System.out.println("Folder Names: \n");
        
        
//        gotoinsertEvent();            	
        }               
    catch(Exception e)    
    {System.out.println(e);
    gotoinsertEvent();}    
        }

} 



