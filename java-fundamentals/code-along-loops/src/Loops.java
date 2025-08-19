import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        System.out.println("While Loop!");

        int lines = 1;
        //Notional File
        boolean endOfFile = false;
        while (!endOfFile) {
            System.out.println("Processing File Lane");
            lines++;
            if (lines >= 6) {
                endOfFile = true;
            }
        }

        System.out.println("\nDo While Loop");
        boolean gameOver = false;
        int health = 3;
        boolean escaped = false;
        do {
            health--;
            System.out.println("You have been attacked for 1 Damage");
            System.out.println("Current Health = " + health);
            if (health <=0) {
                gameOver = true;
                System.out.println("You have died!");
            }
            if (health == 1) {
                gameOver = true;
                System.out.println("You have escaped! Congratulations!");
            }
        } while (!gameOver);

        System.out.println("Break Conditions!!");
        System.out.println("Enter your favorite hobbies. Enter ! to quit");
        Scanner console = new Scanner(System.in);
        String input = "";
        while (!input.equals("!")){
            System.out.println("Enter hobby");
            input = console.nextLine();
            System.out.println(input + "Entered");
            if (input.equals("DND")){
                System.out.println("You found the secret hobby! Welcome to the dungeon! ");

                System.out.println("Which Edition is your favorite");
                input = console.nextLine();
                switch (input) {

                }
//                if (input.equals("REDBOX")){
//                    System.out.println("You're so cool");
//                } else {
//                    System.out.println("Congrats");
//                }

                
                break;
            }
        }


    }


}
