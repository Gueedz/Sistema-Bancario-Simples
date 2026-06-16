package entities;

public class Account {

	private Integer numberAccount;
	private String name;
	private Double balance;
	
	public Account() {
	}

	public Account(Integer numberAccount, String name, Double balance) {
		if (numberAccount == 0 || numberAccount < 0) {
			throw new AccountExceptions("O número da conta não pode ser zero.");
		} 
		
		if (name == null || name.trim().isEmpty()) {
			throw new AccountExceptions("O nome do titular não pode estar vazio.");
		}
		
		if (balance < 0) {
			throw new AccountExceptions("O saldo inicial não pode ser negativo.");
		}
		
		this.numberAccount = numberAccount;
		this.name = name;
		this.balance = balance;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}
	
	public double deposit(double amount) {
		return balance += amount;
	}
	
	public double withdraw(double amount) {
		return balance -= amount;
	}

	public String checkBalance() {
		return String.format("%.2f", getBalance());
	}
	

}
