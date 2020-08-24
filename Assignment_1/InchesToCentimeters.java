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

        String welcome = "Welcome!\n\n" +
                         "This little program lets you convert inches to centimeters.";

        JOptionPane.showMessageDialog(null, welcome, TITLE, JOptionPane.PLAIN_MESSAGE); // Display greeting

        String input = inputInches(); // Ask the user how many inches they want to convert (reset before asking again)
        double parsedInput = 0;
        
        boolean inputValidated = false; // The control variable starts as false (reset before getting new input)

        while (input != null) { // If input is null the user has quit the program

            do {

                try {

                    parsedInput = Double.parseDouble(input);

                    if (!Double.isInfinite(parsedInput)) { // If input is an actual number, we can use it

                        inputValidated = true;
                    
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

            } while (input != null && !inputValidated); // Repeat if user's input hasn't been validated


            if (input != null) { // Only compute result if the user hasn't quit the program
                
                double result = CM_PER_INCH * parsedInput;

                if (!Double.isInfinite(result)) { // Check that the result makes sense

                    String resultMessage = "Results: " + parsedInput + "\" ➡ " + result + "cm";
                    JOptionPane.showMessageDialog(null, resultMessage, TITLE, JOptionPane.INFORMATION_MESSAGE); // Display result

                    inputValidated = false;
                    input = null;
                    input = inputInches("Do you want to run the program again?", JOptionPane.QUESTION_MESSAGE); // Ask for new number

                } else { // Result is too large, ask again.

                    String resultTooLargeMessage = "Oops! The result is too large to compute!";

                    inputValidated = false;
                    input = null;
                    input = inputInches(resultTooLargeMessage, JOptionPane.WARNING_MESSAGE);

                }
            }
        }

        String goodbye = "Thank you for using InchesToCentimeters.";
        JOptionPane.showMessageDialog(null, goodbye, TITLE, JOptionPane.PLAIN_MESSAGE); // Display friendly valediction and exit the program

        /* TEST DATA
        ===================================================================================================================
        | Input                            | Expected Output          | Actual Output                                     |
        |==================================|==========================|===================================================|
        | 249                              | 632.46cm                 | 632.46cm                                          |
        | 0                                | 0.0cm                    | 0.0cm                                             |
        | Text                             | "Couldn't interpret"     | "Couldn't interpret"                              |
        | num > Double.MAX_VALUE           | "Can't convert"          | "Can't convert"                                   |
        | num < -Double.MAX_VALUE          | "Can't convert"          | "Can't convert"                                   |
        | num > (Double.MAX_VALUE / 2.54)  | "Too large or too small" | "Too large or too small"                          |
        | num < -(Double.MAX_VALUE / 2.54) | "Too large or too small" | "Too large or too small"                          |
        =================================================================================================================*/
    }
}