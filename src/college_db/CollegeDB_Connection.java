package college_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CollegeDB_Connection {
		String url ="jdbc:mysql://localhost:3306/college_db";
		String username ="root";
		String password ="Sla@9843";
		
		public Connection Dbconnection() {
			Connection Conn = null;
			try {
				Conn = DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return Conn;
			
		}

//	public static void main(String[] args) {
//		
//		CollegeDB_Connection Conn = new CollegeDB_Connection();
//		System.out.println(Conn.Dbconnection());
//
//	}

}
