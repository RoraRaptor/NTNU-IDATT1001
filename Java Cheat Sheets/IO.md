# Input and Output

## Using the Console

Reading:
```java
import java.util.*;

...

Scanner in = new Scanner(System.in); // Set up a Scanner to read input from the console

String input = in.nextLine(); // Reads a line of input, i.e. the return key terminates the input

String word = in.next(); // Reads a single word, i.e. the space key terminates the input

int age = in.nextInt(); // Reads an integer, but fails on other types of input
```

Reading passwords:
```java
Console cons = System.console(); // Use the Console class for reading passwords

String username = cons.readLine("User name: "); // Console can only read whole lines at a time
char[] password = cons.readPassword("Password: "); // Passwords will not be plainly visible, and they will be returned in a character array for security reasons
```

Printing:
```java
System.out.print("How 'you doin'?"); // Prints "How 'you doin'?" to the console
System.out.println("Um, good. How about you?"); // Prints the string followed by a newline character (\n)

/* Output:

    $ How 'you doin'?Um, good. How about you?
    $ 
*/
```

### Formatting Output

TODO

## Dialog Boxes

`javax.swing.JOptionPane` is a class that allows us to get simple user input in a slightly fancier way without having to write our own dialog box code. Later this can be used as part of a larger, much more complex application. Here it is just used for flavor (i.e. it's pointless but the assignments demand we use it anyway). The only things we get from this that we can't easily replicate in the console are things like letting the user choose between a number of options using radio buttons or a dropdown.

The different types of dialog boxes in `JOptionPane` are

* `showMessageDialog`   Show a message and wait for the user to click OK
* `showConfirmDialog`   Show a message and get a confirmation (like OK/Cancel)
* `showOptionDialog`    Show a message and get a user option from a set of options
* `showInputDialog`     Show a message and get one line of user input

### Message

```java
// The method definition
static void showMessageDialog(Component parent, Object message, String title, int messageType, Icon icon)

// Usage example
JOptionPane.showMessageDialog(null, "Click the OK button, please.", "Excuse Me", JOptionPane.PLAIN_MESSAGE, null);

// Simplest use
JOptionPane.showMessageDialog(null, "Here's your message, toots!");
```

### Confirm

```java
// The method definition
static int showConfirmDialog(Component parent, Object message, String title, int optionType, int messageType, Icon icon)

// Usage example
JOptionPane.showConfirmDialog(null, "We will now empty your bank account. Proceed?", "This is NOT a scam", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);

// Simplest use
JOptionPane.showConfirmDialog(null, "Yes, No, or Cancel?");
```

### Option

```java
// The method definition
static int showOptionDialog(Component parent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object default)

// Usage example

String[] options = {"Burger", "Pizza", "Ice Cream"};

JOptionPane.showOptionDialog(null, "Click the OK button, please.", "Please just choose one", JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
```

### Input

```java
// The method definition
static Object showInputDialog(Component parent, Object message, String title, int optionType, int messageType, Icon icon, Object[] values, Object default)

// Usage example
String[] values = {"Aurora", "Chuu", "Sanza"};

JOptionPane.showInputDialog(null, "Which character would you like to play as?", "Select Your Character", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);

// Simplest version
JOptionPane.showInputDialog("Type something here, please!");
```

## File IO


TODO