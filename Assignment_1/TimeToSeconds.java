package Assignment_1;

/**
 * Converts hours, minutes and seconds into the total number of seconds
 * 
 * @author Aurora Schmidt-Brekken Vollvik
 */

public class TimeToSeconds {

    public static long hoursToSeconds(long h) throws ArithmeticException {

        return Math.multiplyExact(h, 3600);
    }

    public static long minutesToSeconds(long m) throws ArithmeticException {

        return Math.multiplyExact(m, 60);
    }

    public static long getTotalSeconds(long h, long m, long s) throws ArithmeticException {

        long partial = Math.addExact(hoursToSeconds(h), minutesToSeconds(m));

        long sum = Math.addExact(s, partial);

        return sum;
    }

    public static void main(String[] args) {

        /* TEST DATA
        =====================================================================
        | Input (h, m, s)       | Expected Output     | Output              |
        | ======================|=====================|=====================|
        | (9223372036854775807, |                     |                     |
        | 9223372036854775807,  | ArithmeticException | ArithmeticException |
        | 9223372036854775807)  |                     |                     |
        | (0, 0, 0)             | 0                   | 0                   |
        | (-1, -1, -1)          | -3661               | -3661               |
        ===================================================================*/


        // Test variables
        long hours;
        long minutes;
        long seconds;


        // TEST 1
        hours = Long.MAX_VALUE;
        minutes = Long.MAX_VALUE;
        seconds = Long.MAX_VALUE;

        System.out.println("TEST 1:\n");
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + seconds + "\n");

        try {

            long totalSeconds = getTotalSeconds(hours, minutes, seconds);
            System.out.println("Result: " + totalSeconds + "\n");

        } catch (ArithmeticException e) {

            System.out.println("Result: ArithmeticException\n");
        }


        // TEST 2
        hours = 0;
        minutes = 0;
        seconds = 0;

        System.out.println("TEST 2:\n");
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + seconds + "\n");

        try {

            long totalSeconds = getTotalSeconds(hours, minutes, seconds);
            System.out.println("Result: " + totalSeconds + "\n");

        } catch (ArithmeticException e) {

            System.out.println("Result: ArithmeticException\n");
        }


        // TEST 3
        hours = -1;
        minutes = -1;
        seconds = -1;

        System.out.println("TEST 3:\n");
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + seconds + "\n");

        try {

            long totalSeconds = getTotalSeconds(hours, minutes, seconds);
            System.out.println("Result: " + totalSeconds + "\n");

        } catch (ArithmeticException e) {

            System.out.println("Result: ArithmeticException\n");
        }
    }
}