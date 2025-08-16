package MiniAtm;

public class Account {
private String accountNumber;
private String pin;
private double balance;


public Account() {
	}


public Account(String accountNumber, String pin, double balance) {
	super();
	this.accountNumber = accountNumber;
	this.pin = pin;
	this.balance = balance;
}


public String getAccountNumber() {
	return accountNumber;
}


public String getPin() {
	return pin;
}


public double getBalance() {
	return balance;
}

public void deposit(double amount) {
	balance +=amount;
}

public boolean withdraw(double amount) {
	if(amount<=balance) {
		balance-=amount;
		return true;
	}
	else {
		System.out.println("Not enough Balance");
		return false;
	}
}


@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", pin=" + pin + ", balance=" + balance + "]";
}

}
