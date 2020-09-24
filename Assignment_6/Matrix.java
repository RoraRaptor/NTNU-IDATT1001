
package Assignment_6;

import java.util.ArrayList;
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

//    public Matrix (String str) {
//
//        // Matches groups of ints separated by spaces separated by commas
//        if (str.matches("^(([0-9]+\W)+,)+([0-9]+\W)+$")) {
//            this.matrix = parseMatrixString(str);
//        }
//
//    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix add(Matrix b) {

        if (matrix.length != b.matrix.length || matrix[0].length != b.matrix[0].length) {
            throw new IllegalArgumentException("Addition is undefined for matrices of different dimensions.");
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
            throw new IllegalArgumentException("Matrices incompatible for multiplication.");
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
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return new Matrix(transposedMatrix);
    }

    public int[][] parseMatrixString(String str) {

        String[] matrixRows = str.split(",");

        int matrixColumns = matrixRows[0].split(" ").length;

        int[][] matrix = new int[matrixRows.length][matrixColumns];

        for (int i = 0; i < matrix.length; i++) {

            String[] tempRow = matrixRows[i].split(" ");

            for (int j = 0; j < tempRow.length; j++) {

                matrix[i][j] = Integer.parseInt(tempRow[j].strip());
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter comma-separated rows of space-separated elements of matrices.\n");

        System.out.println("Matrix 1: ");
        String matrixString1 = in.nextLine();
        Matrix matrix1;

//        // Matches groups of ints separated by spaces separated by commas
//        if (matrixString1.matches("^([0-9]+\W)+$")) {
//            matrix1 = new Matrix(matrixString1);
//        }

        System.out.println("Matrix 2: ");
        String matrixString2 = in.nextLine();


        int[][] aElements = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] bElements = {{3, 19, 7}, {6, 1, 4}, {3, 7, 4}};

        Matrix a = new Matrix(aElements);
        Matrix b = new Matrix(bElements);

        Matrix c = a.multiply(b);

        for (double[] row : c.getMatrix()) {
            for (double element : row) {

                System.out.println(element);
            }
        }
    }
}
