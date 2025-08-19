import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    //1. Count Up! (For Loop)
    //● Write a program that prints numbers 1 to 100 using a for loop.
        System.out.println("Counting from 1-100:");
        for (int i= 1; i <= 100; i++){
            System.out.println(i + " ");
        }
        System.out.println("\n");
    //● Modify the program to print only even numbers.
        System.out.println("Even numbers from 1 to 100");
        for (int i = 2; i <= 100; i += 2){
            System.out.println(i + " ");
        }
        System.out.println("\n");


    //2.Multiplication Table (For Loop)
    //● Ask the user for a number
        System.out.println("Enter a number to see its multiplication table: ");
        int number = scanner.nextInt();
    //● Print the multiplication table (1 to 10) for that number
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <=10; i++) {
            System.out.println(number + "x" + i + "=" + (number * i));
        }

        scanner.close();

    }
}
