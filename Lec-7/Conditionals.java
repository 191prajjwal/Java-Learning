
public class Conditionals {

    public static void main(String[] args) {

        // ==================================================
        // 1. IF-ELSE
        // ==================================================

        // In Java, an if condition must evaluate to true or false.
        // if (1) is invalid because 1 is an int, not a boolean.

        boolean cond = true;

        // Independent if: executes only when its condition is true.
        if (cond == true) {
            System.out.println("Condition is true");
        }

        // This statement is outside the if block, so it always executes.
        System.out.println("Condition is false");

        // if-else: only one of the two branches executes.
        if (cond == true) {
            System.out.println("Condition is true");
        } else {
            System.out.println("Condition is false");
        }

        // We can write if (cond) instead of if (cond == true).


        // ==================================================
        // 2. SWITCH-CASE: BASIC EXAMPLE
        // ==================================================

        // Traditional switch supports byte, short, char, int, String and enum.
        // It does not directly support long, float, double or boolean.

        int i = 2;

        switch (i) {
            case 1:
                System.out.println("hello 1");
                break;

            case 2:
                System.out.println("hello 2");
                break;

            case 3:
                System.out.println("hello 3");
                break;

            case 4:
                System.out.println("hello 4");
                break;

            default:
                System.out.println("hello default");
        }

        // Since i = 2, only case 2 executes because break exits the switch.
        // default executes when no case matches.


        // ==================================================
        // 3. SWITCH WITH CHAR AND DEFAULT
        // ==================================================

        char c = 'e';

        switch (c) {
            case 'a':
                System.out.println("We entered case a");
                break;

            case 'b':
                System.out.println("We entered case b");
                break;

            default:
                System.out.println("We entered the default case");
                break;

            case 'c':
                System.out.println("We entered case c");
                break;
        }

        // Since c = 'e', default executes because no case matches.
        // default can appear anywhere in a traditional switch.
        // break prevents execution from continuing into case 'c'.


        // ==================================================
        // 4. FALL-THROUGH: SWITCH WITHOUT BREAK
        // ==================================================

        char letter = 'b';

        switch (letter) {
            case 'a':
                System.out.println("We entered case a");

            case 'b':
                System.out.println("We entered case b");

            case 'c':
                System.out.println("We entered case c");

            default:
                System.out.println("We entered the default case");
        }

        // Execution starts at case 'b' because letter = 'b'.
        // Without break, execution continues into case 'c' and default.
        // This behavior is called fall-through.


        // ==================================================
        // 5. IMPORTANT SWITCH RULES
        // ==================================================

        // default is optional and can appear anywhere.
        // Duplicate case values are not allowed in the same switch.
        // break exits the switch and prevents fall-through.
        // If no case matches and default is absent, nothing executes.
        // Braces around an entire case are optional.


        // ==================================================
        // 6. ASSIGNMENT: DAY OF THE WEEK
        // ==================================================

        int day = 3;

        switch (day) {
            case 1:
                System.out.println("It is Monday");
                break;

            case 2:
                System.out.println("It is Tuesday");
                break;

            case 3:
                System.out.println("It is Wednesday");
                break;

            case 4:
                System.out.println("It is Thursday");
                break;

            case 5:
                System.out.println("It is Friday");
                break;

            case 6:
                System.out.println("It is Saturday");
                break;

            case 7:
                System.out.println("It is Sunday");
                break;

            default:
                System.out.println("Invalid day");
        }

        // Since day = 3, the output is "It is Wednesday".
        // default handles invalid inputs such as 0 or 8.
    }
}
