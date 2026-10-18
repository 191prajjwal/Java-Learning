# Java: `byte` Arithmetic and Type Promotion

1. **Automatic promotion:** During arithmetic, `byte`, `short`, and `char` operands are promoted to `int`, even if the result is small.

2. **Constant expression:** Java allows assigning an `int` constant expression directly to `byte` if the final value fits within the `byte` range (`-128` to `127`).

   ```java
   byte x = 1 * 5;  // ✅ Works: constant value is 5

   byte f= (int) 6; // ✅ works: constant value is 6 

   byte g= (int) 128; //❌ here 128 is int and it goes beyond byte ranmge it will not allow it to store it in byte.
   ```

3. **Variable expression:** Even if the result fits within the `byte` range, Java requires explicit casting when assigning the result to `byte`.

   ```java
   byte a = 1, b = 5;
   byte y = a * b;         // ❌ Error: result is int
   byte z = (byte)(a * b); // ✅ Works
   ```

4. **Why?** Java checks the type of the expression, not its actual runtime value. It doesn't automatically narrow an `int` result to `byte`.

**Key takeaway:** Both `1 * 5` and `a * b` produce an `int`. The difference is that constant expressions get a special assignment exception when their value fits the destination type.
