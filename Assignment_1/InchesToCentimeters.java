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

        boolean validated = true;

        if (d == Double.POSITIVE_INFINITY) { // Positive overflow: d > Double.MAX_VALUE
            
            validated = false;
        }
        
        else if (d == Double.NEGATIVE_INFINITY) { // Negative underflow: d < -Double.MAX_VALUE
            
            validated = false;
        }

        else if (Double.compare(+0.0f, d) == 0) { // Negative underflow: -Double.MIN_VALUE < d < 0
            
            validated = false;
        }

        else if (Double.compare(-0.0f, d) == 0) { // Positive underflow: 0 < d < Double.MIN_VALUE
            
            validated = false;
        }

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

                    if(!validateDouble(parsedInput)) {

                        throw new DoubleFlowException();
                    }

                    inputValidated = true;

                } catch (NumberFormatException e) { // Illegal input, ask again

                    input = JOptionPane.showInputDialog(null, "Oops! We couldn't interpret that as a number.\n\nPlease only input a number like \"3\" or \"12.4\" without the quotation marks.\n\n" + "Inches:", TITLE, JOptionPane.WARNING_MESSAGE);

                } catch (DoubleFlowException e) {

                    input = JOptionPane.showInputDialog(null, "Oops! Due to technical limitations, we couldn't convert that number.\n\nPlease input a new number like \"3\" or \"12.4\" without the quotation marks.\n\n" + "Inches:", TITLE, JOptionPane.WARNING_MESSAGE);

                }

            } while (input != null && !inputValidated); // Repeat if we still have input and it has not been validated

            if (input != null) { // Check again if user canceled
                
                double result = CM_PER_INCH * parsedInput;
            
                // Display results
                JOptionPane.showMessageDialog(null, "Results: " + parsedInput + "\" ➡ " + result + "cm", TITLE, JOptionPane.INFORMATION_MESSAGE);

                // Ask the user for new input. If they enter something, the while loop runs again.
                input = JOptionPane.showInputDialog(null, "Do you want to run the program again? If so, please enter a new number to convert.\n\n" + "Inches:", TITLE, JOptionPane.QUESTION_MESSAGE);
                
            }
        }

        // Display friendly valediction and exit the program
        JOptionPane.showMessageDialog(null, "Thank you for using InchesToCentimeters.", TITLE, JOptionPane.PLAIN_MESSAGE);

    }
}