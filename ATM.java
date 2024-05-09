import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank(); // Bank class manages user accounts and transactions

    public static void main(String[] args) {
        // Simulate user authentication
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        // Authenticate user
        if (bank.authenticateUser(userId, pin)) {
            System.out.println("Authentication successful!");
            displayMenu();
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }

    private static void displayMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bank.displayTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's account number: ");
                    int recipientAccountNumber = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transfer(recipientAccountNumber, transferAmount);
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

class Bank {
    private Account[] accounts = {new Account(123456, 1234, 1000),
                                  new Account(789012, 5678, 2000)}; // Sample accounts

    public boolean authenticateUser(int userId, int pin) {
        for (Account account : accounts) {
            if (account.getUserId() == userId && account.getPin() == pin) {
                return true;
            }
        }
        return false;
    }

    public void displayTransactionHistory() {
        // Implementation to display transaction history
        System.out.println("Transaction history:");
    }

    public void withdraw(double amount) {
        // Implementation to withdraw money from account
        System.out.println("Withdrawal of $" + amount + " successful.");
    }

    public void deposit(double amount) {
        // Implementation to deposit money into account
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public void transfer(int recipientAccountNumber, double amount) {
        // Implementation to transfer money between accounts
        System.out.println("Transfer of $" + amount + " to account " + recipientAccountNumber + " successful.");
    }
}

class Account {
    private int userId;
    private int pin;
    private double balance;

    public Account(int userId, int pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }
}
