package Assignment_1;

import javax.swing.JOptionPane;

/**
 * Asks the user for a number of inches and converts it into centimeters.
 * 
 * @author Aurora Schmidt-Brekken Vollvik
 */

public class InchesToCentimeters {

    private static final String TITLE = "InchesToCentimeters";
    private static final double CM_PER_INCH = 2.54d; // Factor to scale the input by

    private static boolean validateDouble(double d) {

        // TODO Fix: When the user inputs signed or plain zeroes they still get an error.
        boolean validated = !(Double.isInfinite(d) || Double.compare(+0.0f, d) == 0 || Double.compare(-0.0f, d) == 0);

        return validated;
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome!\n\n" + "This little program lets you convert inches to centimeters.", TITLE, JOptionPane.PLAIN_MESSAGE);

        // Ask the user how many inches they want to convert
        String input = JOptionPane.showInputDialog(null, "Please enter a number to convert.\n\n" + "Inches:", TITLE, JOptionPane.QUESTION_MESSAGE);
        double parsedInput = 0.0d;
        
        // The control variable starts as false
        boolean inputValidated = false;

        while (input != null) { // Has user already exited/canceled?

            do {

                try { // If no exceptions are thrown, the input is valid and the second statement will be run (except if input evaluates to less than Double.MIN_VALUE)

                    parsedInput = Double.parseDouble(input);

                    if (validateDouble(parsedInput)) {

                        inputValidated = true;
                    
                    } else {

                        throw new DoubleFlowException();
                    }

                } catch (NumberFormatException e) { // Illegal input, ask again

                    input = JOptionPane.showInputDialog(null, "Oops! We couldn't interpret that as a number.\n\nPlease only input a number like \"3\" or \"12.4\" without the quotation marks.\n\n" + "Inches:", TITLE, JOptionPane.WARNING_MESSAGE);

                } catch (DoubleFlowException e) { // Illegal input, ask again

                    input = JOptionPane.showInputDialog(null, "Oops! Due to technical limitations we can't convert this number.\n\nPlease input a different number like \"3\" or \"12.4\" without the quotation marks.\n\n" + "Inches:", TITLE, JOptionPane.WARNING_MESSAGE);

                }

            } while (input != null && !inputValidated); // Repeat if we still have input and it has not been validated

            // TODO Fix: When the user gets an error earlier in the program, this block runs and gives the associated error message, even when the user has input new, valid data 
            if (input != null) { // Check again if user canceled
                
                double result = CM_PER_INCH * parsedInput;

                if (validateDouble(result)) {

                    String resultMessage = "Results: " + parsedInput + "\" ➡ " + result + "cm";
                    //String formattedResultMessage = String.format("Results: %,#.3f\" ➡ %,#.3fcm", parsedInput, result);
            
                    // Display results
                    JOptionPane.showMessageDialog(null, resultMessage, TITLE, JOptionPane.INFORMATION_MESSAGE);

                } else {

                    // Error message
                    JOptionPane.showMessageDialog(null, "Oops! The magnitude of the result is too large or too small (without being zero) to represent in Java's text encoding, so we can't understand it.", TITLE, JOptionPane.INFORMATION_MESSAGE);

                }

                // Ask the user for new input. If they enter something, the while loop runs again.
                input = JOptionPane.showInputDialog(null, "Do you want to run the program again? If so, please enter a new number to convert.\n\n" + "Inches:", TITLE, JOptionPane.QUESTION_MESSAGE);
                
            }
        }

        // Display friendly valediction and exit the program
        JOptionPane.showMessageDialog(null, "Thank you for using InchesToCentimeters.", TITLE, JOptionPane.PLAIN_MESSAGE);

        /* TEST DATA
        ===================================================================================================================
        | Input                            | Expected Output          | Actual Output                                     |
        |==================================|==========================|===================================================|
        | 249                              | 632.46cm                 | 632.46cm                                          |
        | 0                                | 0.0cm                    | "Couldn't interpret" and "Too large or too small" |
        | Text                             | "Couldn't interpret"     | "Couldn't interpret"                              |
        | 0 < num < Double.MIN_VALUE       | "Can't convert"          | "Can't convert"                                   |
        | 0 > num > -Double.MIN_VALUE      | "Can't convert"          | "Can't convert"                                   |
        | num > Double.MAX_VALUE           | "Can't convert"          | "Can't convert"                                   |
        | num < -Double.MAX_VALUE          | "Can't convert"          | "Can't convert"                                   |
        | num > (Double.MAX_VALUE / 2.54)  | "Too large or too small" | "Too large or too small"                          |
        | num < -(Double.MAX_VALUE / 2.54) | "Too large or too small" | "Too large or too small"                          |
        =================================================================================================================*/
    }
}