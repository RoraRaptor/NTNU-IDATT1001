package Assignment_1;

import java.util.Scanner;

/**
 * Converts a number of seconds into hours, minutes and remaining seconds
 * 
 * @author Aurora Schmidt-Brekken Vollvik
 */
public class SecondsToTime {

    public static int toDays(int s) {

        return s / 86400; // One day has 84,400 seconds
    }

    public static int toHours(int s) {

        return s / 3600; // One hour has 3,600 seconds
    }

    public static int toMinutes(int s) {
        
        return s / 60; // One minute has 60 seconds
    }

    public static int[] getHoursMinutesAndSeconds(int s) {
        
        int hours = s / 3600;
        int minutes = s % 3600 / 60; 
        int seconds = s % 3600 % 60;

        int[] result = {hours, minutes, seconds}; 
        
        return result;
    }

    public static void main(String[] args) {
    
        /* TEST DATA
        ===========================================================
        | Input       | Expected Output (h, m, s) | Output        |
        | ============|===========================|===============|
        | 2147483648  | InputMismatchException    | Mismatch      |
        | -2147483649 | InputMismatchException    | Mismatch      |
        | 0.0         | InputMismatchException    | Mismatch      |
        | Hei         | InputMismatchException    | Mismatch      |
        | 1,003       | (0, 16, 43)               | (0, 16, 43)   |
        | 0           | (0, 0, 0)                 | (0, 0, 0)     |
        | 4000        | (1, 6, 40)                | (1, 6, 40)    |
        | -4000       | (-1, -6, -40)             | (-1, -6, -40) |
        =========================================================*/

        System.out.println("--==[SecondsToTime]==--\n\n" +
                               "Enter a whole number of seconds, and get the equivalent in hours, minutes and seconds in return!\n" +
                               "You can enter a maximum of 2,147,483,647 seconds and a minimum of -2,147,483,648 seconds.");

        boolean continueScan = true;

        try (Scanner scan = new Scanner(System.in)) {

            while (continueScan) {

                System.out.print("\nHow many seconds do you want to convert? ");
                int seconds = scan.nextInt();

                int[] time = getHoursMinutesAndSeconds(seconds);
                
                // Printing the result
                System.out.println("\nYou entered " + seconds + " seconds, which is equivalent to:\n" +
                                   time[0] + " hours, " + time[1] + " minutes and " + time[2] + " seconds.\n");

                System.out.print("Would you like to continue? (yes to continue, anything else to exit) ");
                String yesOrNo = scan.next();

                continueScan = yesOrNo.equalsIgnoreCase("yes");
            }
        }
    }
}