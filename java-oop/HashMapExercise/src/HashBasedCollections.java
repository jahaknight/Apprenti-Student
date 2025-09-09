import java.util.*;

// Part 1: HashMap<Integar, String>
// Part 2: HashMap<String, List<String>>

public class HashBasedCollections {
    public static void main(String[] args) {
        // Part 1 : Months map
        Map<Integer, String> months = buildMonthsMap();

        System.out.println(" == Part 1: Months (via keySet) == ");
        // keySet(); get all keys, then use each key to read the value
        for (Integer monthNumber : months.keySet()) {
            String monthName = months.get(monthNumber);
            System.out.println(monthNumber + " -> " + monthName);
        }

        // (Optional Bonus) If you want them in numeric order, sort the keys:
        // List<Integar> keys = new ArrayList<>(months.keySet();
        // Collections.sort(keys);
        // for (Integar k: keys) {
        // System.out.println(k + " -> " + months.get(k));
        // }

        // Part 2 : Deck map
        Map<String, List<String>> deck = buildDeckMap();
        System.out.println("\n== Part 2: Full deck ==");
        // Iterate suits (keys), then iterate ranks (the list stored as the value)
        for (String suit : deck.keySet()) {
            List<String> ranks = deck.get(suit);
            for (String rank : ranks) {
                System.out.println(rank + " of " + suit);
            }
        }
    }

    // Helper to build the months map with keys 1...12 and proper names
    private static Map<Integer, String> buildMonthsMap() {
        // Use HashMap:
        Map<Integer, String> months = new HashMap<>();

        // Put 12 entries : key = month number, value = month name
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        return months;
    }

    // Helper to build the deck map: suit -> list of ranks
    private static Map<String, List<String>> buildDeckMap() {
        // Common ranks for all suits
        List<String> ranks = Arrays.asList(
                "Ace", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King"
        );

        Map<String, List<String>> deck = new HashMap<>();

        // Map each suit to the same ranks list
        deck.put("Hearts", ranks);
        deck.put("Diamonds", ranks);
        deck.put("Clubs", ranks);
        deck.put("Spades", ranks);

        return deck;
    }
}
