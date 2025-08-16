package MiniAtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AtmApp {
public static void main(String[] args) {
	AtmService service=new AtmService();
	Scanner sc = new Scanner(System.in);
	int choice;
	System.out.println("Enter Account Number :");
	String accNo=sc.nextLine();
	System.out.println("Enter Pin : ");
	String pin=sc.nextLine();
	
	try {
		if(!service.login(accNo, pin)) {
			System.out.println("Invalid login credentials");
			return;
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	do {
		System.out.println("\n===== ATM Menu =====");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
		
		System.out.println("Enter Choice : ");
		
		choice= sc.nextInt();
		switch (choice) {
		case 1: service.checkBalance(); break;
		case 2: 
			System.out.println("Enter amount to Deposit : ");
			double damount=sc.nextDouble();
			service.deposit(damount);
			break;
		case 3:
			System.out.println("Enter amount to Withdraw : ");
			double wamount=sc.nextDouble();
			service.withdraw(wamount);
			break;
		case 4:System.out.println("\n Thankyou for using our ATm Services");break;
		default: System.out.println("Invalid Choice please select again");
		}
	}
		while(choice!=4);
		sc.close();
	}
}
