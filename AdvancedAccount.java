package encapsulation;

public class AdvancedAccount {
	private double balance;
	private double interestRate;
	
	public AdvancedAccount(double balance, double interestRate) {
		this.balance = balance > 0 ? balance : 0;
		this.interestRate = interestRate > 0 ? interestRate : 0;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public double withdraw(double amount) throws Exception {
		if (amount <= balance) {
			balance -= amount;
			return amount;
		} else {
			throw new IllegalArgumentException("Dette bel¿pet er for stort");
		}
	}
	
	public void addInterest() {
		balance += balance*interestRate/100;
	}

}
