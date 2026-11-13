package LoginForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import dbconnection.DBconnection;
import employeeManagement.EmployeeLogic;

public class Adminlogic {
	String create = "create table admin("
					+"adminid int primary key,"
					+ "name varchar(50),"
					+"password varchar(50)"
					+")";
	
	DBconnection Call = new DBconnection(); 
	Connection conn = Call.dbconnection();
	
	Scanner sc = new Scanner(System.in);
	public void createtable() {
		try{
			Statement st = conn.createStatement();
			st.executeUpdate(create);
			System.out.println("Admin table is created");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	String insert ="insert into admin(adminid,name,password)values(?,?,?)";
	
	public void insertTable() {
		try {
			System.out.println("-----Add Admin Details-----");
			System.out.println("Enter the Admin Id");
			int adminid = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name");
			String name = sc.nextLine();
			System.out.println("Enter the Password");
			String password = sc.nextLine();
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1,adminid);
			ps.setString(2,name);
			ps.setString(3,password);
			int row = ps.executeUpdate();
			if(row==1) {
				System.out.println("The Admin registration id successful");
				int Choice=0;
				EmployeeLogic E = new EmployeeLogic();
				do {
					System.out.println("---Employee management System---");
					System.out.println("1.create table Employee");
					System.out.println("2.insert 3 Employee details");
					System.out.println("0.exit");
					System.out.print("Enter your option:");
					Choice=sc.nextInt();
					switch(Choice) {
					case 1:
						E.createDetails();
						break;
					case 2:
						E.insertDetails();
						break;
					case 0:
						System.out.println("exit....");
						break;
					default:
						System.out.println("incorrect option");
					}
					
				}while(Choice!=0);
					sc.close();
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	String select ="select * from admin where name=? and password=? ";
	
	
	public void loginLogic() {
		
		System.out.println("-----Enter login details-----");
		System.out.println("Enter the name");
		String name = sc.nextLine();
		System.out.println("Enter the Password");
		String password = sc.nextLine();
		try {
		PreparedStatement ps = conn.prepareStatement(select);
 
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery(); 
		
		if(rs.next()) {
			System.out.println("Login Successful!");	   
		}
		else{
			System.out.println("Login Failed!");
		}
	}catch(SQLException e) {
		System.out.println(e.getMessage());
}
	}

}

