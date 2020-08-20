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




TODO