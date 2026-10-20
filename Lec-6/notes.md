
# Java Operators — Quick Notes

## 1. Operator Categories

- **Arithmetic:** `+`, `-`, `*`, `/`, `%`, `++`, `--`, `+=`, `-=`, `*=`, `/=`, `%=`
- **Relational:** `==`, `!=`, `<`, `>`, `<=`, `>=` → returns `boolean`
- **Bitwise:** `&`, `|`, `^`, `~`
- **Shift:** `<<`, `>>`, `>>>`
- **Logical:** `&&`, `||`, `!` → works with booleans
- **Assignment:** `=`, `+=`, `-=`, etc.

## 2. Bitwise Operators

For each bit position:

| Operator | Rule | Example |
|---|---|---|
| `&` AND | 1 only if both bits are 1 | `5 & 6 = 4` |
| `\|` OR | 1 if either bit is 1 | `5 \| 6 = 7` |
| `^` XOR | 1 if bits differ | `5 ^ 6 = 3` |
| `~` NOT | Flips every bit | `~5 = -6` |

**Two's-complement identity:**
`~n = -(n + 1)`

## 3. Shift Operators

- `<<` Left shift: shifts bits left, fills right positions
  with `0`. Often multiplies by powers of 2, provided
  overflow does not change the result.
- `>>` Signed right shift: shifts right and copies the
  sign bit into empty left positions.
- `>>>` Unsigned right shift: shifts right and fills
  empty left positions with `0`.

Examples:
- `5 << 1 = 10`
- `5 >> 1 = 2`
- `-5 >> 1 = -3`
- `-5 >>> 1 = 2147483645`

**Shift distance:**
- `int`: only the lowest 5 bits are used (`distance % 32`).
- `long`: only the lowest 6 bits are used (`distance % 64`).

## 4. Type Promotion and Narrowing

- `byte`, `short`, and `char` operands are promoted to
  `int` during arithmetic and shift operations.
- A shift involving a `byte` produces an `int` result.
- Assigning that result to a `byte` requires explicit casting.
- Narrowing keeps the lowest 8 bits for `byte`; the resulting
  bit pattern is interpreted as a signed value (-128 to 127).

Example:
```java
byte b = 64;
b = (byte) (b << 1); // -128
int x = b << 1;      // -256
```

## 5. Logical Operators and Short-Circuiting

- `&&`: AND — stops if the left operand is `false`.
- `||`: OR — stops if the left operand is `true`.
- `!`: reverses a boolean.

| Operator | Evaluates both operands? |
|---|---|
| `&&` | Not always |
| `||` | Not always |
| `&` on booleans | Yes |
| `|` on booleans | Yes |

`&` and `|` also work bitwise with integral types but dont follow short circuit.

## 6. Assignment Operators

- `x += 5` is equivalent to `x = x + 5` for the
  usual numeric cases, but compound assignment includes
  an implicit cast.
- Chained assignment works right to left:
  `a = b = c = 9;`
- The left side must be an assignable location.
