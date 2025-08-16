package BankAccountsystem;

import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		BankService service=new BankService();
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n========= Bank Menu =========");
			System.out.println("1. Create Account");
			System.out.println("2. View All Accounts");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Exit");
			System.out.println("Enter your Choice : ");
			choice=sc.nextInt();
			
			switch (choice) {
			case 1: service.createAccount(); break;
			case 2: service.viewAllAccounts(); break;
			case 3: service.depositMoney(); break;
			case 4: service.withdrawMoney(); break;
			case 5: System.out.println(" Thankyou for using our Bank."); break;
			default: System.out.println("Invalid choice. Try again.");
			}
		}
		while (choice != 5);
		sc.close();
	}

}
