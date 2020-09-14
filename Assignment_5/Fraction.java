package Assignment_5;

public class Fraction {

    // Storing fraction as doubles to make computation easier
    // Any floating point inaccuracy is irrelevant, as we only care about the natural number parts
    private long numerator;
    private long denominator = 1;

    public Fraction(long numerator) {

        this.numerator = numerator;
    }

    public Fraction(long numerator, long denominator) {

        if (denominator == 0) throw new IllegalArgumentException("Zero denominator.");

        if (denominator < 0) { // Move negative factor from denominator to numerator, if both are negative, cancel out

            this.numerator = numerator * (-1);
            this.denominator = denominator * (-1);

        } else {

            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public static void main(String[] args) {

        System.out.println("Begin Tests" + "\n");

        System.out.println("Test Zero Denominator");

        try {
            Fraction a = new Fraction(0, 0); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        Fraction b = new Fraction(49, 14);
        Fraction c = new Fraction(14, 8);

        System.out.println("Test Cases");
        System.out.println("b: " + b);
        System.out.println("c: " + c + "\n");

        b.add(c);

        System.out.println("Addition");
        System.out.println("b: " + b);
        System.out.println("c: " + c + "\n");

        b.subtract(c);

        System.out.println("Subtraction");
        System.out.println("b: " + b);
        System.out.println("c: " + c + "\n");

        b.multiply(c);

        System.out.println("Multiplication");
        System.out.println("b: " + b);
        System.out.println("c: " + c + "\n");

        b.divide(c);

        System.out.println("Division");
        System.out.println("b: " + b);
        System.out.println("c: " + c + "\n");
    }

    public static long greatestCommonDivisor(long a, long b) {

        // Using the improved Euclidean Algorithm to find the greatest common divisor

        long gcd = 0;

        // Get remainder of division with smaller number until remainder is 0.
        // Then, the GCD is the smaller number.
        do {
            if (a > b) {

                a = a % b;

                if (a == 0) {
                    gcd = b;
                }

            } else {

                b = b % a;

                if (b == 0) {
                    gcd = a;
                }
            }
        } while (gcd == 0); // The common divisor will never be zero, so we can use this as a check

        return gcd;
    }

    public void reduce() {

        // Working variables
        long gcd = Fraction.greatestCommonDivisor(numerator, denominator);

        // Divide numerator and denominator with GCD to reduce
        numerator /= gcd;
        denominator /= gcd;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void add(Fraction b) {

        // Multiply both fractions with the other's denominator to get common denominator, then add
        numerator = (numerator * b.denominator) + (b.numerator * denominator);
        denominator *= b.denominator;

        reduce();
    }

    public void subtract(Fraction b) {

        // Multiply both fractions with the other's denominator to get common denominator, then subtract
        numerator = (numerator * b.denominator) - (b.numerator * denominator);
        denominator *= b.denominator;

        reduce();
    }

    public void multiply(Fraction b) {

        // Multiply numerators and denominators
        numerator *= b.numerator;
        denominator *= b.denominator;

        reduce();
    }

    public void divide(Fraction b) {

        // Multiply numerator with denominator and vice versa
        numerator *= b.denominator;
        denominator *= b.numerator;

        reduce();
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
