package bankaccountapp;

public abstract class Account implements IRate{
	
	private String name;
	private String sSN;
	protected String accountNumber;
	private static int index = 10000; 
	private double balance;
	protected double rate;
	
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		
		
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();

	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing: $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdraw: $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering: $" + amount + "to " + toWhere);
		printBalance();
		
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
	}
	
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public abstract void setRate();
	
	public void showInfo() {
		System.out.println("NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance + "\nRate: " + rate + "%");
	}

}
