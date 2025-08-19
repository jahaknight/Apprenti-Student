import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. Countdown Timer (While Loop)
        //● Prompt the user for a starting number.
        System.out.println("Enter a starting number for the countdown:");
        int number = scanner.nextInt();

        while (number > 0) {
            System.out.println(number);
            number--;
        }
        //● Use a while loop to count down to zero.
        //● Print "Blast off!" when it reaches zero
        System.out.println("Blast off!!!");

        //2. Password Validator (While Loop)
        //● Ask the user to enter a password.
        scanner.nextLine();
        String password = "";

        //● Keep asking until they enter the correct password ("codingisfun").
        while (!password.equals("codingisfun")){
            System.out.println("Enter the password:");
            password = scanner.nextLine();
            if (!password.equals("codingisfun")){
                System.out.println("Incorrect password. Try again.");
            }
        }
        System.out.println("Access granted!");
        scanner.close();
    }
}
