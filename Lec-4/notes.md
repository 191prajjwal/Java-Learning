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
