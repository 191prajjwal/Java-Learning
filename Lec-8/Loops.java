public class Loops {
    public static void main(String[] args) {

        // A loop repeats a task while its condition is true.
        // A loop condition must evaluate to boolean.

        // 1. WHILE LOOP
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        // The same loop can be written more compactly using post-increment.
        int j = 1;
        while (j <= 10) {
            System.out.println(j++);
        }

        // 2. DO-WHILE LOOP: runs at least once before checking the condition.
        int k = 1;
        do {
            System.out.println(k);
            k++;
        } while (k <= 10);

        // 3. FOR LOOP
        int l;
        for (l = 0; l < 5; l++) {
            System.out.println(l);
        }

        // Usually, initialize the loop variable inside the for loop.
        for (int m = 0; m < 5; m++) {
            System.out.println(m);
        }

        // 4. INFINITE LOOPS
        int n = 1;
        while (n <= 5) {
            System.out.println("Hello");
            n++; // Remove this increment to see why the loop becomes infinite.
        }

        // for (int o = 1; ; o++) {
        //     System.out.println("Hello");
        // }

        // for (;;) {
        //     System.out.println("Hello");
        // }

        // In a for loop, initialization, condition, and update may be omitted.
        // If the condition is omitted, it is treated as true.

        // 5. MULTIPLE VARIABLES IN A FOR LOOP
        for (int q = 1, r = 0; q < 4; q++, r = r + 2) {
            System.out.println(q + r);
        }

        // Initialization can declare multiple variables of the same type.
        // The condition must be one boolean expression; use && or || to combine checks.
        // The update section can contain comma-separated expressions.

        // for (byte s = 1; s < 50; s = s + 2) {
        //     System.out.println(s);
        // }
        // This does not compile because s + 2 is an int and cannot be assigned to byte without a cast.
        // byte and short arithmetic is promoted to int, so loop counters usually use int or long.
        // int or long counters avoid repeated narrowing conversions and usually offer no benefit from smaller types.

        // 6. NESTED LOOPS: each inner-loop run happens for the current outer-loop iteration.
        for (int s = 1; s <= 5; s++) {
            for (int t = 1; t <= s; t++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 7. BREAK AND CONTINUE
        // break exits the nearest loop; continue skips to the next iteration of the nearest loop.

        // A plain break exits only the inner loop, not the outer loop.
        for (int u = 1; u <= 3; u++) {
            for (int v = 1; v <= 3; v++) {
                System.out.println("*");
                if (v == 2) {
                    break; // Exits only the inner loop.
                }
            }
        }

        // 8. LABELS WITH LOOPS
        // A labeled break can exit the named outer loop.
        outer:
        for (int w = 1; w <= 3; w++) {
            inner:
            for (int x = 1; x <= 3; x++) {
                System.out.println("*");
                if (x == 2) {
                    break outer; // Exits the outer loop entirely.
                }
            }
        }

        // A labeled continue skips the rest of the current outer-loop iteration.
        outer:
        for (int y = 1; y <= 3; y++) {
            inner:
            for (int z = 1; z <= 3; z++) {
                System.out.println(y);
                if (z == 1) {
                    continue outer; // Moves directly to the next iteration of the outer loop.
                }
            }
        }

        // 9. LABELS WITH BLOCKS
        // Labels can name blocks too; break label exits the labeled block.
        first_block: {
            second_block: {
                third_block: {
                    System.out.println("inside block 3");
                }
            }
        }
    }
}
