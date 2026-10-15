
public class Type {
    public static void main(String[] args) {

        // ==================================================
        // 1. WIDENING CONVERSION (Implicit Type Conversion)
        // ==================================================

        // byte (1 byte) -> int (4 bytes)
        // Java performs this conversion automatically.

        byte b = 10;
        System.out.println(b); // Output: 10

        int i = b;
        System.out.println(i); // Output: 10


        // int -> float
        // This is also a widening primitive conversion.
        // Very large int values may lose precision when
        // converted to float.

        int k = 65;
        float fl = k;
        System.out.println(fl); // Output: 65.0


        // char -> int
        // char represents a UTF-16 code unit.
        // Widening to int gives its numeric code-unit value.

        char ch = 'a';
        int charValue = ch;
        System.out.println(charValue); // Output: 97


        // ==================================================
        // 2. NARROWING CONVERSION (Explicit Type Casting)
        // ==================================================

        // int (4 bytes) -> byte (1 byte)
        // An explicit cast is required because the value
        // may not fit in the destination type.

        int j = 300;

        // byte narrowed = j; // Compile-time error
        byte narrowed = (byte) j;
        System.out.println(narrowed); // Output: 44

        // Why 44?
        // The lowest 8 bits of 300 are 00101100.
        // 00101100 represents 44 as a signed byte.


        // ==================================================
        // 3. TRUNCATING CONVERSION
        // ==================================================

        // float -> int
        // The fractional part is discarded.
        // Casting truncates toward zero.

        float f = 16.25f;

        // int truncated = f; // Compile-time error
        int truncated = (int) f;
        System.out.println(truncated); // Output: 16

        // Example with a negative value:
        // (int) -16.25f gives -16, not -17.


        // ==================================================
        // 4. BOOLEAN CONVERSION RESTRICTIONS
        // ==================================================

        boolean bool = true;

        // Java does not allow boolean-to-int conversion,
        // either implicitly or through an explicit cast.

        // int num = bool;       // Compile-time error
        // int num = (int) bool; // Compile-time error


        // ==================================================
        // 5. TYPE PROMOTION IN ARITHMETIC EXPRESSIONS
        // ==================================================

        // byte, short and char operands are generally
        // promoted to int during arithmetic operations.
        // The literals 50 and 4 are already of type int.

        // byte num2 = 50 * 4; // Compile-time error:
        // The result is 200, outside the byte range.

        // Explicit casting allows the narrowing conversion.
        byte num2 = (byte) (50 * 4);
        System.out.println(num2); // Output: -56

        // Why -56?
        // The lowest 8 bits of 200 are 11001000.
        // Interpreted as a signed byte, this is -56.


        // ==================================================
        // 6. BINARY NUMERIC PROMOTION
        // ==================================================

        // For numeric operands, the promotion priority is:
        // double > float > long > int
        //
        // If either operand is double, the result is double.
        // Otherwise, if either is float, the result is float.
        // Otherwise, if either is long, the result is long.
        // Otherwise, the result is int.
        //
        // byte, short and char expressions are generally promoted to int
        byte q= 5;
        q=q*1;
        //it will give error because q*q is promoted to int and we are storing it in q which is byte variable.
        //so do explicit typecasting  if you want


        // before these rules are applied.

        // Example 1: int + long -> long

        int a1 = 10;
        long b1 = 20L;
        long result1 = a1 + b1;
        System.out.println(result1); // Output: 30


        // Example 2: int + int -> int

        int a2 = 10;
        int b2 = 20;
        int result2 = a2 + b2;
        System.out.println(result2); // Output: 30


        // Example 3: int + double -> double

        int a3 = 10;
        double b3 = 20.5;
        double result3 = a3 + b3;
        System.out.println(result3); // Output: 30.5


        // Example 4: long + float -> float

        long a4 = 10L;
        float b4 = 20.5f;
        float result4 = a4 + b4;
        System.out.println(result4); // Output: 30.5


        // Example 5: byte + byte -> int

        byte a5 = 10;
        byte b5 = 20;
        int result5 = a5 + b5;
        System.out.println(result5); // Output: 30
    }
}
