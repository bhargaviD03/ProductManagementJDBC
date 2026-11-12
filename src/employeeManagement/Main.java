package employeeManagement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		EmployeeLogic E = new EmployeeLogic();
		
		int Choice=0;
		Scanner sc= new Scanner(System.in);
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

}
