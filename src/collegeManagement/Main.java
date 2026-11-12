package collegeManagement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CollegedataLogics C = new CollegedataLogics();
		int Choice=0;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("---Product management System---");
			System.out.println("1.create table Student");
			System.out.println("2.insert 3 Student details");
			System.out.println("0.exit");
			System.out.print("Enter your option:");
			Choice=sc.nextInt();
			switch(Choice) {
			case 1:
				C.createTable();
				break;
			case 2:
				C.insertTable();
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
