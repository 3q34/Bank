/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */
package day06.Testbanking;
import day06.banking1.Account;

public class TestBanking {

  public static void main(String[] args) {
    Account account;
account=new Account(500.00);
    // Create an account that can has a 500.00 balance.
    System.out.println("Creating an account with a 500.00 balance.");
    
	//code
    account.withdraw(150.00);
    System.out.println("Withdraw 150.00");
   	//code
account.deposit(22.50);
    System.out.println("Deposit 22.50");
   account.withdraw(47.62);
	//code
    System.out.println("Withdraw 47.62");
   	//code
    // Print out the final account balance
    System.out.println("The account has a balance of " + account.getBalance());
  }
}
