
# Java Conditionals: if-else and switch

## 1. If-Else
- `if` condition must evaluate to `boolean` (`true` or `false`).
- `if (1)` is invalid in Java because `1` is an `int`, not a `boolean`.
- Independent `if` statements execute separately.
- `if-else` executes only one of its two branches.
- Use `if-else` for ranges, comparisons, and complex conditions.

## 2. Switch-Case
- Used to select a branch based on a matching value.
- Traditional switch supports `byte`, `short`, `char`, `int`,
  `String`, and `enum`.
- It does not directly support `long`, `float`, `double`,
  or `boolean` as selector types.
- Use `switch` when checking one expression against fixed values.

## 3. Break and Fall-Through
- `break` exits the switch.
- Without `break`, execution continues into subsequent cases.
- This behavior is called fall-through.
- Execution starts at the matching case, not necessarily at
  the first case.

## 4. Default
- `default` is optional.
- It executes when no case matches.
- It can appear anywhere in a traditional switch.
- Conventionally, place it last for readability.
- If no case matches and there is no default, nothing executes.

## 5. Important Rules
- Duplicate case values are not allowed in the same switch.
- Braces around an entire case are optional.
- Use braces when you need a separate scope for local variables.
- `if-else` and `switch` are chosen based on the problem and
  readability; neither is always faster.

## Quick Memory
- Conditions / ranges     -> if-else
- Fixed choices           -> switch
- Exit the switch         -> break
- No matching case        -> default (if present)
- Continue into next case -> fall-through
