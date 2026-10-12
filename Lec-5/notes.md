# Java Type Conversion, Type Casting and Type Promotion

## 1. Widening Conversion (Implicit Type Conversion)

Widening conversion means converting a value from a type with a smaller range or representation to a type that can accommodate it more broadly.

Java generally performs widening primitive conversions automatically, without requiring an explicit cast.

### Examples

```java
byte b = 10;
int i = b;

char c = 'a';
int d = c;       // 97

int k = 65;
float fl = k;    // 65.0
```

### Why does it work?

- `byte` to `int`: all possible `byte` values fit in an `int`.
- `char` to `int`: every UTF-16 code unit value fits in an `int`.
- `int` to `float`: Java allows this widening conversion, although sufficiently large integers may lose precision.

**Important:** Widening does not guarantee that every conversion preserves the exact numerical value. For example, `int` to `float` can lose precision.

---

## 2. Narrowing Conversion (Explicit Type Casting)

Narrowing conversion converts a value into a type with a more limited range or precision.

Java generally requires an explicit cast for narrowing primitive conversions because information may be lost.

### Example: `int` to `byte`

```java
int j = 300;

// byte x = j;       // Compile-time error
byte x = (byte) j;

System.out.println(x); // 44
```

### Why does 300 become 44?

A Java `byte` occupies 8 bits and has a signed range of -128 to 127.

The lowest 8 bits of 300 are:

```text
300 = ... 00000001 00101100
                 ↓
             00101100
```

The remaining 8 bits represent 44.

Therefore, the result is `44`.

### What happens when the result is outside the positive range?

```java
int a = 255;
byte b = (byte) a;

System.out.println(b); // -1
```

The lowest 8 bits are `11111111`. Interpreted as a signed Two's Complement value, they represent `-1`.

**Key point:** Explicit narrowing allows a conversion even when the original value cannot be represented exactly in the destination type.

---

## 3. Truncating Conversion

When a floating-point value is converted to an integer type, the fractional part is discarded.

This is a form of narrowing primitive conversion.

### Example

```java
float f = 16.25f;
int g = (int) f;

System.out.println(g); // 16
```

The fractional part `.25` is discarded.

For negative numbers, truncation is toward zero:

```java
System.out.println((int) -16.25f); // -16
```

It does not round to the nearest integer.

**Key point:** Truncation is about discarding the fractional part, whereas narrowing is the broader category of conversions that may lose information.

---

## 4. Boolean Conversion Restrictions

Java does not allow conversion between `boolean` and numeric primitive types.

Neither implicit conversion nor explicit casting is allowed.

```java
boolean bool = true;

// int num = bool;       // Compile-time error
// int num = (int) bool; // Compile-time error
```

**Key point:** `boolean` is not a numeric type in Java.

---

## 5. Type Promotion in Arithmetic Expressions

In Java, arithmetic operations involving `byte`, `short`, and `char` generally promote their operands to `int` before the operation is performed.

### Example

```java
byte a = 10;
byte b = 20;

// byte c = a + b; // Compile-time error
int c = a + b;     // Valid
```

Although `a` and `b` are both `byte`, the expression `a + b` has type `int`.

Therefore, assigning the result directly to a `byte` requires an explicit cast.

```java
byte c = (byte) (a + b);
```

### Why does `byte num2 = 50 * 4;` give an error?

```java
// byte num2 = 50 * 4; // Compile-time error
```

The integer literals `50` and `4` are already of type `int`. Their multiplication produces the `int` value `200`.

Since 200 is outside the range of `byte` (-128 to 127), the assignment is rejected.

However, this example is slightly different:

```java
byte num2 = 50 * 4; // Error: 200 is outside byte range
```

Java permits certain compile-time constant expressions of type `int` to be assigned to `byte`, `short`, or `char` without an explicit cast, **provided the constant value fits in the destination type**.

For example:

```java
byte x = 10 + 20; // Valid: constant result is 30
```

But 200 does not fit in a `byte`, so the assignment fails.

### Fix using explicit casting

```java
byte num2 = (byte) (50 * 4);

System.out.println(num2); // -56
```

The result of `50 * 4` is 200.

Its lowest 8 bits are:

```text
200 = 11001000
```

Since the MSB is `1`, the pattern represents a negative value when interpreted as a signed byte.

Taking the Two's Complement gives a magnitude of 56, so the final value is `-56`.

---

## 6. Quick Revision Table

| Concept | Example | Result |
|---|---|---|
| Widening conversion | `int i = (byte) 10;` | `10` |
| Narrowing conversion | `byte b = (byte) 300;` | `44` |
| Truncating conversion | `(int) 16.25f` | `16` |
| Character conversion | `(int) 'a'` | `97` |
| Boolean conversion | `(int) true` | Not allowed |
| Type promotion | `byte a = 10; byte b = 20; int c = a + b;` | `30` |
| Narrowing after arithmetic | `(byte) (50 * 4)` | `-56` |

## Final Takeaways

- **Widening:** Usually implicit; the destination type can accommodate the source type's entire range.
- **Narrowing:** Usually requires an explicit cast and may lose information.
- **Truncation:** Discards the fractional part when converting a floating-point value to an integer.
- **Type promotion:** Smaller integer types such as `byte`, `short`, and `char` are generally promoted to `int` during arithmetic.
- **Boolean restrictions:** `boolean` cannot be converted to or from numeric primitive types.
- **Constant expressions:** Some `int` constants can be assigned to `byte`, `short`, or `char` without casting if their values fit in the destination type.


### Binary Numeric Promotion Rules

When arithmetic operations are performed on numeric operands, Java applies **binary numeric promotion** to determine the type of the expression.

The priority is:

`double > float > long > int`

The rules are:

1. If either operand is `double`, the expression's type is `double`.
2. Otherwise, if either operand is `float`, the expression's type is `float`.
3. Otherwise, if either operand is `long`, the expression's type is `long`.
4. Otherwise, both operands are promoted to `int`, and the expression's type is `int`.

#### Examples

| Expression | Result type | Reason |
|---|---|---|
| `int + int` | `int` | Both operands are `int` |
| `int + long` | `long` | One operand is `long` |
| `int + float` | `float` | One operand is `float` |
| `long + float` | `float` | `float` has priority over `long` |
| `int + double` | `double` | One operand is `double` |
| `float + double` | `double` | `double` has priority over `float` |
| `byte + byte` | `int` | Both operands are promoted to `int` |

#### Important Note

The expression's result type determines which type is used to evaluate the operation, but it does not automatically determine the type of the variable in which you can store the result.

For example:

```java
int a = 10;
long b = 20L;

long result = a + b; // Valid: a + b has type long

// int result2 = a + b; // Error: long cannot be assigned to int
```

Similarly:

```java
int a = 10;
double b = 20.5;

double result = a + b; // Valid: a + b has type double

// int result2 = a + b; // Error: double cannot be assigned to int
```

**Remember:** `double` takes priority over `float`, `float` takes priority over `long`, and `long` takes priority over `int`. However, `byte`, `short`, and `char` are generally promoted to `int` before arithmetic operations.