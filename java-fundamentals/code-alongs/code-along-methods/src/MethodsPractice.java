import java.util.Scanner;

public class MethodsPractice {
    public static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        String[] prompts;

        // Welcome Message
        printWelcomeMessage();

        // Prompt user for Movie Title
        String movie = getString("What Movie would you like to see?");
//        System.out.println("What movie would you like to see?");
//        String movie = console.nextLine();

        // Prompt for Movie Times
        prompts = new String[2];
        prompts[0] = "What time would you like to see this movie?";
        prompts[1] = "1pm - 3pm - 7pm - 9pm";
        System.out.println("What time would you like to see this movie?");
        String movieTime = getString("1pm - 3pm - 7pm - 9pm");
//        System.out.println(" 1pm - 3pm - 7pm - 9pm");
//        String movieTime = console.nextLine();

        // Number of Tickets
//        String ticketInput = getString("How Many Adult Tickets?")
//        System.out.println("How Many Adult Tickets");
//        String ticketInput = console.nextLine();
        int adultTickets = getIntegerFromPrompt("How Many Adult Tickets?");

//        System.out.println("How Many Child Tickets");
//        ticketInput = console.nextLine();
//        int childTickets = Integer.parseInt(ticketInput);
        int childTickets = getIntegerFromPrompt("How Many Child Tickets?");

        // Print Purchase Summary
        printPurchaseSummary(movie, movieTime, adultTickets, childTickets);

//        // Calculate the cost
//        double totalCost = (adultTickets * 11.75) + (childTickets * 8.25); // REMEMBER PEDMAS


//        // Output
//        System.out.println("Purchase complete. Summary: \n");
//        System.out.println("Movie:" + movie);
//        System.out.println("Time" + movieTime);
//        System.out.println("Adult Tickets: " + adultTickets);
//        System.out.println("Child Tickets: " + childTickets );
//        System.out.println("Total Cost:$" + totalCost);
//        System.out.println("Enjoy the show. Please silence all cell phones!!!!");

    }


    public static void printWelcomeMessage(){
        System.out.println("=========Welcome to the Theatre=========");
        System.out.println("Please enter the ticket info below \n");
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        return console.nextLine();
    }

    public static String getString(String[] prompts) {
        for (String prompt : prompts) {
            System.out.println(prompt);
        }
        return console.nextLine();
    }

    public static int getIntegerFromPrompt(String prompt){
        return Integer.parseInt(getString(prompt));
    }

    public static void printPurchaseSummary(String movie, String time, int adultTix, int childTix){
        // Output
        System.out.println("Purchase complete. Summary: \n");
        System.out.println("Movie:" + movie);
        System.out.println("Time" + time);
        System.out.println("Adult Tickets: " + adultTix);
        System.out.println("Child Tickets: " + childTix);
        System.out.println("Total Cost:$" + calculateTotalCost(adultTix, childTix));
        System.out.println("Enjoy the show. Please silence all cell phones!!!!");

    }

    public static double calculateTotalCost(int adultTix, int childTix){
        return (adultTix * 11.75) + (childTix * 8.25);
    }
    
    //TODO Add validation to Integar
}
