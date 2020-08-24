package Assignment_1;

import javax.swing.JOptionPane;

/**
 * Asks the user for a number of inches and converts it into centimeters.
 * 
 * @author Aurora Schmidt-Brekken Vollvik
 */

public class InchesToCentimeters {

    private static final String TITLE = "InchesToCentimeters";
    private static final String DEFAULT_MESSAGE = "Please enter a number like \"3\" or \"12.4\" without the quotation marks.\n\nInches:";
    private static final double CM_PER_INCH = 2.54d; // Factor to scale the input by


    private static String inputInches() {

        return JOptionPane.showInputDialog(null, DEFAULT_MESSAGE, TITLE, JOptionPane.QUESTION_MESSAGE);
    }
    
    private static String inputInches(String customMessage, int messageType) {

        String message =  customMessage + "\n\n" + DEFAULT_MESSAGE;

        return JOptionPane.showInputDialog(null, message, TITLE, messageType);
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome!\n\n" + "This little program lets you convert inches to centimeters.", TITLE, JOptionPane.PLAIN_MESSAGE);

        // Ask the user how many inches they want to convert
        String input = inputInches();
        double parsedInput = 0;
        
        // The control variable starts as false
        boolean inputValidated = false;

        while (input != null) { // Has user already exited/canceled?

            do {

                try {

                    parsedInput = Double.parseDouble(input);

                    if (!Double.isInfinite(parsedInput)) {

                        inputValidated = true; // We can use the parsed input
                    
                    } else {

                        String tooLargeMsg = "Oops! This number is too large to compute.";

                        inputValidated = false;
                        input = null;
                        input = inputInches(tooLargeMsg, JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException e) { // Illegal input, ask again

                    String notANumberMsg = "Oops! We couldn't interpret that as a number.";

                    inputValidated = false;
                    input = null;
                    input = inputInches(notANumberMsg, JOptionPane.WARNING_MESSAGE);

                }

            } while (input != null && !inputValidated); // Repeat if we still have input and it has not been validated

            
            if (input != null) { // Check again if user canceled
                
                double result = CM_PER_INCH * parsedInput;

                // Check that the result makes sense
                if (!Double.isInfinite(result)) {

                    String resultMessage = "Results: " + parsedInput + "\" ➡ " + result + "cm";
                    //String formattedResultMessage = String.format("Results: %,#.3f\" ➡ %,#.3fcm", parsedInput, result);
            
                    // Display results
                    JOptionPane.showMessageDialog(null, resultMessage, TITLE, JOptionPane.INFORMATION_MESSAGE);

                    inputValidated = false;
                    input = null;
                    input = inputInches("Do you want to run the program again?", JOptionPane.QUESTION_MESSAGE);

                } else {

                    String resultTooLargeMessage = "Oops! The magnitude of the result is too large or too small (without being zero) " +
                                                   "to represent in Java's text encoding, so we can't understand it.";

                    inputValidated = false;
                    input = null;
                    input = inputInches(resultTooLargeMessage, JOptionPane.WARNING_MESSAGE);

                }
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