package Assignment_2;

import java.util.Scanner;

public class LeapYearChecker {

    public static boolean isLeapYear(int year) {

        return ((year % 100 == 0 && year % 400 == 0) || year % 4 == 0);
    }

    public static void main(String[] args) {


        /* TEST DATA
        ===========================================================
        | Input       | Expected Output (h, m, s) | Output        |
        | ============|===========================|===============|
        | 2020        | Leap year                 | Leap year     |
        | 2019        | Not leap year             | Not leap year |
        | 2020.0      | Exception                 | Exception     |
        | 0           | Leap year                 | Leap year     |
        | -4          | Leap year                 | Leap year     |
        | 404         | Leap year                 | Leap year     |
        | UwU         | Exception                 | Exception     |
        =========================================================*/

        // main() treats args[0] as file path with one testing value per line

        // Get year from user
        try (Scanner in = new Scanner(System.in)) {

            System.out.println("Enter a year and find out if it was a leap year: ");
            int year = in.nextInt();
            
            // Check if leap year and print result
            if(isLeapYear(year)) {

                System.out.println("You entered " + year + " which is a leap year!");

            } else {

                System.out.println("You entered " + year + " which is NOT a leap year!");

            }
        }
    }
}