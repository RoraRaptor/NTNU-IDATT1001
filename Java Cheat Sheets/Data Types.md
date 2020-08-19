# Data Types in Java

## Primitive Data Types

### Integer Types

| Type    | Storage Requirement | Range (Inclusive)                                       | Default Value |
| ------- | ------------------- | ------------------------------------------------------- | ------------- |
| `int`   | 4 bytes             | -2,147,483,648 to 2,147,483,647                         | 0             |
| `short` | 2 bytes             | -32,768 to 32,767                                       | 0             |
| `long`  | 8 bytes             | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | 0L            |
| `byte`  | 1 byte              | -128 to 127                                             | 0             |

### Floating-Point Types

| Type     | Storage Requirement | Range (Inclusive)                                            | Default Value |
| -------- | ------------------- | ------------------------------------------------------------ | ------------- |
| `float`  | 4 bytes             | ~+/-3.40282347E+38F (6-7 significant decimal digits)         | 0.0f          |
| `double` | 8 bytes             | ~+/-1.79769313486231570E+308 (15 significant decimal digits) | 0.0d          |

### Numeric Literals and Underscores

You can use `_` *between* digits (not next to decimal points or `F` or `L` suffixes) in numerical literals to improve readability, for instance making groups of three digits as in `final int INT_MAX = 2_147_483_647;`

This will be read simply as `2147483647`.

### Char

| Type    | Storage Requirement | Range (Inclusive)                  | Default Value |
| ------- | ------------------- | ---------------------------------- | ------------- |
| `char`  | 2 bytes             | `\u0000` to `\uFFFF` (0 to 65,535) | `\u0000` (0)  |

The `char` type was originally intended to describe individual characters, but today you might need multiple `char` values to describe some Unicode characters.

You can represent `char` values with `\u` sequences (e.g. `\u2122` which is the trademark symbol). This works even in actual code outside of strings or variables; such sequences will evaluate to the associated character before the code is interpreted.

**Warning:** Unintentional `\u` sequences may cause errors as in the comment `// look inside c:\users`. Here you will get a syntax error because `\u` is not followed by four hex digits.

### Boolean

| Type      | Storage Requirement | Range (Inclusive)          | Default Value |
| --------- | ------------------- | ---------------------------| ------------- |
| `boolean` | ?                   | `false` to `true` (0 to 1) | `false` (0)   |

## Reference Types

TODO

### Enumerated Types

If you need to represent something special like *pizza sizes* and you don't want someone to accidentally use an illegal value (i.e. you have sizes `'S'` and `'L'` and someone types in `'g'`) you can create your own type with a set of legal values:

```java
enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE};
```

Now you can declare variables like

```java
Size s = Size.MEDIUM;
```

## Converting Types

TODO