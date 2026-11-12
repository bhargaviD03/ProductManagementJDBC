package collegeManagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import college_db.CollegeDB_Connection;

public class CollegedataLogics {
		String create= "create table student("
				+"id int primary key,"
				+"name varchar(50),"
				+"age int,"
				+"course varchar(50)"
				+ ")";
		CollegeDB_Connection Call = new CollegeDB_Connection();
		Connection Conn = Call.Dbconnection();
		Scanner sc = new Scanner(System.in);
		public void createTable() {
			try {
				Statement st = Conn.createStatement();
				st.executeUpdate(create);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		String insert = "insert into student(id,name,age,course)values(?,?,?,?)";
		public void insertTable() {
			try {
			for(int i=1;i<=3;i++) {
			System.out.println("-----Enter Student"+i+"Details-----");
			System.out.println("Enter the student Id:");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the student Name:");
			String name = sc.nextLine();
			System.out.println("Enter the student Age:");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the student Course:");
			String course = sc.nextLine();
			
				PreparedStatement ps = Conn.prepareStatement(insert);
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setInt(3,age);
				ps.setString(4, course);
				ps.executeUpdate();
				System.out.println("Student"+i+"is added!");
			}
			System.out.println("All 3 Student records is added!");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

