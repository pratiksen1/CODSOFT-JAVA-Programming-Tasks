import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //Implementing deposit(amount) method
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    //Implementing withdraw(amount) method
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    //Implementing checkBalance() method
    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to ATM service!");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void performTransaction(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1: // Deposit Amount
                System.out.print("Enter the amount to deposit in the account: ");
                double depositAmount = scanner.nextDouble();
                if (userAccount.deposit(depositAmount)) {
                    System.out.println("Deposit successful.Your New balance: " + userAccount.checkBalance());
                } else {
                    System.out.println("Invalid amount. Deposit failed.");
                }
                break;

            case 2: // Withdraw Amount
                System.out.print("Enter the amount you want to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. New balance: " + userAccount.checkBalance());
                } else {
                    System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
                }
                break;

            case 3: // Check The Balance
                System.out.println("Your current balance: " + userAccount.checkBalance());
                break;

            case 0: // Exit from the ATM
                System.out.println("Thank you for using the ATM!");
                System.out.println("Good Bye! Have a good day!");
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance is 5000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            atm.displayOptions();
            System.out.print("Please enter your choice: ");
            option = scanner.nextInt();
            atm.performTransaction(option);
            System.out.println();
        } while (option != 0);

        scanner.close();
    }
}
