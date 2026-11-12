package productmanagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbconnection.DBconnection;

public class Productlogic {
String create="create table productdetails("
				+"productid int primary key,"
				+ "productname varchar(150),"
				+ "productprice double,"
				+"qty int,"
				+"dates date"
				+ ")";
	DBconnection call = new DBconnection();
	Connection conn = call.dbconnection();
	Scanner sc = new Scanner(System.in);
	public void createtable() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(create);
			System.out.println("Table is created");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
String insert="insert into productdetails(productid,productname,productprice,qty,dates)values(?,?,?,?,?)";
public void inserttable() {
	System.out.println("-----Add Product Details-----");
	System.out.println("Enter the Product Id");
	int productid = sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the Product Name");
	String productname = sc.nextLine();
	System.out.println("Enter the Product Price");
	double productprice = sc.nextDouble();
	System.out.println("Enter the Product Quantity");
	int qty = sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the Product dates");
	String dates = sc.nextLine();
	try {
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1,productid);
		ps.setString(2,productname);
		ps.setDouble(3,productprice);
		ps.setInt(4,qty);
		ps.setString(5,dates);
		int row = ps.executeUpdate();
		if(row==1) {
			System.out.println(row + "Product Added");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

String displayall = "select * from productdetails";
public void viewalldetails(){
	try {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(displayall);
		while(rs.next()) {
			System.out.println("product id:"+ rs.getInt("productid")
					+",product name:,"+ rs.getString("productname") +
					",product price"+rs.getDouble("productprice") +
					",Quantity:"+ rs.getInt("qty")+
					",Date:"+ rs.getString("dates"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} 
}


String displaybyid = "select * from productdetails where productid=?";

public void viewdetailsbyid(){
	System.out.println("Enter the Product Id:");
	int productid = sc.nextInt();
	
	try {
		PreparedStatement ps = conn.prepareStatement(displaybyid);
		ps.setInt(1, productid);
		ResultSet rs = ps.executeQuery();
		boolean found =false;
		while(rs.next()) {
			found = true;
			System.out.println("product id:"+ rs.getInt("productid")
			+",product name:,"+ rs.getString("productname") +
			",product price"+rs.getDouble("productprice") +
			",Quantity:"+ rs.getInt("qty")+
			",Date:"+ rs.getString("dates"));
		}
		if(!found) {
			System.out.println("Id not found");
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}


String update ="update productdetails set productid=?,productname=?,productprice=?,qty=?,dates=?"
				+ "where productid=?"; 

public void updatedetails(){
	System.out.println("Update product details by Id");
	System.out.println("Enter the Product Id to update:");
	int productid = sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the Product Name");
	String productname = sc.nextLine();
	System.out.println("Enter the Product Price");
	double productprice = sc.nextDouble();
	System.out.println("Enter the Product Quantity");
	int qty = sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the Product dates");
	String dates = sc.nextLine();
	try {
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1,productid);
		ps.setString(2,productname);
		ps.setDouble(3,productprice);
		ps.setInt(4,qty);
		ps.setString(5,dates);
		ps.setInt(6,productid);
		int row = ps.executeUpdate();
		if(row==1) {
			System.out.println("Product details Updated");
		}
		else {
			System.out.println("Product details not Updated");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

String delete = "delete from productdetails where productid=?";

public void deletedetails() {

    System.out.println("Delete Product Details by Id:");

    System.out.println("Enter the Product Id:");
    int productid = sc.nextInt();
    try {
        PreparedStatement ps = conn.prepareStatement(delete);
        ps.setInt(1, productid);
        int row = ps.executeUpdate();
        if (row == 1) {
            System.out.println("Product Deleted Successfully");
        } else {
            System.out.println("Product ID not found");
        }
   } catch (SQLException e) {
        e.printStackTrace();
    }
}
}



