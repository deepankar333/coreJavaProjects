package BankAccountsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankService {
private ArrayList<BankAccount> accounts =new ArrayList<>();
private Scanner sc =new Scanner(System.in);

public void createAccount() {
	System.out.println("Enter Account Number : ");
	int accNo=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter Account Holder Name : ");
	String name= sc.nextLine();
	System.out.println("Enter Account Balance : ");
	double balance=sc.nextDouble();

BankAccount acc=new BankAccount(accNo, name, balance);
accounts.add(acc);
System.out.println("Account created successfully");
}
public void viewAllAccounts() {
	for (BankAccount acc: accounts) {
		acc.displayDetails();
		System.out.println("-----------");
	}
}
public void depositMoney() {
	System.out.println("Enter Account No. : ");
	int account=sc.nextInt();
	System.out.println("Enter ammount to Deposit : ");
	double ammount=sc.nextDouble();
	
//	for(BankAccount acc :accounts) {
//		if(acc.getAccountNumber()==account) {
//			acc.deposit(ammount);
//			System.out.println("Deposit Successful");
//			return;
//		}
//	}
//   System.out.println("Account NOt Found");
	accounts.stream().filter(acc -> acc.getAccountNumber()== account)
	.findFirst().ifPresentOrElse(acc -> {acc.deposit(ammount);
	System.out.println("Deposit Successful");}, () -> System.out.println("Account Not Found"));
}
public void withdrawMoney() {
	System.out.println("Enter Account Number : ");
	int account=sc.nextInt();
	System.out.println("Enter amount to withdraw : ");
	double ammount=sc.nextDouble();	
	accounts.stream().filter(acc -> acc.getAccountNumber()== account)
	.findFirst().ifPresentOrElse(acc -> {acc.withdraw(ammount);
	System.out.println("Withdraw sucessful");}, () -> System.out.println("Account not Found"));
}
}
