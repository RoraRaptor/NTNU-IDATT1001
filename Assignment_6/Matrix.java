package Assignment_6;

import java.util.ArrayList;

public class Matrix {

    double[][] matrix;

    public Matrix (double[][] matrix) {

        this.matrix = new double[matrix.length][matrix[0].length];

        // Store deep copy of the input
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public Matrix add(Matrix b) {

        if (matrix.length != b.matrix.length || matrix[0].length != b.matrix[0].length) {
            throw new IllegalArgumentException("Addition is undefined for matrices of different dimensions.");
        }

        double[][] matrixSum = new double[matrix.length][matrix[0].length];

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
        double[][] matrixSum = new double[matrix.length][b.matrix[0].length];

        double sum = 0;  // Store sums inbetween operations

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

    public static void main(String[] args) {

        double[][] aElements = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] bElements = {{3, 19, 7}, {6, 1, 4}, {3, 7, 4}};

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
