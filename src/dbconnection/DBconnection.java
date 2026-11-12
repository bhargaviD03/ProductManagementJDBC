package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	String url="jdbc:mysql://localhost:3306/productdatabase";
	String username="root";
	String password="Sla@9843";
	
	
	public Connection dbconnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
//	public static void main(String[] args) {
//		DBconnection dbconnection = new DBconnection();
//		System.out.println(dbconnection.dbconnection());
//	}
}
