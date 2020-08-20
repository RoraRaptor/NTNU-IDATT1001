# String

All quoted strings are an instance of the `String` class.

```java
String e = ""; // an empty string
String greeting = "Hello";
```

## Substrings

You can copy parts of a string using the `substring` method.

`substring([start position], [end position + 1])`

Ex.
```java
int a = 0;
int b = 3;

String s = greeting.substring(a, b); // "Hel"
```

Computing the length of a substring is easy:

```java
int substringLength = b - a; // 3
```

## Concatenation

You can use `+` to join (concatenate) two strings:

```java
String cake = "monster";
String vehicle = "truck";

String newWord = cake + vehicle; // monstertruck
```

You can join a string with anything, as the other value will be converted to String automatically (as long as it's not `null`):

```java
String finalFantasy7 = "Red" + 13; //Red13
```

You can join multiple strings with a delimiter using the static `join` method:

```java
String all = String.join(" / ", "S", "M", "L", "XL"); // "S / M / L / XL"
```

You can also repeat a string using the `repeat` method:

```java
String batman = "Na".repeat(8) // NaNaNaNaNaNaNaNa
```

## Strings are Immutable

Strings can not be changed. This means that if you want to manipulate a string you need to copy a substring and concatenate it to get the desired result. This requires extra resources, but at the same time the garbage collector cleans up unused strings every now and then, and literal strings share memory to increase efficiency, so it's a tradeoff.

## Testing Strings for Equality

To test whether two strings are equal, use the `equals` method:

```java
"Hello".equals(greeting); // True if "Hello" and greeting are equal
```

To test regardless of case, use `equalsIgnoreCase`:

```java
"Hello".equalsIgnoreCase("hello"); // True
```

## Empty or null Strings

The empty string `""` is a string of length `0`. You can test whether a string is empty by calling

```java
String str = "";

if (str.length() == 0); // True
if (str.equals("")); // True
```

You can also test for an undeclared string, aka a `String` variable that doesn't point to an object:

```java
if (str == null); // False
```

Remember to test for `null` before trying to run any methods on a variable, since a non-existing object does not have any methods, thus that would cause an error.

```java
if (str != null && str.length() != 0) // True
```

## Code Points and Code Units

See "Text Encoding.md".

A *Unicode code unit* is a bit size used by a particular Unicode encoding, e.g. UTF-8 (8 bits), UTF-16 (16 bits) and UTF-32 (32 bits).
A *code point* is a unique integer assigned to each character. To represent one *code point* you may need several *code units*, depending on the encoding.

Java uses UTF-16, which means one code unit in Java has a size of 16 bits, or two bytes.

### Length

The `length` method yields the number of code units (byte pairs since we're using UTF-16) required for a given string. For example:

```java
String greeting = "Hello";
int n = greeting.length(); // 5
```

To get the true length—e.g. the number of code points (or letters, numbers, symbols, etc.)—call the `codePointCount` method:

Syntax:

`[string].codePointCount([start code unit index], [end code unit index]);`

```java
// Looks for code points between the 1st (index 0) code unit and the code unit at index greeting.length() - 1
int cpCount = greeting.codePointCount(0, greeting.length());
```

### Checking Individual Code Units and Code Points

The `i`th code unit:
```java
int i = 3;
char greeting.charAt(i - 1); // Check the 3rd code unit, at index 2
```
The `i`th code point:
```java
int i = 3;
int index = greeting.offsetByCodePoints(0, i); // Count i code points from the code unit at index 0, return the index of the code unit at that position
int codePoint = greeting.codePointAt(index); // The code point at this index, e.g. 'l' if I'm not mistaken.
```

To easily look at all the code points in a string, combine the `codePoints` method with the `toArray` method:
```java
int[] codePoints = greeting.codePoints().toArray(); // An array of all the code points in greeting

for (int i = 0; i < codePoints.length; i++) {
    println(codePoints[i]);
}

// H
// e
// l
// l
// o
```

## Building Strings

Building a string from many different pieces using concatenation would be very inefficient, since you would make a new copy in memory each time you add a piece. A much better alternative is using the `StringBuilder` class, which takes in strings, characters and other values to build a new `String` object.

```java
StringBuilder builder = new StringBuilder();

builder.append(string);
builder.append(character);
builder.append(floatingPointNumber);

String completedString = builder.toString(); // Equivalent of string + character + float, but faster and using less memory
```

## Useful Methods of the `String` Class

See p. 68 in *Core Java Volume 1—Fundamentals Eleventh Edition*. 

TODO