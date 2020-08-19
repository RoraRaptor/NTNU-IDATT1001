# Java Syntax

## Variables

Variables can be declared and initiated separately;

```
[type] [name];

[name] = [value];
```

or declared and initiated in the same statement;

`[type] [name] = [value];`

### Variable Names

Variable names are *case sensitive* and begin with a letter and be a sequence of letters and or digits.

Letters in Java are defined as `'A'-'Z', 'a'-'z', '_', '$'` or *any* Unicode character that denotes a letter in a language.

Digits in Java are defined as `'0'-'9'` and *any* Unicode character that denotes a digit in a language.

It's good practice to use descriptive variable names where words are separated using `camelCase`.

Ex.
```java
int itemsInShoppingCart;
```

## Constants

Constants are variables preceded by the keyword `final`.

`final [type] [NAME] = [value];`

Constants are *immutable* once they are initialized. That is, their value can only be set once.

### Constant Names

Constant names should be in all uppercase. Words should be separated using `snake_case`.

Ex.
```java
final int RETIREMENT_AGE = 67;
```

## Operators

### Arithmetic Operators

The arithmetic operators `+, -, *` function as in regular Arithmetics. The division operator `/` will function as in regular Arithmetics as long as at least one of the arguments is a floating-point number.

#### Integer Division

The division operator `/` will truncate the remainder if both arguments are integers. This is called integer division.

```java
15.0 / 2; // Floating-point division returns 7.5

15 / 2; // Integer division returns 7
```

#### Integer Remainder (Modulus)

The modulus operator `%` returns the remainder of an integer division.

```java
15 % 2; // The remainder of the integer division above is 1
```

#### Division by Zero

Integer division by 0 raises an `ArithmeticException`, while floating-point division by 0 yields either `NaN`, `INFINITY` or `NEGATIVE_INFINITY` depending on the numerator and signs.