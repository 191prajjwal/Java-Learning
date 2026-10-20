
public class Operators {

    public static void print(int value) {
        System.out.println(value);
    }

    public static void main(String[] args) {

        // ==================================================
        // 1. ARITHMETIC OPERATORS
        // ==================================================
        // Arithmetic operators include +, -, *, /, %, +=, -=, *=, /=, %=, ++ and --.
        // They perform mathematical operations on numeric values.

        int a = 5;
        int b = 2;

        print(a + b); // 7
        print(a - b); // 3
        print(a * b); // 10
        print(a / b); // 2 because integer division discards the fractional part.
        print(a % b); // 1 because the remainder after dividing 5 by 2 is 1.

        // ==================================================
        // 2. RELATIONAL OPERATORS
        // ==================================================
        // Relational operators include ==, !=, <, >, <= and >=.
        // They compare values and return a boolean result, either true or false.

        System.out.println(a > b);  // true
        System.out.println(a == b); // false
        System.out.println(a != b); // true
        System.out.println(a <= b); // false

        // ==================================================
        // 3. BITWISE OPERATORS
        // ==================================================
        // Bitwise operators include &, |, ^ and ~, which perform operations on individual bits.
        // During arithmetic and bitwise operations, byte, short and char operands are generally promoted to int.

        int x = 5; // Binary representation: 0000...0101
        int y = 6; // Binary representation: 0000...0110

        // BITWISE AND (&)
        // The AND operator produces 1 only when both corresponding bits are 1.
        print(x & y); // 4 because 0000...0101 & 0000...0110 = 0000...0100.

        // BITWISE OR (|)
        // The OR operator produces 1 when at least one of the corresponding bits is 1.
        print(x | y); // 7 because 0000...0101 | 0000...0110 = 0000...0111.

        // BITWISE XOR (^)
        // The XOR operator produces 1 when the corresponding bits are different and 0 when they are the same.
        print(x ^ y); // 3 because 0000...0101 ^ 0000...0110 = 0000...0011.

        // BITWISE NOT (~)
        // The NOT operator flips every bit of the operand after its promotion to int.
        print(~5);    // -6
        print(~(-4)); // 3

        // The identity ~n = -(n + 1) holds for Java's two's-complement integer representation.

        // ==================================================
        // 4. LEFT SHIFT OPERATOR (<<)
        // ==================================================
        // The left shift operator moves bits to the left and fills the empty rightmost positions with zeros.
        // For int values, only the lowest 5 bits of the shift distance are used, making the effective distance distance % 32.

        /*What does "lowest 5 bits" mean?
Five bits can represent numbers from 00000 to 11111, which is 0 to 31.

Java takes the lowest five bits of the shift distance:
Distance	Binary representation	Lowest 5 bits
32	100000	00000 = 0
33	100001	00001 = 1
35	100011	00011 = 3
64	1000000	00000 = 0
That's why the effective distance is equivalent to distance % 32. */

        int p = 5; // Binary representation: ...00000101
        print(p << 1); // 10 because shifting left by one position gives ...00001010.

        // Left shifting an int by one position is equivalent to multiplying by 2 only when overflow does not affect the result.

        int q = 1;
        q = q << 31;
        print(q); // -2147483648 because the 32-bit result has its most significant bit set.

        int r = 1;
        r = r << 32; // The effective shift distance is 32 % 32 = 0.
        print(r); // 1 because shifting by an effective distance of zero leaves the value unchanged.

        // Shift operations promote byte operands to int, so assigning the result to a byte requires explicit casting.

        byte s = 64;
        s = (byte) (s << 1); // The int result is 128, which becomes -128 when narrowed to byte.
        print(s); // -128

        byte t = -128;
        t = (byte) (t << 1); // The int result is -256, whose lowest 8 bits are all zero.
        print(t); // 0

        // Without narrowing the result back to byte, the full int result is preserved.

        byte u = 64;
        int v = u << 1;
        print(v); // 128

        byte w = -128;
        int z = w << 1;
        print(z); // -256

        // ==================================================
        // 5. SIGNED RIGHT SHIFT OPERATOR (>>)
        // ==================================================
        // The signed right shift operator moves bits to the right and copies the sign bit into the empty leftmost positions.

        int positive = 5;
        print(positive >> 1); // 2 because the bits shift right and the empty leftmost position is filled with zero.

        int negative = -5;
        print(negative >> 1); // -3 because the sign bit is copied into the empty leftmost position.

        // For negative values, signed right shift behaves like division by a power of 2 rounded toward negative infinity, whereas Java integer division truncates toward zero.

        print(-5 / 2);  // -2
        print(-5 >> 1); // -3

        // ==================================================
        // 6. UNSIGNED RIGHT SHIFT OPERATOR (>>>)
        // ==================================================
        // The unsigned right shift operator moves bits to the right and always fills the empty leftmost positions with zeros, regardless of the original sign.

        int positive2 = 5;
        print(positive2 >>> 1); // 2 because shifting a positive number right gives the same result as signed right shift.

        int negative2 = -5;
        print(negative2 >>> 1); // 2147483645 because the leading sign bit is replaced with zero while the remaining bits shift right.

        // The unsigned right shift of a negative int can produce a large positive value because the resulting bit pattern has its most significant bit set to zero.

        // ==================================================
        // 7. LOGICAL OPERATORS
        // ==================================================
        // Logical operators include && (AND), || (OR) and ! (NOT), and they operate on boolean expressions.
        // Logical operators return boolean results and require boolean operands.

        int n = 1;
        int o = 2;
        int p2 = 3;

        boolean result1 = (n < o && p2 > o);
        System.out.println(result1); // true because both conditions are true.

        boolean result2 = (n > o || p2 < n);
        System.out.println(result2); // false because both conditions are false.

        System.out.println(!result2); // true because the NOT operator reverses the boolean value.

        // Expressions such as !n and n && o cause compilation errors because logical operators require boolean operands.

        // ==================================================
        // 8. SHORT-CIRCUIT EVALUATION
        // ==================================================
        // The AND operator (&&) stops evaluating when the left operand is false, while the OR operator (||) stops when the left operand is true.

        boolean condition1 = true;
        boolean condition2 = false;

        System.out.println(condition1 && condition2); // false because both operands are evaluated when the first operand is true.
        System.out.println(condition2 && condition1); // false because the first operand is false, so the second operand is skipped.
        System.out.println(condition1 || condition2); // true because the first operand is true, so the second operand is skipped.
        System.out.println(condition2 || condition1); // true because the first operand is false, so the second operand must be evaluated.

        // Post-increment demonstrates the difference between short-circuit and non-short-circuit evaluation.

        int num1 = 5;
        int num2 = 6;
        int num3 = 6;

        boolean result3 = (num1 > num2) && (num2++ < num1); // The first condition is false, so num2++ is not evaluated and num2 remains 6.

        boolean result4 = (num1 > num3) & (num3++ < num1); // The operator & evaluates both operands, so num3++ executes even though the first condition is false.

        System.out.println(result3 + " " + num2 + " " + result4 + " " + num3); // false 6 false 7

        // ==================================================
        // 9. DIFFERENCE BETWEEN &, | AND &&, ||
        // ==================================================
        // The operators & and | perform bitwise operations on integral values and non-short-circuit logical operations on boolean values.
        // The operators && and || operate only on booleans and provide short-circuit evaluation.

        boolean first = false;
        boolean second = true;

        System.out.println(first & second);  // false because both boolean operands are evaluated.
        System.out.println(first && second); // false because the second operand is skipped when the first operand is false.

        // The results can be identical even though the evaluation behavior differs when the second operand has side effects.

        // ==================================================
        // 10. ASSIGNMENT OPERATORS
        // ==================================================
        // Assignment operators include =, +=, -=, *=, /= and %=, and they assign values to variables.
        // Compound assignment such as number1 += 3 adds 3 to number1 and assigns the result back to it.

        int number1 = 5;
        number1 += 3;
        print(number1); // 8

        // Chained assignment is evaluated from right to left, so the value 9 is assigned to c1, then b1, then a1 and finally number2.

        int a1, b1, c1;
        int number2 = a1 = b1 = c1 = 9;

        System.out.println(number2 + " " + a1 + " " + b1 + " " + c1); // 9 9 9 9

        // The left-hand side of an assignment must be an assignable variable, field or array element, so an expression such as 1 = 2 is invalid.
    }
}
