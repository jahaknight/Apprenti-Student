public class GuessingGame {
    public static void main(String[] args) {

        ConsoleIO myIO = new ConsoleIO();

        myIO.writeMessage("Welcome to my guessing game");

        // New: helpers
        String name                = myIO.getNonNullNonEmptyString("What is your name?");
        String favoriteColor       = myIO.getNonNullNonEmptyString("What is your favorite color?");
        String favoriteAnimal      = myIO.getNonNullNonEmptyString("What is your favorite animal?");
        double cash                = myIO.getMoney();

        myIO.writeMessage("Thanks for playing my game!");
        myIO.writeMessage("Your name is: " + name);
        myIO.writeMessage("Your favorite color is: " + favoriteColor);
        myIO.writeMessage("Your favorite animal is: " + favoriteAnimal);
        System.out.printf("Your cash on hand is: $%.2f%n", cash);
//        myIO.writeMessage("Finally my guess at your bank pin is :" + favoriteNumber);
        
    }
}
