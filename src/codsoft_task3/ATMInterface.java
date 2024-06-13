package codsoft_task3;


import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit Successful. New Balance: Rs. %.2f\n", balance);
        } else {
            System.out.println("Invalid amount for deposit. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawal Successful. New Balance: Rs. %.2f\n", balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}

class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int option;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a valid option: ");
                scanner.next(); // Consume invalid input
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using this ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (option != 4);
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: Rs. %.2f\n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: Rs. ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a valid amount: Rs. ");
            scanner.next(); // Consume invalid input
        }
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: Rs. ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a valid amount: Rs. ");
            scanner.next(); // Consume invalid input
        }
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0); // Initial Balance
        ATM atm = new ATM(account, sc);
        atm.start();
        sc.close();
    }
}

