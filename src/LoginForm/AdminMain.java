package LoginForm;

import java.util.Scanner;

public class AdminMain {

	public static void main(String[] args) {
		Adminlogic A = new Adminlogic();
		int Choice=0;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("---Admin Panel---");
			System.out.println("1.create table admin");
			System.out.println("2.Register with Admin details");
			System.out.println("3.Login with Admin details");
			System.out.println("0.exit");
			System.out.print("Enter your option:");
			Choice=sc.nextInt();
			switch(Choice) {
			case 1:
				A.createtable();
				break;
			case 2:
				A.insertTable();
				break;
			case 3:
				A.loginLogic() ;
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
