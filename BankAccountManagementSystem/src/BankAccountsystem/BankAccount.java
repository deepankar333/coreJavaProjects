package BankAccountsystem;

public class BankAccount {
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
		
	public BankAccount() {
		}


	public BankAccount(int accountNumber, String accountHolder, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public String getAccountHolder() {
		return accountHolder;
	}


	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	
	public boolean withdraw(double amount) {
		if(amount<=balance) {
			balance -= amount;
			System.out.println("Remaining Balance : "+balance);
			return true;
		}else{
			return false;
		}
	}
	
	public void displayDetails() {
		System.out.println("Account No.: "+accountNumber);
		System.out.println("Account Holder : "+accountHolder);
		System.out.println("Balance : "+balance);
	}

}
