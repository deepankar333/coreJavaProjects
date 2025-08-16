package MiniAtm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtmService {
	private Account account;
	private final String fileName = "E:\\New folder\\workspace\\AtmEmulater\\src\\data.txt";

	public boolean login(String accno, String pin) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts[0].equals(accno) && parts[1].equals(pin)) {
					account = new Account(parts[0], parts[1], Double.parseDouble(parts[2]));
					return true;
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file : " + e.getMessage());
		}
		return false;
	}

	public void saveAccount() {
		try {
			List<String> lines = new ArrayList<String>();
			boolean updated = false;
			File file = new File(fileName);
			if (file.exists()) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String line;
					while ((line = br.readLine()) != null) {
						String[] parts = line.split(",");
						if (parts[0].equals(account.getAccountNumber())) {
							lines.add(account.toString());
							updated = true;
						} else {
							lines.add(line);
						}
					}
				}
			}
			if (!updated) {
				lines.add(account.toString());
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
				for (String l : lines) {
					bw.write(l);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println("Error writing File : " + e.getMessage());
		}
	}
	
	public void checkBalance() {
		System.out.println("Current Balance : "+account.getBalance());
	}

	public void deposit(double amount) {
		account.deposit(amount);
		saveAccount();
		System.out.println("Deposit Successful");
	}

	public void withdraw(double amount) {
		if (account.withdraw(amount)) {
			saveAccount();
			System.out.println("Withdrawal Successful ");
		} else {
			System.out.println("Insufficient Balance");
		}
	}
}
