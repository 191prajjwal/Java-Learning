# Integer and Floating-Point Representation in Java

## 1. Integer Representation

### Understanding the `byte` Data Type

Suppose we have the `byte` data type in Java. It occupies **8 bits**.

Using 8 bits, we can represent \(2^8 = 256\) unique bit patterns, which, if interpreted as unsigned integers, represent values from **0 to 255**.

However, Java's `byte` data type must also represent negative integers. Therefore, Java uses **Two's Complement representation** to represent signed integers.

For an 8-bit signed integer, the range is:

* Minimum value: -128
* Maximum value: 127

Hence, the range of Java's `byte` data type is **-128 to 127**.

### How Do We Identify Positive and Negative Integers?

In Two's Complement representation, the **Most Significant Bit (MSB)** indicates the sign when interpreting a bit pattern as a signed integer.

* If MSB = `0`, the integer is non-negative.
* If MSB = `1`, the integer is negative.

Therefore, the maximum positive integer that can be represented using 8 bits is:

`01111111` = 127

The minimum negative integer is:

`10000000` = -128

### How Are Positive Integers Stored and Retrieved?

Positive integers and zero have the same binary representation as their ordinary unsigned binary representation, provided they fit within the positive range.

For example:

```java
byte b = 17;
```

The binary representation of 17 is:

`00010001`

This bit pattern is stored in the variable.

When the value is read, the system interprets the bit pattern as a signed 8-bit integer. Since the MSB is `0`, it is interpreted as a non-negative integer.

Therefore, the retrieved value is **17**.

---

### Negative Integer Representation

Now, suppose we want to store -17.

```java
byte b = -17;
```

Java represents -17 using Two's Complement.

#### Step 1: Find the binary representation of the magnitude

Ignore the negative sign temporarily and convert 17 into 8-bit binary.

`00010001`

#### Step 2: Find the One's Complement

Flip every bit: change `0` to `1` and `1` to `0`.

`00010001` → `11101110`

#### Step 3: Find the Two's Complement

Add 1 to the One's Complement.

```text
  11101110
+ 00000001
----------
  11101111
```

Therefore, the Two's Complement representation of -17 is:

`11101111`

This bit pattern is stored in the variable.

**Important:** Positive integers and zero use their ordinary binary representations within the signed range, while negative integers are represented using Two's Complement.

### How Do We Retrieve a Negative Integer?

Suppose the stored bit pattern is:

`11101111`

#### Step 1: Check the MSB

The MSB is `1`, so the bit pattern represents a negative integer.

#### Step 2: Find the Two's Complement Again

To recover the magnitude, invert the bits and add 1.

First, find the One's Complement:

`11101111` → `00010000`

Now, add 1:

```text
  00010000
+ 00000001
----------
  00010001
```

The resulting binary value is:

`00010001` = 17

#### Step 3: Determine the Sign

Since the original MSB was `1`, the integer is negative.

Therefore, the retrieved value is **-17**.

### Summary

* Java's `byte` data type occupies 8 bits.
* Eight bits provide 256 unique bit patterns.
* Java uses Two's Complement to represent signed integer values.
* The MSB is `0` for non-negative values and `1` for negative values.
* Positive integers and zero use their ordinary binary representations within the signed range.
* Negative integers are represented by taking the Two's Complement of their magnitude.
* When interpreting a negative bit pattern manually, invert the bits and add 1 to recover its magnitude, then apply the negative sign.


## 2. Floating-Point Representation in Java

Unlike integers, floating-point numbers can represent fractional values such as `17.5`, `-3.14`, and very large or very small numbers.

Java uses the **IEEE 754 standard** to represent `float` and `double` values.

### Understanding `float` and `double`

| Feature | `float` | `double` |
|---|---|---|
| Size | 32 bits | 64 bits |
| Sign bit | 1 bit | 1 bit |
| Exponent | 8 bits | 11 bits |
| Fraction | 23 bits | 52 bits |
| Exponent bias | 127 | 1023 |
| Approximate precision | 6–7 decimal digits | 15–16 decimal digits |

Both data types use three fields to represent a floating-point number:

1. **Sign bit** — indicates whether the number is positive or negative.
2. **Exponent** — represents the scale of the number.
3. **Fraction (significand field)** — represents the significant binary digits of the number.

Unlike integer representation, negative floating-point numbers do not use Two's Complement. Instead, the sign is represented separately using the sign bit.

---

### A. `float` Representation (32 Bits)

A `float` uses 32 bits divided into three fields:

- 1 bit for the sign
- 8 bits for the exponent
- 23 bits for the fraction

```text
| Sign (1 bit) | Exponent (8 bits) | Fraction (23 bits) |
```

#### Understanding the Exponent Bias

The exponent is stored using a technique called **biased exponent representation**.

For `float`, the bias is 127.

The formula is:

`Stored Exponent = Actual Exponent + Bias`

Therefore:

`Stored Exponent = Actual Exponent + 127`

For example, if the actual exponent is 4:

`Stored Exponent = 4 + 127 = 131`

The binary representation of 131 is:

`10000011`

This is what gets stored in the exponent field.

To retrieve the actual exponent:

`Actual Exponent = Stored Exponent - Bias`

For example:

`131 - 127 = 4`

**Why do we use a bias?**

The bias allows the exponent to represent both positive and negative exponent values without storing the exponent itself in Two's Complement.

#### Example: Storing `17.5f`

Consider the following Java statement:

```java
float num = 17.5f;
```

**Step 1: Convert the number into binary**

The integer part:

`17` = `10001`

The fractional part:

`.5` = `.1`

Therefore:

