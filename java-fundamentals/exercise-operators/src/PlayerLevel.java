public class PlayerLevel {

    public static void main(String[] args) {
        //    Declare and initialize variables:
        int currentXP = 1200;
        int level = 5;
        int xpToNextLevel = 1500;

//     1. Use Arithmetic Operators:
//            Add +300 XP when completing a quest (+=).
        currentXP += 300;
//            Reduce xpToNextLevel dynamically as XP increases (-=).
        xpToNextLevel -= 300;
//            Multiply XP if player earns a double XP boost (*=).
        boolean doubleXPBoost = true;
        if (doubleXPBoost) {
            currentXP *= 2;        // multiply XP
            xpToNextLevel -= 300;  // adjust requirement again
            if (xpToNextLevel < 0) xpToNextLevel = 0;
        }
//     2. Use Comparison Operators:
//            Check if currentXP is greater than or equal to xpToNextLevel.
        boolean hasMetXPRequirement = currentXP >= xpToNextLevel;
//            Check if the player has reached Level 10.
        boolean hasReachedLevel10 = level >= 10;
//      3. Use Logical Operators:
//            Determine if the player levels up (XP requirement met AND level < 10).
        boolean levelUp = hasMetXPRequirement && (level < 10);
//            Determine if the player is a pro (Level > 7 OR XP over 5000).
        boolean isPro   = (level > 7) || (currentXP > 5000);
//       4. Print the updated values and level-up status.
        if (levelUp) {
            level++;
            xpToNextLevel = 2000; // reset requirement for demo
        }
        System.out.println("== Gaming: Player Score & Level System ==");
        System.out.println("Current XP: " + currentXP);
        System.out.println("Level: " + level + (hasReachedLevel10 ? " (>= 10)" : ""));
        System.out.println("XP to next level (remaining): " + xpToNextLevel);
        System.out.println("Meets XP requirement? " + hasMetXPRequirement);
        System.out.println("Level up (req met AND level < 10)? " + levelUp);
        System.out.println("Pro (level > 7 OR XP > 5000)? " + isPro);

    }


}
