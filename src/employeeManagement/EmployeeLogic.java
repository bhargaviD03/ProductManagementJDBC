package employeeManagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import company_db.Company_db;

public class EmployeeLogic {
	String create = "create table employee("
			+"emp_id int primary key,"
			+ "emp_name VARCHAR(50),"
			+ "salary DOUBLE,"
			+ "department VARCHAR(50)"
			+ ")";
	
	Company_db call = new Company_db();
	Connection Conn = call.DBConnection();
	Scanner sc = new Scanner(System.in);
	public void createDetails() {
		try {
			Statement st = Conn.createStatement();
			st.executeUpdate(create);
			System.out.println("Table is created");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	String insert = "insert into(emp_id,emp_name,salary,department)values(?,?,?,?)";
	public void insertDetails(){
		try {
			int n=sc.nextInt();
			for(int i=1;i<=n;i++) {
				System.out.println("-----Enter the Employee" +" "+i+" "+"Details");
				System.out.println("Enter the Employee Id:");
				int emp_id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Employee Name:");
				String emp_name = sc.nextLine();
				System.out.println("Enter the Employee Salary:");
				double salary = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the Employee Department:");
				String department = sc.nextLine();
				
				PreparedStatement ps = Conn.prepareStatement(insert);
				ps.setInt(1, emp_id);
				ps.setString(2,emp_name);
				ps.setDouble(3, salary);
				ps.setString(4, department);
				ps.executeUpdate(insert);
				System.out.println("Employee is added!");
				
				System.out.println("Employee ID:" +emp_id);
				System.out.println("Employee Name:" +emp_name);
			}
			System.out.println("Entered the given size employees!");
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
	}
	
}
