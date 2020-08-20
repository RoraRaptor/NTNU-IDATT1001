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

Integer division by 0 raises an `ArithmeticException`, while floating-point division by 0 yields either `NaN`, `INFINITY` or `NEGATIVE_INFINITY`.

Ex.
```java
1 / 0; // ArithmeticException

0.0 / 0; // NaN

1.0 / 0; // INFINITY

-1.0 / 0; // NEGATIVE_INFINITY

1.0 / -0; // NEGATIVE_INFINITY
```

#### Floating-Point Division and Accuracy

The Java Virtual Machine specification initially mandated that all intermediate steps of a floating-point division must be truncated so that all divisions on all virtual machines would be exactly the same. Otherwise you would get cases like;

```java
double w = x * y / z; // on an 80-bit Intel processor
=> (x * y) // Stored intermediately with 80 bits of precision
=> (x * y) / z // Dividing and truncating back to 64 bits of precision
```

which would be faster and more precise, but might yield different results to a machine with only a 64-bit processor. However, the numeric community wanted maximum speed and precision, and so the specification was changed.

If you do want to enforce strict division that is reproducible on all machines, you can tag classes or methods with the `strictfp` keyword:

```java
// All instructions inside this method use strict floating-point computation
public strictfp double reproducibleDivision(a, b) {
    ...
}
```

### Casts

Values of a smaller type will be automatically converted to a larger type when necessary:

```java
double x = 3.0 + 7; // 3.0 + (7 => 7.0) = 10.0
```

However, this doesn't work the other way because there is a risk of losing data by truncating a number to fit into the smaller datatype. You can force lossy type conversions by using casts. They have the syntax:

`[type2] [name] = ([type2]) [variable of type1];`

Ex:
```java
double x = 9.997;
int newX = (int) x; // The fractional part of the x is discarded, and we're left with the integer 9.

double x = 9.997;
int newX = (int) Math.round(x); // Using Math.round() we can get a more accurate conversion, in this case we're left with integer 10
```

**Warning!** Trying to cast from one type to another that is out of range will cause the resulting value to be truncated into a different value.

```java
byte totally300 = (byte) 300; // 42
```

### Combining Assignment with Operators

`x [operation]= y;`

Ex.

```java
int x = 2;

int x *= 3; // 6
```

as opposed to

```java
int x = 2;

int x = x * 3; // 6
```

### Increment and Decrement Operators

The increment and decrement operators add or subtract `1` to or from a variable. They can be postfixed or prefixed to the variable you want to manipulate.

```java
int a = 0;
int b = 0;

++a; // 1
b++; // 1

a--; // 0
--b; // 0
```

The difference between the pre- and postfix versions of these operators are the order in which they work on variables in an expression. The prefix form will increment/decrement first and then evaluate the expression, while the postfix form will evaluate the expression first and then increment the variable. This can be confusing and error-prone, and you should therefore avoid using these operators inside an expression.

```java
int m = 7;
int n = 7;

int a = 2 * ++m; // Increments m by 1 and then calculates 2 * 8 = 16
int b = 2 * n++; // Calculates 2 * 7 = 14, and then increments n by 1.

println("The value of a is " + a + " and the value of m is " + m); // The value of a is 16 and the value of m is 8
println("The value of b is only " + b + " but the value of n is also " + m + "!"); // The value of b is only 14 but the value of n is also 8!
```

### Relational and Boolean Operators

```java
boolean a = (2 == 2); // Equals (true)
boolean b = (1 != 2); // Does not equal (true)
boolean c = (1 < 2);  // Less than (true)
boolean d = (1 > 2);  // Greater than (false)
boolean e = (2 <= 2); // Less than *or* equals (true)
```

```java
boolean f = (d && e); // And (false)
boolean g = (d || e); // Or (true)
```

The logical operators "and" and "or" evaluate to `true` or `false` immediately if this can be determined using the first argument. This can be exploited to avoid errors:

