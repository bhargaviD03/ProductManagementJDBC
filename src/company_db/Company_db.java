package company_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Company_db {
	String url = "jdbc:mysql://localhost:3306/Company_db";
	String username = "root";
	String password = "Sla@9843";
	public Connection DBConnection() {
		Connection Conn=null;
		try {
			Conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return Conn;
	}
//	public static void main(String[] args) {
//		Company_db E = new Company_db();
//		System.out.println(E.DBConnection());
//	}
}
