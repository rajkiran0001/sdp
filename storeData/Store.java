package storeData;

import java.util.Scanner;    
import java.sql.*;    
public class Store {    
public static void main(String args[])    
{    
    System.out.println("Welcome to Your database");    
    try    
    {    
        Scanner keyboard=new Scanner(System.in);    
        System.out.println("Enter you Event Name");    
        String e_name=keyboard.nextLine();     
        System.out.println("------------------------");    
   
        System.out.println("Event name :"+ " "+e_name);    

        Class.forName("com.mysql.cj.jdbc.Driver");      

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/checking","root","root");      
        
        //System.out.println("All Right , We got your entry"); 
        
        System.out.print("Enter the folder number: ");
        System.out.print("1. Family");
        System.out.print("2. Personal");
        
        Scanner in = new Scanner(System.in);
     
        int eventNumber;

        eventNumber = in.nextInt();

        if (eventNumber == 1) {
        	PreparedStatement stmt1=con.prepareStatement("insert into family(event_name) values(?)");      
        stmt1.setString(1,e_name);
        stmt1.execute();
        }
        else if (eventNumber == 2) {

        	PreparedStatement stmt2=con.prepareStatement("insert into personal(event_name) values(?)");      
            stmt2.setString(1,e_name);
            stmt2.execute();

        }
                 
    }    
    catch(Exception e)    
    {System.out.println(e);}    
    finally{    
        System.out.println("Successfully added into the folder");    
    }    
}    
}  