```java
// The division in the second half of the && comparison is never executed if x = 0. Thus we avoid division by zero.
boolean b = ((x != 0) && (1 / x) > (x + y));


// If expression1 is true, we don't check expression2.
boolean c = (expression1 || expression2);
```

The *ternary operator* `?:` can be useful to quickly evaluate statements without using a clunky `if()` statement. If the first argument is true, the second argument is returned. Otherwise, the third argument is returned.

```java
boolean iWantCake = true;

int howManySlices = iWantCake ? 9001 : 0; // I want over nine thousand slices of cake
```

### Bitwise Operators

For any of the integer types, you have operators that can work directly with the bits that make up the integers. This means that you can use masking techniques to get at individual bits in a number. The bitwise operators are:

#### & ("bitwise and")

Compares the bits of both patterns and fills a new pattern with 1's if both original bits are 1, and 0 otherwise.

```
  1010
& 0110
  ----
  0010
```

#### | ("bitwise or")

Compares the bits of both patterns and fills a new pattern with 1's if one or both original bits are 1, and 0 otherwise.

```
  1010
| 0110
  ----
  1110
```

#### ^ ("xor")

Compares the bits of both patterns and fills a new pattern with 1's if *only* one of the original bits are 1, and 0 otherwise.

```
  1010
^ 0110
  ----
  1100
```

#### ~ ("not")

Flips each bit, so 1's become 0's and vice versa.

```
~ 1010
  ----
  0101
```

#### << >> ("bit shift")

The "bit shift" operator shifts the bit pattern of the left argument to the right or left by (right argument) places. It fills with the leftmost digit (the sign of the value).

```
11010001011 >> 2; // 11110100010, shifted to the right two places
11010001011 >> 4; // 11111101000, shifted to the right four places
01010001011 >> 6; // 00000001010, shifted to the right six places (note that the original leftmost digit was 0)
```

#### >>> ("unsigned bit shift")

Does the same as the regular "bit shift" operator, but always fills with zeros.

```
11010001011 >> 2; // 00110100010, shifted to the right two places
11010001011 >> 4; // 00001101000, shifted to the right four places
11010001011 >> 6; // 00000011010, shifted to the right six places
```

#### Testing Individual Bits

By using a bit pattern with only one 1 in a specific location, you can compare it with a number `n` using `&` to confirm. If `n` has a `1` in that location and you divide by the comparison bit pattern, you get an integer `1`. If `n` has a `0` in the specific location, you will get an integer `0`.

```java
int n = [some number];

int fourthBitFromRight = (n & 0b1000) / 0b1000; // Evaluates to the value of the fourth bit from the right in the binary pattern of n
```

You can achieve the same result by shifting `n` to the right by a number of places and simply comparing with `1` using `&`. Because we're comparing with 1 the result can always only be either 1 or 0, no integer division necessary.

```java
int n = [some number];

int fourthBitFromRight = (n >> 3) & 1; // Evaluates to the value of the fourth bit from the right in the binary pattern of n
```

### The instanceof Operator

Compares an object's type to a reference type.

```java
boolean isItAString = ("Hello?" instanceof String); // True
boolean isItAString = ("Is anyone there?" instanceof Math); // False
```

### Operator Hierarchy

| Operators                                 | Associativity |
| ----------------------------------------: | :-----------: |
| `[] .` `()` (method call)                 | ---->         |
| `! ~ ++ --` `+ -` (unary) `()` (cast)     | <----         |
| `* / %`                                   | ---->         |
| `+ -`                                     | ---->         |
| `<< >> >>>`                               | ---->         |
| `< <= > >= instanceof`                    | ---->         |
| `== !=`                                   | ---->         |
| `&`                                       | ---->         |
| `^`                                       | ---->         |
| `\|`                                      | ---->         |
| `&&`                                      | ---->         |
| `\|\|`                                    | ---->         |
| `?:`                                      | <----         |
| `= += -= *= /= %= &= \|= ^= <<= >>= >>>=` | <----         |