package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.AccountExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);	
		
		int option = 0;	
		
		System.out.println("====================");
		System.out.println("     BANCO JAVA     ");
		System.out.println("====================");
		System.out.println("");
		
		System.out.println("==CRIAÇÃO DE CONTA==");
		System.out.println("");
		
		try {
			System.out.print("Número da conta: ");
			int numberAccount = scanner.nextInt();	
			System.out.print("Titular: ");	
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.print("Depósito Inicial: ");
			double balance = scanner.nextDouble();
				
			Account account = new Account(numberAccount, name, balance);
			
			System.out.println("");
			System.out.println("====================");
			System.out.println("     BANCO JAVA     ");
			System.out.println("====================");
			
		do {
			System.out.println("");
			System.out.println("====================");
			System.out.println("1 - Consultar saldo");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Dados da conta");
			System.out.println("5 - Sair");
			System.out.println("");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();	
			System.out.println("");
			
			double amount = 0;
			
			switch (option) {
			case 1:
				System.out.printf("Saldo atual: R$ %.2f\n", account.getBalance());
				break;
			case 2: 
				System.out.print("Valor do depósito: ");
				amount = scanner.nextDouble();  
				account.deposit(amount);
				System.out.println("");
				System.out.println("Depósito realizado com sucesso!");
				System.out.println("");
				System.out.printf("Saldo atual: R$ %.2f\n", account.getBalance());
				break;
			case 3: 
				System.out.print("Valor do saque: ");
				amount = scanner.nextDouble();  
				account.withdraw(amount);
				System.out.println("");
				System.out.println("Saque realizado com sucesso!");
				System.out.println("");
				System.out.printf("Saldo atual: R$ %.2f\n", account.getBalance());
				break;
			case 4: 
				System.out.println("Titular: " + account.getName());
				System.out.println("Conta: " + account.getNumberAccount());
				System.out.printf("Saldo: R$ %.2f\n", account.getBalance());
				break;
		}
			
		} while (option != 5);
		
		}
		catch (AccountExceptions e) {
			System.out.println("Erro: " + e.getMessage());
		} 
		finally {
			scanner.close();
		}
	}

}
