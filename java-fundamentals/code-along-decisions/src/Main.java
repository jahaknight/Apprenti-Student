import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // IF-Else (only two conditions )
        System.out.println("WAKE UP!");
        boolean tooTired = true;

        if (tooTired){
            System.out.println("Too Tired....Snooze");
        } else {
            System.out.println("I'm up!!!!");
        }

        // ELSE - IF (multiple values)
        System.out.println("Approaching Stop Light");
        System.out.println("What color is the light?");
        String color = console.nextLine();

        if (color.equalsIgnoreCase("red")){
            System.out.println("STOP!!!!");
        } else if (color.equalsIgnoreCase("yellow")){
            System.out.println("Drive Faster Dummy!!!");
        } else if ("green".equalsIgnoreCase(color)){
            System.out.println("GO!!!!");
        } else {
            System.out.println("Invalid Color");
        }

        System.out.println("Approaching the light changing color");
        System.out.println("What color is thr light now?");
        color = console.nextLine();
        if (color.equalsIgnoreCase("red")) {
            System.out.println("STOP!!!");
        } else if (color.equalsIgnoreCase("yellow")) {
            System.out.println("How far to the light");
            int distance = Integer.parseInt(console.nextLine());
            if (distance >= 20){
                System.out.println("Slow Down then stop");
            } else {
                System.out.println("Go faster dummy!");
            }
        } else if (color.equalsIgnoreCase("green")) {
            System.out.println("GOOOOOOO!!!");
        } else {
            System.out.println("Not a valid color");
        }

        // Switch case
        System.out.println("What direction would you like to go?");
        System.out.println("N = North");
        System.out.println("S = South");
        System.out.println("E = East");
        System.out.println("W = West");
        String direction = console.nextLine();

        switch (direction) {
            case "n": {
                System.out.println("Going North");
                break;
            }
            case "s": {
                System.out.println("Going South");
                break;
            }
            case "e":{
                System.out.println("Going East");
                break;
            }
            case "w": {
                System.out.println("Going West");
                break;

            } default: {
                System.out.println("Invalid Direction");
            }
        }

        System.out.println("PS Plus Levels");
        System.out.println("1. Essential");
        System.out.println("2. Premium");
        System.out.println("3. Ultimate");
        int membership = Integer.parseInt(console.nextLine());
        switch (membership){
            case (3) :
                System.out.println("Free Game: Battlefield 7");
            case (2) :
                System.out.println("Free Game - NBA 2K");
            case (1) :
                System.out.println("GTA 5");
        }

    }
}
