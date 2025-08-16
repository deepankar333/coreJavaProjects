package StudentManagement;

import java.util.Scanner;

public class StudentApp {
	
	public static void main(String[] args) {
		StudentService service=new StudentService();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		do {
			System.out.println("\n=-=-=-Student Menu -=-=-=");
			System.out.println("1. Add Student");
			System.out.println("2. View All Student");
			System.out.println("3. Search By Roll Number");
			System.out.println("4. Sort By Marks");
			System.out.println("5. Sort By Name");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice : ");
			
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: service.addStudent(); break;
			case 2: service.viewAll(); break;
			case 3: service.searchByRollNo(); break;
			case 4: service.sortBymarks(); break;
			case 5: service.sortByName(); break;
			case 6: System.out.println("Thanks for using the Result Console"); break;
			default: System.out.println("Wrong Input please try again");
			}			
		}
		while(choice !=6);
		sc.close();
	}
}
