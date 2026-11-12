package productmanagement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Productlogic productlogic = new Productlogic();

int choice=0;
Scanner sc= new Scanner(System.in);

do {
	System.out.println("---Product management System---");
	System.out.println("1.create table");
	System.out.println("2.insert product details");
	System.out.println("3.view all product details");
	System.out.println("4.view product details by id");
	System.out.println("5.Update product details by id");
	System.out.println("6. Delete product details by id");
	System.out.println("0.exit");
	System.out.print("Enter your option:");
	choice=sc.nextInt();
	switch(choice) {
	case 1:
		productlogic.createtable();
		break;
	case 2:
		productlogic.inserttable();
		break;
	case 3:
		productlogic.viewalldetails();
		break;
	case 4:
		productlogic.viewdetailsbyid();
		break;
	case 5:
		productlogic.updatedetails();
		break;
	case 6:
		productlogic.deletedetails();
	    break;
	case 0:
		System.out.println("exit....");
		break;
	default:
		System.out.println("incorrect option");
	}
	}while(choice!=0);
	sc.close();
	}
	
}


