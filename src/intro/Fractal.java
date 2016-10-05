package intro;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Fractal {

    public static void main(String[] args) {
        generateFractal(81);
    }

    private static void generateFractal(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            System.out.println();
            for (int col = 0; col < n; col++) {
                matrix[col][row] = 0;
            }
        }
        matrix = fillCenter(matrix);
        printMatrixInHtml(matrix);
        printMatrix(matrix);
        findAllInners(matrix);
    }

    private static void findAllInners(int[][] matrix) {
        int innersCount = matrix.length / 3;
        System.out.println(innersCount);
    }

    private static int[][] fillCenter(int[][] matrix) {
        int margin = matrix.length / 3;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row >= margin && row < matrix[row].length - margin && col >= margin && col < matrix[row].length - margin) {
                    matrix[row][col] = 1;
                }
            }
        }
        if (margin == 1) {
            return matrix;
        }
        int innerMatrixCount = matrix.length / (matrix.length / 3);
        if (innerMatrixCount > 1) {
            for (int row = 0; row < innerMatrixCount; row++) {
                for (int col = 0; col < innerMatrixCount; col++) {
                    int matrixStartRow = row * matrix.length / 3;
                    int matrixEndRow = matrixStartRow + margin - 1;
                    int matrixStartCol = col * matrix.length / 3;
                    int matrixEndCol = matrixStartCol + margin - 1;
                    System.out.println("inner matrix: " + row + " - " + col + "(" + matrixStartRow + "-"+matrixEndRow + ":" + matrixStartCol + "-" + matrixEndCol + ")");
                    int[][] splitedMatrix = splitMatrix(matrix, matrixStartRow, matrixEndRow, matrixStartCol, matrixEndCol);
                    printMatrix(splitedMatrix);
                    int[][] filledMatrix = fillCenter(splitedMatrix);
                    printMatrix(filledMatrix);
                    matrix = mergeMatrix(matrix, splitedMatrix, matrixStartRow, matrixStartCol);
                    printMatrix(matrix);
                }
            }
        }

        return matrix;
    }

    private static int[][] mergeMatrix(int[][] initial, int[][] merger, int startRow, int startCol) {
        int mergerRow = 0;
        for (int row = startRow; row < startRow + merger.length; row++) {
            int mergerCol = 0;
            for (int col = startCol; col < startCol + merger[mergerRow].length; col++) {
                initial[row][col] = merger[mergerRow][mergerCol];
                mergerCol++;
            }
            mergerRow++;
        }
        return initial;
    }

    private static int[][] splitMatrix(int[][] matrix, int rowFrom, int rowTo, int colFrom, int colTo) {
        int[][] splittedMatrix = new int[rowTo - rowFrom + 1][colTo - colFrom + 1];
        int splitedRow = 0;
        for (int row = rowFrom; row <= rowTo; row++) {
            int splitedCol = 0;
            for (int col = colFrom; col <= colTo; col++) {
                splittedMatrix[splitedRow][splitedCol] = matrix[row][col];
                splitedCol++;
            }
            splitedRow++;
        }
        return splittedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println();
            System.out.println();
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%5d", matrix[row][col]);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void printMatrixInHtml(int[][] matrix) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("fractal.html", "UTF-8");
            writer.println("<table  style=\"width: 200px; height: 200px;\">");
            for (int row = 0; row < matrix.length; row++) {
                writer.println("<tr>");
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 1) {
                        writer.println("<td bgcolor=\"blue\"></td>");
                    } else {
                        writer.println("<td bgcolor=\"white\"></td>");
                    }
                }
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
