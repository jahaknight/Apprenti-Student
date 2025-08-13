//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise Code Starts Here:");


        //Sports Statistics
        //1 Declare and assign the following variables related to a soccer player:
        //2 playerName → store the name of a soccer player.
        String playerName = "Lionel Messi";
        //3 jerseyNumber → store the player's jersey number.
        int jerseyNumber = 10;
        //4 position → store the player’s field position (e.g., "Goalkeeper").
        String fieldPosition = "GoalKeeper";
        //5 isStarter → store whether the player is a starter (true or false).
        boolean isStarter = true;
        //6 teamName → store the name of the player’s team.
        String teamName = "Inter Miami";


        //Movie Information
        //1 Declare and assign the following variables for a movie:
        //2 movieTitle → store the title of a movie.
        String movieTitle = "Space Jam";
        //3 releaseYear → store the year the movie was released.
        int releaseYear = 1998;
        //4 rating → store the rating (e.g., "PG-13").
        String rating = "PG-13";
        //5 isSequel → store whether the movie has a sequel (true or false).
        boolean isSequal = false;
        //6 leadActor → store the name of the lead actor.
        String leadActor = "Michael Jordan";


        //Weather Report
        //1. Declare and assign the following variables for a weather forecast:
        //2. cityName → store the name of a city.
        String cityName = "Chicago";
        //3. temperature → store the temperature in Fahrenheit.
        int temperature = 80;
        //4. isRaining → store whether it is currently raining (true or false).
        boolean isRaining = true;
        //5. humidity → store the humidity percentage.
        double humidty = 85.5;
        //6. weatherCondition → store a short description of the weather (e.g. "Cloudy").
        String condition = "Cloudy";



        //Flight Information
        //1 Declare and assign the following variables for a flight at an airport:
        //2 flightNumber → store the flight number (e.g., "AA256").
        String flightNumber = "AA256";
        //3 departureCity → store the departure city (e.g., "New York").
        String departureCity = "New York";
        //4 arrivalCity → store the arrival city (e.g., "Los Angeles").
        String arrivalCity = "London";
        //5 gateNumber → store the gate number for the flight.
        String gateNumber = "B15";
        //6 terminal → store the terminal number at the airport.
        int terminal = 1;
        //7 isDelayed → store whether the flight is delayed (true or false).
        boolean isDelayed = false;



        //Part 2: Printing Variables
        // Use System.out.println() to print each set of variables.
        // Format the output to display meaningful sentences
        System.out.println("My favorite soccer player is " + playerName);
        System.out.println("Their Jersey number is" + jerseyNumber);
        System.out.println("They play" + fieldPosition);
        System.out.println("They are starting the next game: " + isStarter);
        System.out.println("They play for" + teamName);
        System.out.println("My favorite movie is" + movieTitle);
        System.out.println("It was released" + releaseYear);
        System.out.println("It is rated" + rating);
        System.out.println("It is a sequal" + isSequal);
        System.out.println("The lead actor is" + leadActor);
        System.out.println("This is the weather for" + cityName);
        System.out.println("This is the temperature for" + temperature);
        System.out.println("Current forecast is" + isRaining);
        System.out.println("The humidity is: " + humidty + "%");
        System.out.println("The condtions are" + condition);
        System.out.println("We are traveling on " + flightNumber);
        System.out.println("Leaving from" + departureCity);
        System.out.println("Arriving in " + arrivalCity);
        System.out.println("I'll meet you at gate" + gateNumber);
        System.out.println("In Terminal" + terminal);
        System.out.println("The flight is delayed" + isDelayed);




    }
}