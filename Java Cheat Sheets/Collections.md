# Collections

## Array

```java
int[] a = new int[10]; // Initialize integer array with room for 10 integers (array is filled with default values)

int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // The same, but including values.

a.length // 10

b[9] = 9;
b[10] // Exception: Array index out of bounds

String[] names = {"Link",
                  "Navi",
                  "Saria",
                  "Epona",
                  "Volvagia",
                  // Trailing comma is allowed, convenient for lists that are updated over time
};

new int[] { ... }; // Anonymous array

b = new int[] {42, 69, 420}; // Reinitializing using anonymous array

int[] c = new int[0]; // You can initialize empty arrays, e.g. for array-returning functions where the result is empty

c = new int[] {}; // By the way, empty arrays are not null

b.toString(); // [42, 69, 420]

for (int number : b) {
    println(number);
}
// 42
// 69
// 420

int[] aurorasNumbers = {6, 1993, 27};
int[] chuusNumbers = aurorasNumbers; // both variables point to the same array, aka shallow copy - BAD BAD BAD BAD
chuusNumbers = Arrays.copyOf(aurorasNumbers, aurorasNumbers.length); // Make new array with similar contents, aka deep copy. GOOD!

aurorasNumbers = Arrays.copyOf(aurorasNumbers, aurorasNumbers.length * 2); // Makes the same array but twice as long (the end has default values)
aurorasNumbers = Arrays.copyOf(aurorasNumbers, aurorasNumbers.length / 2); // Cuts the array in half
println(aurorasNumbers); // [6]

Arrays.sort(chuusNumbers); // QuickSort -> [6, 27, 1993]
