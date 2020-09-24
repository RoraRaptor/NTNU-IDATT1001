
package Assignment_6;

import java.util.Scanner;

public class Matrix {

    int[][] matrix;

    public Matrix (int[][] matrix) {

        this.matrix = new int[matrix.length][matrix[0].length];

        // Store deep copy of the input
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix (String inputString) {

        if (inputString == null) {

            throw new IllegalArgumentException("Input can not be null.");
        }

        // Splitting on commas gives us each row of the matrix
        String[] rowStrings = inputString.split(",");
        boolean matching = true;

        for (String rowString : rowStrings) {

            // Matching integers separated by spaces
            if (!rowString.matches("^([ ]*[0-9]+[ ]*)+$")) {

                matching = false;
                break;
            }
        }

        if (!matching) {

            throw new IllegalArgumentException("Could not construct Matrix from input.");
        }

        // Isolate the numbers in the first string and count them
        int columns = rowStrings[0].strip().split("[ ]+").length;
        int[][] newMatrix = new int[rowStrings.length][columns];

        // Attempt to build matrix array
        for (int i = 0; i < rowStrings.length; i++) {

            String[] numberStrings = rowStrings[i].strip().split("[ ]+");

            if (columns == numberStrings.length) {

                // Parse numbers and add to matrix
                for (int j = 0; j < numberStrings.length; j++) {

                    newMatrix[i][j] = Integer.parseInt(numberStrings[j]);
                }

            } else {

                throw new IllegalArgumentException("Rows must have equal number of columns.");
            }
        }


        // Input represents a matrix

        this.matrix = newMatrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix add(Matrix b) {

        if (matrix.length != b.matrix.length || matrix[0].length != b.matrix[0].length) {
//            throw new IllegalArgumentException("Addition is undefined for matrices of different dimensions.");

            return null;
        }

        int[][] matrixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                matrixSum[i][j] = matrix[i][j] + b.matrix[i][j];
            }
        }

        return new Matrix(matrixSum);
    }

    public Matrix multiply(Matrix b) {

        if (matrix.length != b.matrix[0].length) {
//            throw new IllegalArgumentException("Matrices incompatible for multiplication.");

            return null;
        }

        // Column length defined by this, row length defined by b
        int[][] matrixSum = new int[matrix.length][b.matrix[0].length];

        int sum = 0;  // Store sums inbetween operations

        // Multiply rows and columns
        for (int i = 0; i < matrix.length; i++) { // Rows of this

            for (int j = 0; j < b.matrix[0].length; j++) { // Columns of b

                for (int k = 0; k < matrix[0].length; k++) { // Columns of this

                    sum += matrix[i][k] * b.matrix[k][j];
                }

                matrixSum[i][j] = sum;
                sum = 0;
            }
        }

        return new Matrix(matrixSum);
    }

    public Matrix transpose() {

        // Switching row and column lengths
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return new Matrix(transposedMatrix);
    }

    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("{");

        for (int[] row : matrix) {
            str.append("\n\t{");

            for (int element : row) {
                str.append(element).append(", ");
            }

            str.append("},");
        }

        str.append("\n}");

        return str.toString();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter comma-separated rows of space-separated elements of matrices.\n");

        // Setting up Matrix 1 for testing
        System.out.println("Matrix 1: ");
        String matrixString1 = in.nextLine();

        Matrix matrix1 = new Matrix(matrixString1);
        System.out.println("\n" + matrix1 + "\n");

        // Setting up Matrix 2 for testing
        System.out.println("Matrix 2: ");
        String matrixString2 = in.nextLine();

        Matrix matrix2 = new Matrix(matrixString2);
        System.out.println("\n" + matrix2 + "\n");

        // Setting up Matrix 3 for testing
        System.out.println("Matrix 3: ");
        String matrixString3 = in.nextLine();

        Matrix matrix3 = new Matrix(matrixString3);
        System.out.println("\n" + matrix3 + "\n");

        try {

            System.out.println("Addition of Matrix 1 and Matrix 2:\n");
            System.out.println(matrix1.add(matrix2) + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
        }

        try {

            System.out.println("Addition of Matrix 1 and Matrix 3:\n");
            System.out.println(matrix1.add(matrix3) + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
        }

        try {

            System.out.println("Matrix multiplication of Matrix 1 and Matrix 2:\n");
            System.out.println(matrix1.multiply(matrix2) + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
        }

        try {

            System.out.println("Matrix multiplication of Matrix 1 and Matrix 3:\n");
            System.out.println(matrix1.multiply(matrix3) + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
        }

        System.out.println("Transpose of Matrix 1:\n");
        System.out.println(matrix1.transpose() + "\n");

        System.out.println("This concludes the demonstration. Good bye!\n");
    }
}

/*
    Test Strings:

    Matrix 1: 1 4 19, 7 8 2
    Matrix 2: 6 3 5, 0 3 1 (Compatible for addition with Matrix 1)
    Matrix 3: 6 3, 5 0, 3 1 (Compatible for multiplication with Matrix 1)

 */