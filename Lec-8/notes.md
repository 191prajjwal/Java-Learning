# Java Loops — Quick Notes

## 1. Core idea
- A loop repeats a task while its condition is true.
- A loop condition must evaluate to `boolean`.

## 2. Loop types
- **`while`**: checks the condition before each iteration; may run zero times.
- **`do-while`**: runs once before checking the condition; runs at least once.
- **`for`**: groups initialization, condition, and update in one place.

## 3. `for` loop
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```
- Initialization, condition, and update may be omitted.
- An omitted condition is treated as `true`, creating an infinite loop unless exited.
- Initialization can declare multiple variables of the same type.
- The condition must be one boolean expression; combine checks with `&&` or `||`.
- The update section can contain comma-separated expressions.

## 4. Infinite loops
```java
for (;;) {
    System.out.println("Hello");
}
```
- A loop can become infinite if its condition never becomes false, for example when its counter is never updated.

## 5. `byte` / `short` versus `int` / `long`
- Arithmetic on `byte` and `short` is promoted to `int`.
- `byte s = 1; s = s + 2;` does not compile because `s + 2` is `int`; assigning it back needs a cast.
- Prefer `int` for ordinary loop counters and `long` for larger ranges; `byte` and `short` usually provide no practical performance benefit.

## 6. Nested loops and patterns
- The inner loop runs for each iteration of the outer loop.
- Example:
```java
for (int row = 1; row <= 5; row++) {
    for (int col = 1; col <= row; col++) {
        System.out.print("*");
    }
    System.out.println();
}
```

## 7. `break` and `continue`
- **`break`** exits the nearest enclosing loop.
- **`continue`** skips the rest of the current iteration and starts the next iteration of the nearest enclosing loop.

## 8. Labels
- `break outer;` exits the loop labeled `outer`.
- `continue outer;` skips to the next iteration of the loop labeled `outer`.
- Labels can name blocks too; `break label;` exits the labeled block. `continue` is for loops, not ordinary blocks.