`17.5` = `10001.1` in binary.

**Step 2: Normalize the binary number**

Move the binary point until there is exactly one non-zero digit before it.

`10001.1` = `1.00011 × 2⁴`

Here:

- Sign = positive
- Actual exponent = 4
- Significant binary digits = `1.00011`

**Step 3: Determine the sign bit**

Since the number is positive:

`Sign bit = 0`

For a negative number, the sign bit would be `1`.

**Step 4: Calculate the stored exponent**

The bias for `float` is 127.

`Stored Exponent = 4 + 127 = 131`

131 in 8-bit binary is:

`10000011`

Therefore:

`Exponent = 10000011`

**Step 5: Determine the fraction field**

The normalized number is:

`1.00011 × 2⁴`

For a normal floating-point number, the leading `1` is implicit and is not stored in the fraction field.

Therefore, the fraction begins with:

`00011`

Pad the remaining bits with zeros until the fraction contains 23 bits.

`00011000000000000000000`

**Step 6: Combine all three fields**

```text
Sign       Exponent     Fraction
  0        10000011     00011000000000000000000
```

The complete 32-bit representation is:

```text
01000001100011000000000000000000
```

This is the IEEE 754 representation of `17.5f`.

---

### Retrieving the `float` Value

Suppose the stored 32-bit representation is:

```text
01000001100011000000000000000000
```

**Step 1: Read the sign bit**

`Sign = 0`

Therefore, the number is positive.

**Step 2: Retrieve the exponent**

The exponent field is:

`10000011` = 131

Subtract the bias:

`Actual Exponent = 131 - 127 = 4`

**Step 3: Retrieve the significand**

The fraction field is:

`00011000000000000000000`

For a normalized number, add the implicit leading `1`.

Therefore, the significand is:

`1.00011` in binary.

**Step 4: Reconstruct the number**

Use the formula:

`Value = (-1)^Sign × Significand × 2^(Actual Exponent)`

Substitute the values:

`Value = (-1)^0 × 1.00011₂ × 2⁴`

Multiplying by \(2^4\) moves the binary point four places to the right:

`1.00011₂ × 2⁴ = 10001.1₂`

Convert the binary number into decimal:

`10001.1₂ = 17.5₁₀`

Therefore, the retrieved value is:

`17.5`

If the sign bit had been `1`, the reconstructed value would have been `-17.5`.

---

### B. `double` Representation (64 Bits)

The `double` data type follows the same IEEE 754 principles as `float`, but uses 64 bits.

Its fields are:

- 1 bit for the sign
- 11 bits for the exponent
- 52 bits for the fraction

```text
| Sign (1 bit) | Exponent (11 bits) | Fraction (52 bits) |
```

#### Understanding the Exponent Bias

For `double`, the exponent bias is 1023.

The formula is:

`Stored Exponent = Actual Exponent + 1023`

For example, if the actual exponent is 4:

`Stored Exponent = 4 + 1023 = 1027`

1027 in 11-bit binary is:

`10000000011`

To retrieve the actual exponent:

`Actual Exponent = Stored Exponent - 1023`

For example:

`1027 - 1023 = 4`

The bias differs from `float` because the exponent field has a different number of bits.

#### Example: Storing `17.5` as a `double`

Consider the following Java statement:

```java
double num = 17.5;
```

**Step 1: Convert the number into binary**

`17.5` = `10001.1₂`

**Step 2: Normalize the binary number**

`10001.1₂ = 1.00011₂ × 2⁴`

**Step 3: Determine the sign bit**

The number is positive.

`Sign bit = 0`

**Step 4: Calculate the stored exponent**

The bias for `double` is 1023.

`Stored Exponent = 4 + 1023 = 1027`

1027 in 11-bit binary is:

`10000000011`

**Step 5: Determine the fraction field**

The normalized number is:

`1.00011₂ × 2⁴`

The leading `1` is implicit and is not stored.

The fraction field begins with:

`00011`

Pad with zeros until the fraction contains 52 bits.

**Step 6: Combine all three fields**

```text
Sign       Exponent       Fraction
  0        10000000011    0001100000000000000000000000000000000000000000000000
```

This produces the 64-bit IEEE 754 representation of `17.5` as a `double`.

---

### Retrieving the `double` Value

Suppose the stored 64-bit representation corresponds to `17.5`.

**Step 1: Read the sign bit**

`Sign = 0`

Therefore, the number is positive.

**Step 2: Retrieve the exponent**

`Stored Exponent = 1027`

Subtract the bias:

`Actual Exponent = 1027 - 1023 = 4`

**Step 3: Retrieve the significand**

The fraction field represents the binary digits after the implicit leading `1`.

Therefore:

`Significand = 1.00011₂`

**Step 4: Reconstruct the number**

Use the formula:

`Value = (-1)^Sign × Significand × 2^(Actual Exponent)`

Substitute the values:

`Value = (-1)^0 × 1.00011₂ × 2⁴`

`Value = 10001.1₂`

Convert to decimal:

`Value = 17.5`

Therefore, the retrieved value is `17.5`.

---

### Important Notes

- `float` and `double` use IEEE 754 floating-point representation.
- `float` uses a bias of 127, whereas `double` uses a bias of 1023.
- The leading `1` in the significand is implicit for normalized numbers.
- The exponent determines the scale of the number by using a power of 2.
- The sign bit handles positive and negative values independently of the exponent and fraction.
- Floating-point values have finite precision, so some decimal fractions, such as `0.1`, cannot be represented exactly in binary.
- The bit patterns described above apply to normal finite numbers. Zero, subnormal numbers, infinity and NaN use special exponent patterns and require separate rules.
