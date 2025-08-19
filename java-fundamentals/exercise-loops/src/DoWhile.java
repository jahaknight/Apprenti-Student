import java.util.Scanner;
import java.util.Random;

public class DoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Guess the Number (Do-While Loop)
        //● Generate a random number between 1 and 50.
        int numberToGuess = 23;
        int userGuess;
        //● Ask the user to guess the number.
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have chosen a number between 1-50. Can you guess what it might be??");
        //● Keep asking until the user gets it right using a do-while loop.
        do {
            System.out.println("Enter your guess: ");
            userGuess = scanner.nextInt();
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                    System.out.println("Congratulations! You guessed the number!!!");
                }
            } while (userGuess != numberToGuess);


//        Simple ATM System (Do-While Loop)
//        ● Start with an account balance of $500.
        double balance = 500.00;
        int choice;

//        ● Ask the user if they want to:
        do {
//        ○ 1 Withdraw
            System.out.println("\"\\n===== ATM Menu =====\"");
            System.out.println("1. Withdraw");
//        ○ 2 Deposit
            System.out.println("2. Deposit");
//        ○ 3 Check Balance
            System.out.println("3. Check Balance");
//        ○ 4 Exit
            System.out.println("4. Exit");
            System.out.println("5. Enter your choice: ");
            choice = scanner.nextInt();

//        ● Use a do-while loop to keep asking until they choose to exit
            switch (choice){
                case 1:
                    System.out.println("Enter amount to withdraw:" );
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("You withdrew $" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("You deposited $" + depositAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is $" + balance);
                    break;
                case 4:
                    System.out.println("Exiting ATM.... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice !=4);

        scanner.close();

    }
}
