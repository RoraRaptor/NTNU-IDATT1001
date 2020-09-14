package Assignment_5;

import java.util.Random;

public class Randomizer {

    private static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Begin testing upper and lower bounds of nextFloatingPointNumber():\n");

        double lowerBound = -42;
        double upperBound = 69;

        boolean upperBoundGenerated = false;
        boolean lowerBoundGenerated = false;

        double result = 0;

        while (Math.abs(result - upperBound) > 0.000001) {
            result = nextFloatingPointNumber(lowerBound, upperBound);
        }

        upperBoundGenerated = true; // We'll only get here if this is true, within a millionth of the bound

        result = 0;

        while (Math.abs(result - lowerBound) > 0.000001) {
            result = nextFloatingPointNumber(lowerBound, upperBound);
        }

        lowerBoundGenerated = true; // We'll only get here if this is true, within a millionth of the bound

        System.out.println("Results:\n");
        System.out.println("Upper bound generated: " + upperBoundGenerated);
        System.out.println("Lower bound generated: " + lowerBoundGenerated);

        System.out.println("\nBegin testing upper and lower bounds of nextInteger():\n");

        lowerBoundGenerated = false;
        upperBoundGenerated = false;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            double r = nextInteger(-42, 69);

            if (r == 69) {
                upperBoundGenerated = true;
            } else if (r == -42) {
                lowerBoundGenerated = true;
            }
        }

        System.out.println("Results:\n");
        System.out.println("Upper bound generated: " + upperBoundGenerated);
        System.out.println("Lower bound generated: " + lowerBoundGenerated);
    }

    public static int nextInteger(int lowerBound, int upperBound) {

        int range = upperBound - lowerBound - 2; // Not including lowerBound or upperBound

        return random.nextInt(range) + lowerBound + 1;
    }

    public static double nextFloatingPointNumber(double lowerBound, double upperBound) {

        double range = upperBound - lowerBound;

        return random.nextDouble() * range + lowerBound;
    }
}
